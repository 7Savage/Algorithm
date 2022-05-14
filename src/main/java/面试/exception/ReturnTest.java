package 面试.exception;

public class ReturnTest {
    public static void main(String[] args) {
        System.out.println(f(2));
    }

    /**
     * 当 try 语句和 finally 语句中都有 return 语句时，
     * try 语句块中的 return 语句会被忽略。这是因为 try 语句中的 return 返回值会先被暂存在一个本地变量中，
     * 当执行到 finally 语句中的 return 之后，这个本地变量的值就变为了 finally 语句中的 return 返回值。
     * @param value
     * @return
     */
    public static int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }
}
