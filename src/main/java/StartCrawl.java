import org.openqa.selenium.chrome.ChromeOptions;

public class StartCrawl {
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "/Users/2sssg/workspace/naverPlaceCrawler/src/main/java/driver/chromedriver";
    public static void main(String[] args) {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        LoopManager loopManager = new LoopManager();
        loopManager.crawlLoop();
    }
}
