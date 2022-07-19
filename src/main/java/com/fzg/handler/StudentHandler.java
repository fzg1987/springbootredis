package com.fzg.handler;

import com.fzg.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
public class StudentHandler {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/set")
    public void set(@RequestBody Student student){
        redisTemplate.opsForValue().set("student",student);
    }

    @GetMapping("/get/{key}")
    public Student get(@PathVariable("key") String key){
        return (Student) redisTemplate.opsForValue().get(key);
    }

    @DeleteMapping("/delete/{key}")
    public boolean delete(@PathVariable("key") String key){
        redisTemplate.delete(key);
        return !redisTemplate.hasKey(key);
    }

    @GetMapping("/string")
    public String stringTest(){
        redisTemplate.opsForValue().set("name","Hello world");
        String result = (String) redisTemplate.opsForValue().get("name");
        return result;
    }

    @GetMapping("/list")
    public List<String> listTest(){
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("list","Hello");
        listOperations.leftPush("list","Hello");
        listOperations.leftPush("list","World");
        listOperations.leftPush("list","World");
        listOperations.leftPush("list","Java");
        listOperations.leftPush("list","Java");
        return listOperations.range("list", 0, -1);
    }

    @GetMapping("/set")
    public Set<String> setTest(){
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        setOperations.add("set","Hello");
        setOperations.add("set","Hello");
        setOperations.add("set","World");
        setOperations.add("set","World");
        setOperations.add("set","Java");
        setOperations.add("set","Java");
        return setOperations.members("set");
    }

    @GetMapping("/zset")
    public Set<String> zsetTest(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("zset1","Hello",1);
        zSetOperations.add("zset1","Hello",4);
        zSetOperations.add("zset1","World",7);
        zSetOperations.add("zset1","World",2);
        zSetOperations.add("zset1","Java",5);
        zSetOperations.add("zset1","Java",8);
        return zSetOperations.range("zset1",0,  -1);
    }

    public HashMap<String,HashMap<String,String>> hashmapTest(){
        
    }
}
