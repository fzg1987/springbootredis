package com.fzg.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Cat {
    @Value("1")
    private Integer id;
    @Value("喵喵")
    private String name;
}
