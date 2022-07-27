package test;



import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @description: AES加密工具类
 * @author: 孤独的小饼干
 * @create:
 **/
public class AesUtil {


    public static final String algorithm = "AES";
    // AES/CBC/NOPadding
    // AES 默认模式
    // 使用CBC模式, 在初始化Cipher对象时, 需要增加参数, 初始化向量IV : IvParameterSpec iv = new
    // IvParameterSpec(key.getBytes());
    // NOPadding: 使用NOPadding模式时, 原文长度必须是8byte的整数倍
    public static final String transformation = "AES/ECB/PKCS5Padding";
    public static final String key = "1234567890ABCDEF";

    /***
     * 加密
     * @param original 需要加密的参数（注意必须是16位）
     * @return
     * @throws Exception
     */
    public static String encryptByAES(String original) throws Exception {
        // 获取Cipher
        Cipher cipher = Cipher.getInstance(transformation);
        // 生成密钥
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // 指定模式(加密)和密钥
        // 创建初始化向量
        //IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        //cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        // 加密
        byte[] bytes = cipher.doFinal(original.getBytes());

        return Base64Util.encryptBASE64(bytes);
    }

    /**
     * 解密
     * @param encrypted 需要解密的参数
     * @return
     * @throws Exception
     */
    public static String decryptByAES(String encrypted) throws Exception {
        // 获取Cipher
        Cipher cipher = Cipher.getInstance(transformation);
        // 生成密钥
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // 指定模式(解密)和密钥
        // 创建初始化向量
        //IvParameterSpec iv = new IvParameterSpec(key.getBytes());
       // cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        // 解密
        byte[] bytes = cipher.doFinal(Base64Util.decryBASE64(encrypted));

        return new String(bytes);
    }


    public static void main(String[] args) throws Exception {

        try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\IdeaProjects\\Algorithm\\src\\main\\java\\test\\h2.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
                String DeString = AesUtil.decryptByAES(str);
                System.out.println("解密后的字串是：" + DeString);
            }
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(cSrc);
//        // 加密
//        String enString = AesUtil.Encrypt(cSrc, cKey);
//        System.out.println("加密后的字串是：" + enString);

        // 解密

    }
}


