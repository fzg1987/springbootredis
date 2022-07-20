package com.fzg.entity;

import com.fzg.annotation.MyComponent;
import com.fzg.annotation.MyValue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Class<Dog> dogClass = Dog.class;
        MyComponent annotation = dogClass.getAnnotation(MyComponent.class);
        if (annotation != null){
            System.out.println(dogClass + "添加了MyComponent注解");
            // 创建对象
            Constructor<Dog> constructor = dogClass.getConstructor(null);
            Dog dog = constructor.newInstance(null);
            // 开始赋值
            Field[] fields = dogClass.getDeclaredFields();
            for (Field field : fields) {
                MyValue annotation1 = field.getAnnotation(MyValue.class);
                if(annotation1 != null){
//                    System.out.println(field + "添加了MyValue注解");
                    String value = annotation1.value();
                    field.setAccessible(true);
                    // 判断属性的类型
                    if("java.lang.Integer".equals(field.getType().getName())){
                        Integer val = Integer.parseInt(value);
                        field.set(dog, val);
                    } else {
                        field.set(dog,value);
                    }
//                    System.out.println(field + "注解的值是：" + value);
                }
            }
            System.out.println(dog);
        } else {
            System.out.println("无法创建Dog对象");
        }
    }
}
