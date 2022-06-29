package 面试.设计模式.单例;

import java.io.Serializable;

public class InnerClassSingleton implements Serializable {
    // 私有化构造方法使得该类无法在外部通过 new 进行实例化
    private InnerClassSingleton() {};

    // 将对象实例的定义和初始化放在内部类中完成
    // 之所以这样设计，是因为类的静态内部类在 JVM 中是唯一的，这很好地保障了单例对象的唯一性
    private static class SingletonHolder {
        private static final InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.innerClassSingleton;
    }

    //readResolve方法应对单例对象被序列化
    private Object readResolve() {
        return getInstance();
    }
}
