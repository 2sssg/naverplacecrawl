package model;

import constant.ChannelTypeStr;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data {
    private ChannelTypeStr channelTypeStr;
    private String url;
    private String keyword;


}
