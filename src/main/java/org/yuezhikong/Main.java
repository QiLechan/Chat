package org.yuezhikong;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("文心一言聊天测试");
        System.out.println("请输入发送的信息：");
        Scanner scanner = new Scanner(System.in);
        String Question = scanner.nextLine();
        Post.chat(Question);
    }
}