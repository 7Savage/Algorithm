package 面试.string;

public class StringTest {
    public static void main(String[] args) {
        // 在堆中创建字符串对象”abc“
        // 将字符串对象”abc“的引用保存在字符串常量池中
        String s1 = "abc";
        // 直接返回字符串常量池中字符串对象”ab“的引用
        String s2 = "abc";
        //每次对 String 类型进行改变的时候，都会生成一个新的 String 对象，然后将指针指向新的 String 对象。
        String s3 = s1 + "";
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
    }
}
