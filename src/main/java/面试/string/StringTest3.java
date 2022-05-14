package 面试.string;

public class StringTest3 {
    public static void main(String[] args) {
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2;//堆上新创建的对象
        String str5 = "string";//常量池上的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true，常量折叠，直接优化
        System.out.println(str4 == str5);//false
    }
}
