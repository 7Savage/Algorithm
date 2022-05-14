package 面试.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//Checked Exception 即 受检查异常 ，Java 代码在编译过程中，如果受检查异常没有被 catch或者throws 关键字处理的话，就没办法通过编译。
public class CheckedExceptionTest {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName="file does not exist";
        File file=new File(fileName);
        FileInputStream inputStream=new FileInputStream(file);
    }
}
