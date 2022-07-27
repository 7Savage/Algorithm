package 面试.设计模式.单例;

public class Singleton {
    // 单例引用使用 volatile 修饰：1.禁止指令重排  2.保证变量可见性
    // 定义单例对象时不创建，调用时再创建，实现 lazy loading 的效果
    private volatile static Singleton singleton;

    // 私有化构造方法使得该类无法在外部通过 new 进行实例化
    private Singleton() {};

    public static Singleton getInstance() {
        if (singleton == null) {                // 1.第一次检查
            synchronized (Singleton.class) {    // 2.在Singleton类对象上加锁，只要是这个类产生的对象，在调用这个方法时都会产生互斥
                if (singleton == null) {        // 3.第二次检查
                    // 这行代码在编译后分为三步执行，为了禁止重排序使用volatile：
                    // 1.为对象分配内存空间
                    // 2.初始化对象
                    // 3.将内存空间的地址赋值给singleton
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
