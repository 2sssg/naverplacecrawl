import constant.ChannelTypeStr;
import constant.Keyword;
import constant.Url;
import crawl.OneCycle;
import model.Data;

public class LoopManager {
    public void crawlLoop(){
        int keywordIndex,channelTypeStrIndex;
        while(true){
            System.out.println("Loop Start");
            keywordIndex = getKeywordIndex();
            channelTypeStrIndex = getCTSIndex();
            Data data = new Data();
            data.setKeyword(Keyword.keyword[keywordIndex]);
//            data.setUrl(Url.urlList[channelTypeStrIndex]);
//            data.setChannelTypeStr(ChannelTypeStr.values()[channelTypeStrIndex]);
            data.setUrl(Url.urlList[1]);
            data.setChannelTypeStr(ChannelTypeStr.NAVERMAP);
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
