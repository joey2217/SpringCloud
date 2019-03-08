package com.joey.jwt;

import com.alibaba.fastjson.JSON;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtApplicationTests {

    @Test
    public void contextLoads() {
    }
    
    @Test
    public void  testJson(){
        Map<String,Object> map= new HashMap<>();
        map.put("1",1);
        map.put("2",1);
        map.put("3",1);
        map.put("4",1);
        JSONObject jsonObject = JSON.parseObject(map.toString());
        
    }

}

