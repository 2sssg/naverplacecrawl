package fetch;

import constant.ConstValue;
import model.Data;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FetchNaver extends FetchBase{
    final static String titleSelector = "div > a> div > div > span._3Apve";
    final static String phoneNumSelector = "._1oH7-._1lPUe";
    public FetchNaver(Data data) {
        super(data);
    }

    public void exe(){
        try{
            System.out.println("getPage : "+ super.data.getUrl());
            System.out.println("getkeyword : "+ super.data.getKeyword());
            //네이버 키기
            super.getPage(super.data.getUrl());
            System.out.println();
            //검색하기
            super.putAndSend(super.data.getKeyword(),"#query","#search_btn");
            System.out.println(super.webDriver.getCurrentUrl());
            //네이버 플레이스 있는지 없는지 확인하기
            if(super.isSelector("#place-app-root")){
                int pageCnt=1;
                if(super.isSelector("div.cmm_pgs._2u3bt > span")){
                    pageCnt = Integer.parseInt(super.webDriver.findElement(By.cssSelector("div.cmm_pgs._2u3bt > span")).getText().split("\n")[3]);
                }
                l: for(int i=0;i<pageCnt; i++){
                    WebElement webElement = super.webDriver.findElement(By.cssSelector("#place-app-root"));
                    List<WebElement> placeOneBlock = webElement.findElements(By.cssSelector("._22p-O.m29At"));
                    for(WebElement w : placeOneBlock){
                        if (super.isSelector(w,"._1oH7-._1lPUe")){
                            if(super.isEqualString(w,titleSelector, ConstValue.CompanyName) && w.findElement(By.cssSelector(phoneNumSelector)).getText().split("\n")[0].equals(ConstValue.phoneNum)){
                                super.scrollDownLoc(w,"div > a");
                                Thread.sleep(5000);
                                super.clickPage(w,"div > a");
                                List<String> tabs = new ArrayList<>(super.webDriver.getWindowHandles());
                                Thread.sleep(10000);
                                super.webDriver = super.webDriver.switchTo().window(tabs.get(1));
                                Thread.sleep(10000);
                                System.out.println(super.webDriver.getCurrentUrl());
                                super.closePage();
                                super.webDriver = super.webDriver.switchTo().window(tabs.get(0));
                                break l;
                            }else{
                                continue;
                            }
                        }
                    }
                    if(super.isSelector("div.cmm_pgs._2u3bt > span")){
                        super.clickPage("a.spnew_bf.cmm_pg_next.on");
                    }
                }
            }else{
                System.out.println("    네이버 플레이스 없음");
            }
            super.crashPage();
        }catch (Exception e){
            System.out.println("ERROR!");
            e.printStackTrace();
        }
    }
}
