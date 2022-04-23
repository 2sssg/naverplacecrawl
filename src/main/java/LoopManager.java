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

public class LoopManager {
    public void crawlLoop(){
        int keywordIndex,channelTypeStrIndex;
        while(true){
            System.out.println("Loop Start");
            Function.execute("kill -9 $(pgrep -f Chrome)");
            keywordIndex = getKeywordIndex();
            channelTypeStrIndex = getCTSIndex();
            Data data = new Data();
            data.setKeyword(Keyword.keyword[keywordIndex]);
            data.setUrl(Url.urlList[channelTypeStrIndex]);
            data.setChannelTypeStr(ChannelTypeStr.values()[channelTypeStrIndex]);
            OneCycle oneCycle = new OneCycle(data);
            oneCycle.exeOneCycle();
//            break;
        }
    }




    public int getKeywordIndex(){
        int keywordIndex;
        keywordIndex = (int)(Math.random() * 100);
        while(keywordIndex >= Keyword.keyword.length){
            keywordIndex = (int)(Math.random() * 100);
        }
        return keywordIndex;
    }
    public int getCTSIndex(){
        int channelTypeStrIndex;
        channelTypeStrIndex = (int)(Math.random() * 100);
        while(channelTypeStrIndex >= ChannelTypeStr.values().length){
            channelTypeStrIndex = (int)(Math.random() * 100);
        }
        return channelTypeStrIndex;
    }
}
