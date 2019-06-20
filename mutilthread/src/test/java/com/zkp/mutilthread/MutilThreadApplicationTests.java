package com.zkp.mutilthread;

import com.zkp.mutilthread.test.CalcData;
import com.zkp.mutilthread.test.MutilThreadOfForkJoinPool;
import com.zkp.mutilthread.test.MutilThreadOfThreadPoolExecutor;
import com.zkp.mutilthread.test.SingleThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MutilThreadApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void testThread() throws Exception {
        int[] data = CalcData.getCalcData();
        // 单线程测试
        SingleThread singleThread = new SingleThread();
        long startTime = System.currentTimeMillis();
        System.out.println("数组的和： " + singleThread.sumUp(data));
        System.out.println("单线程耗时： " + (System.currentTimeMillis() - startTime) + " ms");

        // 多线程(ThreadPoolExecutor)测试
        MutilThreadOfThreadPoolExecutor threadPool = new MutilThreadOfThreadPoolExecutor();
        startTime = System.currentTimeMillis();
        System.out.println("数组的和： " + threadPool.sumUp(data));
        System.out.println("多线程(ThreadPoolExecutor)耗时： " + (System.currentTimeMillis() - startTime) + " ms");

        // 多线程(ForkJoinPool)测试
        MutilThreadOfForkJoinPool forkJoinPool = new MutilThreadOfForkJoinPool();
        startTime = System.currentTimeMillis();
        System.out.println("数组的和： " + forkJoinPool.sumUp(data));
        System.out.println("多线程(ForkJoinPool)耗时： " + (System.currentTimeMillis() - startTime) + " ms");
    }

}
