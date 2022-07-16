package 面试.多线程;

import java.util.concurrent.*;
/**
 * 创建线程的第一种方式
 */
class PrimeThread extends Thread {
    long minPrime;

    public PrimeThread(long minPrime) {
        this.minPrime = minPrime;
    }

    @Override
    public void run() {
        System.out.println("MyThread-1");
    }
}

/**
 * 创建线程的第二种方式
 */
class PrimeRun implements Runnable {
    long minPrime;

    public PrimeRun(long minPrime) {
        this.minPrime = minPrime;
    }

    @Override
    public void run() {
        System.out.println("MyThread-2");
    }
}

/**
 * 创建线程的第三种方式，与上面两种不同的是，具有返回值
 */
class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }
}
public class ThreadCreateTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        PrimeThread primeThread = new PrimeThread(999);
        primeThread.start();

        PrimeRun primeRun = new PrimeRun(777);
        new Thread(primeRun).start();

        //Callable一般是配合线程池工具ExecutorService来使用的
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        // 注意调用get方法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使用可以设置超时时间的重载get方法。
        System.out.println(result.get());

        /*
          使用上与第一个Demo有一点小的区别。
          首先，调用submit方法是没有返回值的。
          这里实际上是调用的submit(Runnable task)方法，而上面的Demo，调用的是submit(Callable<T> task)方法。
         */
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        executor.submit(futureTask);
        System.out.println(futureTask.get());
    }
}

