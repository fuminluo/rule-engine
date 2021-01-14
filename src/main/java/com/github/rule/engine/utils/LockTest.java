package com.github.rule.engine.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 食堂打饭：ReentrantLock公平
 * @Author LuoFuMin
 * @DATE 2021/1/14 16:32
 */
public class LockTest {
    private static final Lock LOCK = new ReentrantLock(true);

    //食堂
    private static class DiningRoom {
        //获取食物
        public void getFood() {
            try {
                System.out.println(Thread.currentThread().getName()+":正在排队");
                LOCK.lock();
                System.out.println(Thread.currentThread().getName()+":@@@@@@打饭中@@@@@@@");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DiningRoom diningRoom = new DiningRoom();
        //让5个同学去打饭
        for (int i=0; i<5; i++) {
            new Thread(()->{
                diningRoom.getFood();
            },"同学编号:00"+(i+1)).start();
        }
    }
}
