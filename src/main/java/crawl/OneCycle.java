package crawl;

import constant.ChannelTypeStr;
import constant.Url;
import fetch.FetchNaver;
import fetch.FetchNaverMap;
import fetch.FetchOnlyUrl;
import lombok.AllArgsConstructor;
import model.Data;
import org.checkerframework.checker.units.qual.A;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@AllArgsConstructor
public class OneCycle {
    private Data data;
    static int trycnt, succnt;

    public int exeOneCycle(){
        if(data.getChannelTypeStr() == ChannelTypeStr.NAVER){
            System.out.println("FetchNaver Start");
            FetchNaver fetchNaver = new FetchNaver(this.data);
            fetchNaver.exe();
        }else if(data.getChannelTypeStr() == ChannelTypeStr.NAVERMAP){
            System.out.println("FetchNaverMap Start");
            FetchNaverMap fetchNaverMap = new FetchNaverMap(this.data);
            fetchNaverMap.exe();
        }else{
            for(String url : Url.fetchUrlList){
                trycnt++;
                System.out.println("FetchOnlyURL Start");
                this.data.setUrl(url.replace("%keyword%", URLEncoder.encode(this.data.getKeyword(), StandardCharsets.UTF_8)));
                FetchOnlyUrl fetchOnlyUrl = new FetchOnlyUrl(this.data);
                succnt += fetchOnlyUrl.exe();
            }
            System.out.printf("\tfetchUrlList OneCycle Finish\n\ttry = %d \n\tsuccess = %d\n",trycnt,succnt);
            return trycnt == succnt ?1:0;
        }

        return 1;
    }
}
