package 面试.reflection;

import org.junit.Test;

//反射的四种形式
public class ReflectionTest {
    @Test
    public static void test() throws ClassNotFoundException {
        //第一种
        Class<ReflectionTest> aClass = ReflectionTest.class;

        //第二种
        Class<?> aClass2 = Class.forName("面试.reflection.TargetObject");

        //第三种
        TargetObject targetObject = new TargetObject();
        Class<? extends TargetObject> aClass3 = targetObject.getClass();

        //第四种
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass4 = systemClassLoader.loadClass("面试.reflection.TargetObject");
    }
}
