package cn.lastlysly.controller;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-07-31 15:53
 **/
public class MyTest {
    public static void main(String[] args) {
        //注册（请自己手动添加到数据库）
        //密码加密
//        String newPassword = new SimpleHash("MD5","123456","lastly",1024).toString();
        String newPassword = new SimpleHash("MD5","123456","cote",1024).toString();
        System.out.println(newPassword);
    }

}
