package com.seecen.dd.xxxsys.dao.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException{
        ThreadImp threadImp = new ThreadImp();
        Thread thread = new Thread(threadImp);
        thread.start();
    }
}
class ThreadImp extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("StartThread-"+(i+1)+":"+new SimpleDateFormat("yyyy/MM/dd hh:mm:ss:Ms").format(new Date()));
            System.out.println("hello world");
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
