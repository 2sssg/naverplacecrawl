package constant;

public class Url {
    public static String[] urlList = {
            "https://www.naver.com",
            "https://map.naver.com/v5",
    };

    //FetchOnlyUrl에서 쓰이는 URL
    // 1 : 네이버 검색
    // 2: 네이버 지도에서 검색
    // 3: 블로그에서 들어갈 때
    // 4: 네이버 플레이스
    public static String[] fetchUrlList = {
        "https://map.naver.com/v5/search/%keyword%/place/1926158846?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=14357421.2283846,4175592.2399535,15,0,0,0,dh",
        "https://map.naver.com/v5/search/%keyword%/place/1926158846?c=14353660.5331591,4188344.3494115,10,0,0,0,dh&placePath=%3Fentry%253Dbmp",
        "https://map.naver.com/v5/entry/place/1926158846?c=14357421.2283846,4175592.2399535,15,0,0,0,dh ",
        "https://m.place.naver.com/place/1926158846/home?entry=ple"
    };
}

