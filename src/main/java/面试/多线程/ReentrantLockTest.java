package 面试.多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 关于Lock与synchronized关键字在锁的处理上的重要差别
 *
 * 1. 锁的获取方式：前者是通过程序代码的方式由开发者手工获取，后期是通过JVM来获取（无须开发者干预）
 * 2. 具体的实现方式：前者是通过Java代码的方式来实现，后者是通过JVM来获取（无须开发者干预）
 * 3. 锁的释放方式：前者必须通过unlock()方法在finally块中手工释放，后者是通过JVM来释放（无须开发者干预）
 * 4. 锁的具体类型：前者提供了多种，如公平锁、非公平锁，后者与前者均提供了可重入锁
 * */
public class ReentrantLockTest {
    private Lock lock = new ReentrantLock();

    public void method1() {
        try {
            lock.lock();
            System.out.println("invoke method1..");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //lock.unlock();
        }
    }

    public void method2() {
        try {
            lock.lock();
            System.out.println("invoke method2..");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest demo3 = new ReentrantLockTest();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo3.method1();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo3.method2();
            }
        }).start();
    }
}
