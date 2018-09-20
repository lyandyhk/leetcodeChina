package group1;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 两个线程循环打印数字，一个线程打印完转另一个线程打印
 */
public class SleepAndWaitThread2 {
    public static void main(String[] args) {
        OneThread one = new OneThread();
        TwoThread two = new TwoThread();
        one.start();
        two.start();
    }


}

class OneThread extends Thread {



    @Override
    public void run() {
        synchronized (SleepAndWaitThread2.class) {
            while (true) {
                System.out.println("1");
                try {
                    SleepAndWaitThread2.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SleepAndWaitThread2.class.notify();
            }
        }
    }
}

class TwoThread extends Thread {

    @Override
    public void run() {
        synchronized (SleepAndWaitThread2.class) {
            while (true) {
                System.out.println("2");
                SleepAndWaitThread2.class.notify();
                try {
                    SleepAndWaitThread2.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
