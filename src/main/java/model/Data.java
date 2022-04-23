package model;

import constant.ChannelTypeStr;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data {
    //어디서 돌지
    private ChannelTypeStr channelTypeStr;
    // url
    private String url;
    //키워드
    private String keyword;

    public Data(ChannelTypeStr channelTypeStr, String keyword) {
        this.channelTypeStr = channelTypeStr;
        this.keyword = keyword;
    }
}
