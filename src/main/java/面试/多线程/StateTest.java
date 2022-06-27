package 面试.多线程;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class StateTest {

    @Test
    public void testNew() {
        Thread thread = new Thread(() -> {
        });
        System.out.println(thread.getState());//NEW
    }

    @Test
    public void testStart() {
        Thread thread = new Thread(() -> {
        });
        //第一次调用时threadStatus的值是0,调用start方法后threadStatus的值会改变
        thread.start();
        //第二次调用时threadStatus的值不为0，报异常
        thread.start();
    }


    @Test
    public void testWaitNotify() {
        // 创建一个对象lock
        Object lock = new Object();

        // lock.wait()方法调用时会释放锁对象、线程状态变成WAITING、线程进入锁对象的等待队列
        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    if (i == 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("我是第一个线程 i=" + i);
                }
            }
        }).start();

        // 另一个线程，调用同一个对象的 notify/notifyAll 方法
        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    if (i == 3) {
                        //第一个被唤醒后，从等待队列移出，状态变为 RUNNABLE
                        //抢锁成功了，才可以从 wait 方法返回，继续执行。
                        // 如果失败了，状态变成 BLOCKED ，进入同步队列。
                        lock.notify();
                    }
                    System.out.println("我是第二个线程 i=" + i);

                }
            }
        }).start();
    }

    @Test
    public void testPark() {
        // 例子1, unpark、park跟锁无关
        LockSupport.unpark(Thread.currentThread()); // 1
        LockSupport.park(); // 0
        System.out.println("可以运行到这1");
        // 例子2
        LockSupport.unpark(Thread.currentThread()); // 1
        LockSupport.unpark(Thread.currentThread()); // 1
        LockSupport.park(); // 0
        System.out.println("可以运行到这2");
        // 例子3
        LockSupport.unpark(Thread.currentThread()); // 1
        LockSupport.unpark(Thread.currentThread()); // 1
        LockSupport.park(); // 0
        LockSupport.park(); // WAITING
        System.out.println("不可以运行到这3");
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        //Thread.sleep(1000L);
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // TIMED_WAITING
        System.out.println(b.getName() + ":" + b.getState()); // BLOCKED
    }

    @Test
    public void testJoin() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        a.join();//main线程就会等到a线程执行完毕
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出 TERMINATED
        System.out.println(b.getName() + ":" + b.getState());
    }





}
