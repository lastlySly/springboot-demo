package cn.lastlysly.myutils.taskdemo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-05-21 16:22
 *
 * 这是定时任务的demo
 **/

//@Component //定义组件,
public class TestTask {
//yyyy-MM-dd HH:mm:ss  中HH是返回24小时制的hh是返回12小时制的
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 定时任务每过3秒执行任务
     */
    //@Scheduled(fixedRate = 3000)注明这是定时任务，，fixedRate = 3000为每3秒一次
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime(){
        System.out.println("现在时间:" + dateFormat.format(new Date()));
    }
}
