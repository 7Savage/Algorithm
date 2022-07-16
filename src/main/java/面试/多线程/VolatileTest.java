package 面试.多线程;

import org.junit.Test;

public class VolatileTest {
    public static void main(String[] args) {
        MyThread t=new MyThread();
        t.start();
        while (true){
            if (t.isFlag()){
                System.out.println("有点东西");
            }
        }
    }
}

class MyThread extends Thread{
    //如果不加volatile，则main线程不如输出有点东西，因为读不到最新的flag
    volatile boolean flag=false;

    public boolean isFlag(){
        return flag;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=true;
        System.out.println("flag=="+flag);
    }
}
