package com.zkp.mutilthread.test;


import java.util.ArrayList;
import java.util.List;

/**
 *单线程实现
 */
public class SingleThread implements Calculator {
    @Override
    public long sumUp(int[] calcData) {
        // 此句代码只是为了延长程序运行时间，和程序逻辑无关
        List<SingleThread> tasks = new ArrayList<SingleThread>();

        int calcDataLength = calcData.length;
        long sum = 0l;
        for (int i = 0; i < calcDataLength; i++) {
            sum += calcData[i];

            // 此句代码只是为了延长程序运行时间，和程序逻辑无关
            tasks.add(new SingleThread());
        }
        return sum;
    }
}
