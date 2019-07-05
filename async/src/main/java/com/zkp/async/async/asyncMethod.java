package com.zkp.async.async;


import org.springframework.scheduling.annotation.Async;

public class asyncMethod{

    @Async
    public void asyncMethodWithVoidReturnType(){
        System.out.println("Execute method asynchronously."+Thread.currentThread().getName());
    }




}
