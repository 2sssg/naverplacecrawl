import constant.ChannelTypeStr;
import constant.Function;
import constant.Keyword;
import constant.Url;
import crawl.OneCycle;
import model.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestCrawl {
    static int tryCnt, sucCnt;
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "/Users/2sssg/workspace/naverPlaceCrawler/src/main/java/driver/chromedriver";
    public static void main(String[] args) {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        while(true){
            Function.execute("kill -9 $(pgrep -f Chrome)");
            Data data = new Data(ChannelTypeStr.URLSEARCH, Keyword.testkeyword[getKeywordIndex()]);
            System.out.println("\t"+data.getChannelTypeStr());
            OneCycle oneCycle = new OneCycle(data);
            sucCnt =+ oneCycle.exeOneCycle();
            tryCnt++;
            System.out.println("\tLoop try count : " + tryCnt);
            System.out.println("\tLoop success count : " + tryCnt);
        }
    }
    private static int getKeywordIndex(){
        int keywordIndex;
        keywordIndex = (int)(Math.random() * 100);
        while(keywordIndex >= Keyword.testkeyword.length){
            keywordIndex = (int)(Math.random() * 100);
        }
        return keywordIndex;
    }


}
