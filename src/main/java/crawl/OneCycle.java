package crawl;

import constant.ChannelTypeStr;
import fetch.FetchNaver;
import fetch.FetchNaverMap;
import lombok.AllArgsConstructor;
import model.Data;
import org.checkerframework.checker.units.qual.A;

@AllArgsConstructor
public class OneCycle {
    private Data data;
    public void exeOneCycle(){
        if(data.getChannelTypeStr() == ChannelTypeStr.NAVER){
            System.out.println("FetchNaver Start");
            FetchNaver fetchNaver = new FetchNaver(this.data);
            fetchNaver.exe();
        }else if(data.getChannelTypeStr() == ChannelTypeStr.NAVERMAP){
            System.out.println("FetchNaverMap Start");
            FetchNaverMap fetchNaverMap = new FetchNaverMap(this.data);
            fetchNaverMap.exe();
        }


    }
}
