package com.fzg.entity;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class Test {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(Test.class.getClassLoader().getResourceAsStream("bean.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception{
        String bean = properties.getProperty("bean");
        Class clazz = Class.forName(bean);
        Constructor constructor = clazz.getConstructor(null);
        System.out.println(constructor.newInstance(null));
    }
}
