package 面试.base;

//获取Class对象的三种方式
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {

        //以String为例：

        String str="hello world";

        //方式一 ：通过对象的getClass()方法
        Class<?> clazz1 =str.getClass();

        //方式二：通过类的class属性
        Class<?> clazz2 =String.class;

        //方式三：通过Class类的静态方法forName(String className)
        Class<?> clazz3 =Class.forName("java.lang.String");

        System.out.println(clazz1.getName());

        System.out.println(clazz2.getName());

        System.out.println(clazz3.getName());

    }
}
