package org.yuezhikong;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileManager {
    public void CreateProperties() {
        Properties prop = new Properties();
        try {
            prop.setProperty("API Key", "");
            prop.setProperty("Secret Key", "");
            prop.store(new FileOutputStream("key.properties"), null);
        } catch (IOException ex) {
        }
    }

    public static @NotNull Properties LoadProperties() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("key.properties"));
        } catch (IOException ex) {
        }
        return prop;
    }
}
