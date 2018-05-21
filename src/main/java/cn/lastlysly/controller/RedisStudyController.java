package cn.lastlysly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-05-20 16:44
 * 这是整合Redis的demo
 **/
@RestController
@RequestMapping("/redis")
public class RedisStudyController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/redistest")
    public String test(){
        stringRedisTemplate.opsForValue().set("name","lastly");
        String getStr = stringRedisTemplate.opsForValue().get("name");
        return getStr;
    }

}
