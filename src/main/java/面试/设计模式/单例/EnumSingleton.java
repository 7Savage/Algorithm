package 面试.设计模式.单例;

public enum EnumSingleton {
    INSTANCE;
    public void doSomething() {
        System.out.println("doSomething");
    }

    // 调用方法
    public static void main(String[] args) {
        EnumSingleton.INSTANCE.doSomething();
    }
}
