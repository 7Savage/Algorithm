package 面试.设计模式.单例;

public class HungrySingleton {
    // 声明为 private 和 static 表明该属性只能在 HungrySingleton 类中被访问且只能被创建一次
    // 定义单例对象时直接创建，调用时直接返回这个对象即可
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    // 私有化构造方法使得该类无法在外部通过 new 进行实例化
    private HungrySingleton() {};

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
