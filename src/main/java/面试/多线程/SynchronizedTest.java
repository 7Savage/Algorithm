package 面试.多线程;

public class SynchronizedTest {
    // 1.关键字在实例方法上，锁为当前实例
    public synchronized void instanceLock() {
        // code
    }

    // 2.关键字在代码块上，锁为括号里面的对象，与上面的方法等价
    public void blockLock() {
        synchronized (this) {
            // code
        }
    }

    // 3.关键字在静态方法上，锁为当前Class对象
    public static synchronized void classLock() {
        // code
    }

    // 4.关键字在代码块上，锁为括号里面的对象，与上面的方法等价
    public void blockLock2() {
        synchronized (this.getClass()) {
            // code
        }
    }

    // 5.关键字在代码块上，锁为括号里面的对象
    public void blockLock3() {
        Object o = new Object();
        synchronized (o) {
            // code
        }
    }
}
