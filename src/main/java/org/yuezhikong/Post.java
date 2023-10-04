package org.yuezhikong;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;

public class Post {
    public static String getToken() {
        String url = "https://aip.baidubce.com/oauth/2.0/token?client_id=oagZsELbRzQpBO1AoN2j19Fw&client_secret=9OlUUKqApqxhILBGmjP6LkhYzUEhFVCW&grant_type=client_credentials";
        String result= HttpUtil.post(url, "");
        JSONObject json = JSONUtil.parseObj(result);
        String token = json.getStr("access_token");
        return token;
    }
    public static void chat(String Question){
        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions?access_token=" + getToken();
        KeyBean b1 = new KeyBean();
        b1.setRole("user");
        b1.setContent(Question);
        ArrayList<KeyBean> list = CollUtil.newArrayList(b1);
        JSONArray jsonArray = JSONUtil.parseArray(list);
        JSONObject json = JSONUtil.createObj()
                .put("messages", jsonArray);
        String result = HttpRequest.post(url)
                .header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
                .form(json)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        Console.log(result);
    }
}
