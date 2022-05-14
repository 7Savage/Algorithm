package 面试.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> aClass = Class.forName("面试.reflection.TargetObject");
        Method[] methods = aClass.getDeclaredMethods();

        //获得所有方法名
        for (Method method:
             methods) {
            System.out.println(method.getName());
        }

        //获取指定方法并调用
        Method publicMethod = aClass.getDeclaredMethod("publicMethod", String.class);
        TargetObject targetObject = (TargetObject)aClass.newInstance();
        publicMethod.invoke(targetObject,"你很棒");

        //获取指定参数并对参数进行修改
        Field value = aClass.getDeclaredField("value");
        value.setAccessible(true);
        value.set(targetObject,"龙王");

        Method privateMethod = aClass.getDeclaredMethod("privateMethod");
        //为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
