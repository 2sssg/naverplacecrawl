package fetch;

import lombok.AllArgsConstructor;
import model.Data;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FetchBase {
    protected Data data;
    protected WebDriver webDriver;
    private WebElement webElement;
    public FetchBase(Data data) {
        this.data = data;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        webDriver = new ChromeDriver(options);
    }

    // 페이지 이동
    public void getPage(String url){
        this.webDriver.get(url);
    }

    //페이지 끄기
    public void crashPage(){
        this.webDriver.quit();
    }

    //페이지 끄기
    public void closePage(){
        this.webDriver.close();
    }
    //값 하나 넣고 엔터키 누르기
    public void putAndSend(String putdata, String putPath, String sendPath){
        // 값 넣기
        this.webElement = this.webDriver.findElement(By.cssSelector(putPath));
        this.webElement.sendKeys(putdata);

        //값 보내기
        this.webElement = this.webDriver.findElement(By.cssSelector(sendPath));
        this.webElement.submit();
    }

    //값 넣고 엔터누르기
    public void putAndEnter(String putdata, String putPath){
        // 값 넣기
        this.webElement = this.webDriver.findElement(By.cssSelector(putPath));
        this.webElement.sendKeys(putdata);

        //값 보내기 (엔터)
        this.webElement.sendKeys(Keys.ENTER);
    }

    public void putAndEnter(WebElement webElement,String putdata, String putPath){
        // 값 넣기
        webElement.findElement(By.cssSelector(putPath)).sendKeys(putdata);
        //값 보내기 (엔터)
        webElement.findElement(By.cssSelector(putdata)).sendKeys(Keys.ENTER);
    }

    //셀렉터가 있는지 없는지 확인하기
    public boolean isSelector(String selector){
        return this.webDriver.findElements(By.cssSelector(selector)).size()>0;
    }

    //셀렉터가 있는지 없는지 확인하기
    public boolean isSelector(WebElement webElement,String selector){
        return webElement.findElements(By.cssSelector(selector)).size()>0;
    }

    //String이 같은지 판단
    public boolean isEqualString(WebElement webElement, String cssSelector, String compareString){
        return webElement.findElement(By.cssSelector(cssSelector)).getText().equals(compareString);
    }

    //웹드라이버에서 클릭하기
    public void clickPage(String cssSelector){
        this.webDriver.findElement(By.cssSelector(cssSelector)).click();
    }

    //웹 엘레먼트에서 클릭하기
    public void clickPage(WebElement webElement, String cssSelector){
        webElement.findElements(By.cssSelector(cssSelector)).get(1).click();
    }
    public void realclickpage(WebElement webElement, String cssSelector){
        webElement.findElement(By.cssSelector(cssSelector)).click();
    }

    //특정 위치까지 스크롤하기
    public void scrollDownLoc(WebElement webElement , String cssSelector){
        JavascriptExecutor je = (JavascriptExecutor) this.webDriver;
        je.executeScript("arguments[0].scrollIntoView()",webElement.findElement(By.cssSelector(cssSelector)));
        WebElement html = this.webDriver.findElement(By.tagName("html"));
        html.sendKeys(Keys.PAGE_UP);
    }
    //제일 밑까지 스크롤하기
    public void scrollDown(WebElement webElement){
        JavascriptExecutor je = (JavascriptExecutor) webElement;
        je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void pageDown(){
        WebElement html = this.webDriver.findElement(By.tagName("html"));
        html.sendKeys(Keys.PAGE_DOWN);
    }
}
