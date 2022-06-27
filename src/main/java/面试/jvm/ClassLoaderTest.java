package 面试.jvm;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取应用类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@28d93b30

        //获取引导类加载器
        ClassLoader bootStrapClassLoader = extClassLoader.getParent();
        System.out.println(bootStrapClassLoader);//null

        //用户自定义类来说：默认都是用应用类加载器加载的
        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //String类使用的是引导类加载器加载的->Java核心类库都是用引导类加载器加载的
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);

    }
}
