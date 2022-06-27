package 面试.多线程;

import org.junit.Test;
//junit不支持多线程！！！在junit单元测试中，当创建了新线程后，单元测试并不会等待主线程下启动的新线程是否执行结束，
// 只要主线程结束完成，单元测试就会关闭，导致主线程中启动的新线程不能顺利执行完！
public class JunitTest {


    @Test
    public void test1() {
        System.out.println("当前线程名："+Thread.currentThread().getName());
        NumThread nt1 = new NumThread("nt1");
        nt1.start();
        //因此当test1()主程序执行完成，不会等待子线程运行完毕，而是直接调用System.exit(0)关闭jvm。
        System.out.println("test启动完成");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        NumThread nt1 = new NumThread("nt1");
        nt1.start();

        System.out.println("Main方法执行完成");
    }
}

class NumThread extends Thread {

    public NumThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            System.out.println(getName() + "|" + i + "|" + sum);
        }
        System.out.println("线程运行完成1");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("catch Exception");
        }

        System.out.println("线程运行完成2");
    }
}
