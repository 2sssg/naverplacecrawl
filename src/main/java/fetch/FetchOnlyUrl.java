package fetch;

import constant.Url;
import model.Data;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FetchOnlyUrl extends FetchBase{
    public FetchOnlyUrl(Data data) {
        super(data);
    }
    public int exe(){
        try{
            System.out.println("\turl : " + super.data.getUrl());
            System.out.println("\tkeyword : "+ super.data.getKeyword());

            super.getPage(super.data.getUrl());
            Thread.sleep(10000);
            System.out.println("\t10초 기다렸숨 ㅇㅇ");
            super.crashPage();
        }catch (Exception e){
            System.out.println("ERROR!");
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
