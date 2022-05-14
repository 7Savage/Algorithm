package 面试.string;

import org.junit.Test;

public class StringTest5 {
    final String str1 = "str";
    //str2 在运行时才能确定其值
    final String str2 = getStr();
    String c = "str" + "ing";// 常量池中的对象
    String d = str1 + str2; // 在堆上创建的新的对象

    public static String getStr() {
        return "ing";
    }

    @Test
    public void test(){
        System.out.println(c == d);// false
    }
}
