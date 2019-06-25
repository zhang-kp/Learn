package com.zkp.schedulertask.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class Scheduler2Task {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    private void reportCurrentTime(){
        System.out.println("现在时间："+dateFormat.format(System.currentTimeMillis()));
    }

}