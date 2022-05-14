package 面试.exception;

public class FinallyTest {
    public static void main(String[] args) {
        try {
            System.out.println("Try to do something");
            throw new RuntimeException("RuntimeException");
        }
        //用于处理 try 捕获到的异常
        catch (Exception e) {
            System.out.println("Catch Exception -> " + e.getMessage());
        }
        //无论是否捕获或处理异常，finally 块里的语句都会被执行。
        // 当在 try 块或 catch 块中遇到 return 语句时，finally 语句块将在方法返回之前被执行
        finally {
            System.out.println("Finally");
        }
    }
}
