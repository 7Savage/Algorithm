package 面试.base;

//获取Class对象的三种方式
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {

        //以String为例：
        //静态属性初始化是在加载类的时候初始化，而非静态属性初始化是 new 类实例对象的时候初始化
        String str="hello world";

        //方式一 ：通过对象的getClass()方法
        //对类进行静态初始化、非静态初始化，返回引用运行时真正所指的对象（因为子对象的引用可能会赋给父对象的引用变量中）所属的类的 Class 对象
        Class<?> clazz1 =str.getClass();

        //方式二：通过类的class属性，
        // Class.class 的形式会使 JVM 将使用类装载器将类装入内存（前提是类还没有装入内存），不做类的初始化工作，返回 Class 对象。
        Class<?> clazz2 =String.class;

        //方式三：通过Class类的静态方法forName(String className)
        //装入类并做类的静态初始化，返回 Class 对象，
        //还会对类进行解释，执行类中的static块。
        //而classLoader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
        Class<?> clazz3 =Class.forName("java.lang.String");

        System.out.println(clazz1.getName());

        System.out.println(clazz2.getName());

        System.out.println(clazz3.getName());

    }
}
