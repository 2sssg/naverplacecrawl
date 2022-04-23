package constant;

public enum ChannelTypeStr {
    NAVER,NAVERMAP;
    public static ChannelTypeStr toChannelTypeStr(String channelTypeStr){
        if(channelTypeStr.equals(NAVER.toString())){
            return NAVER;
        }else if(channelTypeStr.equals(NAVERMAP.toString())){
            return NAVERMAP;
        }
        return NAVER;
    }
}
