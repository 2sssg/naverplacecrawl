package constant;

public enum ChannelTypeStr {
    NAVER,NAVERMAP,URLSEARCH;
    public static ChannelTypeStr toChannelTypeStr(String channelTypeStr){
        if(channelTypeStr.equals(NAVER.toString())){
            System.out.println("\t얜가???");
            return NAVER;
        }else if(channelTypeStr.equals(NAVERMAP.toString())){
            return NAVERMAP;
        }else if(channelTypeStr.equals(URLSEARCH.toString())){
            System.out.println("\treturn 이거");
            return URLSEARCH;
        }
        return NAVER;
    }
}
