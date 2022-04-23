import constant.ChannelTypeStr;
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
            execute("kill -9 $(pgrep -f Chrome)");
            keywordIndex = getKeywordIndex();
            channelTypeStrIndex = getCTSIndex();
            Data data = new Data();
            data.setKeyword(Keyword.keyword[keywordIndex]);
            data.setUrl(Url.urlList[channelTypeStrIndex]);
            data.setChannelTypeStr(ChannelTypeStr.values()[channelTypeStrIndex]);
//            data.setUrl(Url.urlList[1]);
//            data.setChannelTypeStr(ChannelTypeStr.NAVERMAP);
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

    public static void execute(String cmd) {
        Process process = null;
        Runtime runtime = Runtime.getRuntime();
        StringBuffer successOutput = new StringBuffer(); // 성공 스트링 버퍼
        StringBuffer errorOutput = new StringBuffer(); // 오류 스트링 버퍼
        BufferedReader successBufferReader = null; // 성공 버퍼
        BufferedReader errorBufferReader = null; // 오류 버퍼
        String msg = null; // 메시지

        List<String> cmdList = new ArrayList<String>();

        // 운영체제 구분 (window, window 가 아니면 무조건 linux 로 판단)
        if (System.getProperty("os.name").indexOf("Windows") > -1) {
            cmdList.add("cmd");
            cmdList.add("/c");
        } else {
            cmdList.add("/bin/sh");
            cmdList.add("-c");
        }
        // 명령어 셋팅
        cmdList.add(cmd);
        String[] array = cmdList.toArray(new String[cmdList.size()]);

        try {

            // 명령어 실행
            process = runtime.exec(array);

            // shell 실행이 정상 동작했을 경우
            successBufferReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "EUC-KR"));

            while ((msg = successBufferReader.readLine()) != null) {
                successOutput.append(msg + System.getProperty("line.separator"));
            }

            // shell 실행시 에러가 발생했을 경우
            errorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "EUC-KR"));
            while ((msg = errorBufferReader.readLine()) != null) {
                errorOutput.append(msg + System.getProperty("line.separator"));
            }

            // 프로세스의 수행이 끝날때까지 대기
            process.waitFor();

            // shell 실행이 정상 종료되었을 경우
            if (process.exitValue() == 0) {
                System.out.println("성공");
                System.out.println(successOutput.toString());
            } else {
                // shell 실행이 비정상 종료되었을 경우
                System.out.println("비정상 종료");
                System.out.println(successOutput.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                process.destroy();
                if (successBufferReader != null) successBufferReader.close();
                if (errorBufferReader != null) errorBufferReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
