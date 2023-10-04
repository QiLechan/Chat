package org.yuezhikong;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;
public class getToken {
    public getToken() {
        String url = "https://aip.baidubce.com/oauth/2.0/token?client_id=oagZsELbRzQpBO1AoN2j19Fw&client_secret=9OlUUKqApqxhILBGmjP6LkhYzUEhFVCW&grant_type=client_credentials";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");
        String result= HttpUtil.post("https://www.baidu.com", paramMap);
    }
}
