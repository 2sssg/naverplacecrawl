package fetch;

import lombok.extern.log4j.Log4j;
import model.Data;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;
import java.util.Arrays;
import java.util.List;

public class FetchNaverMap extends FetchBase{
    private WebElement webElement;

    public FetchNaverMap(Data data) {
        super(data);
    }
    public void exe(){
        try{
            System.out.println("getPage : "+ super.data.getUrl());
            super.getPage(super.data.getUrl());
            System.out.println("검색 키워드 : "+ super.data.getKeyword());
            Thread.sleep(10000);
            super.putAndEnter(super.data.getKeyword(),".input_search.ng-pristine");
            System.out.println("검색까지는 함");
            Thread.sleep(5000);
            System.out.println("5초기다림ㅇㅇ");
            super.webDriver.switchTo().frame(super.webDriver.findElement(By.cssSelector("#searchIframe")));
            this.webElement = super.webDriver.findElement(By.cssSelector("#_pcmap_list_scroll_container"));
            super.clickPage("ul > li:nth-child(1)");
            for(int i=0; i<20; i++){
                Thread.sleep(500);
                super.pageDown();
            }

            if(super.isSelector(this.webElement,"ul>li")){
                int searchCnt = this.webElement.findElements(By.cssSelector("ul>li")).size();
                List<WebElement> placeOneBlock = this.webElement.findElements(By.cssSelector("ul>li"));
                for(WebElement w: placeOneBlock){
                    if(super.isEqualString(w,"a:nth-child(1) > div > div > span._3Apve","신항만가스")&&super.isEqualString(w,"div > div > span > a > span._3hCbH","부산 사하구 신평동")){
                        System.out.println("find element");
                        super.realclickpage(w,"a:nth-child(1) > div > div > span._3Apve");
                        Thread.sleep(10000);
                        break;
                    }
                }
                super.crashPage();
                System.out.println("fetch end");
            }
        }catch (Exception e){
            System.out.println("ERROR!");
            e.printStackTrace();
        }
    }


}
