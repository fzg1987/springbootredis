package com.fzg.entity;

import com.fzg.annotation.MyComponent;
import com.fzg.annotation.MyValue;
import lombok.Data;

@Data
@MyComponent
public class Dog {
    @MyValue("2")
    private Integer id;
    @MyValue("汪汪")
    private String name;
}
