package 面试.exception;

public class FinallyTest2 {
    public static void main(String[] args) {
        try {
            System.out.println("Try to do something");
            throw new RuntimeException("RuntimeException");
        } catch (Exception e) {
            System.out.println("Catch Exception -> " + e.getMessage());
            // 终止当前正在运行的Java虚拟机
            //finally 之前虚拟机被终止运行的话，finally 中的代码就不会被执行。
            //在以下 2 种特殊情况下，finally 块的代码也不会被执行：
            //1.程序所在的线程死亡。
            //2.关闭 CPU。
            System.exit(1);
        } finally {
            System.out.println("Finally");
        }
    }
}
