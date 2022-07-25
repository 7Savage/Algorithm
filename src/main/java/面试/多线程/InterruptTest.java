package 面试.多线程;

public class InterruptTest {
    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");

                //如果该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛出 InterruptedException，
                // 从而提前结束该线程。但是不能中断 I/O 阻塞和 synchronized 锁阻塞。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MyThread1();
        thread1.start();
        thread1.interrupt();
        System.out.println("Main run");
    }
}
