package org.yuezhikong;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

import static org.yuezhikong.ConfigFileManager.LoadProperties;

public class Main {
    public static void CreateProperties(){
        ConfigFileManager prop = new ConfigFileManager();
        prop.CreateProperties();
    }
    public static void main(String[] args) {
        if (!(new File("key.properties").exists())){
            System.out.println("目录下没有检测到配置文件，正在创建");
            CreateProperties();
        }
        @NotNull Properties prop = LoadProperties();
        String APIKey = prop.getProperty("API Key");
        String SecretKey = prop.getProperty("Secret Key");
        if (Objects.equals(APIKey, "") || Objects.equals(SecretKey, "")){
            System.out.println("请在目录下的“key.properties”中填写API Key和Secret Key");
        }
        else{
            System.out.println("文心一言聊天测试");
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入发送的信息：");
                String Question = scanner.nextLine();
                Post.chat(Question,APIKey,SecretKey);
            }
        }
    }
}