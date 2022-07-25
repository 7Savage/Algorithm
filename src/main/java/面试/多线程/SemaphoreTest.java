package 面试.多线程;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore往往用于资源有限的场景中，去限制线程的数量。举个例子，我想限制同时只能有3个线程在工作
 */
public class SemaphoreTest {
    static class MyThread implements Runnable {
        private Integer value;
        private Semaphore semaphore;

        public MyThread(Integer value, Semaphore semaphore) {
            this.value = value;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获取permit
                System.out.println(String.format("当前线程是%d, 还剩%d个资源，还有%d个线程在等待",
                        value, semaphore.availablePermits(), semaphore.getQueueLength()));
                // 睡眠随机时间，打乱释放顺序
                Random random = new Random();
                Thread.sleep(random.nextInt(1000));
                System.out.println(String.format("线程%d释放了资源", value));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // 释放permit
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread(i, semaphore)).start();
        }
    }
}

