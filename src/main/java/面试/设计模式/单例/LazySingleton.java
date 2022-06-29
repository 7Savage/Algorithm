package 面试.设计模式.单例;

public class LazySingleton {
    // 声明为 private 和 static 表明该属性只能在 LazySingleton 类中被访问且只能被创建一次
    // 定义单例对象时不创建，调用时再创建
    private static LazySingleton lazySingleton;

    // 私有化构造方法使得该类无法在外部通过 new 进行实例化
    private LazySingleton() {};

    // 定义一个加锁的静态方法获取该对象
    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
