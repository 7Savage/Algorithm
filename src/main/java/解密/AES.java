package 解密;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

public class AES {

    public static void main(String[] args) {
        String path = "D:\\DeliveryOptimization\\h2.txt";
        String pathOut = "D:\\DeliveryOptimization\\h2out.txt";
        String result = "";
        System.out.println();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
//                line = "db4306e0bb951358a187008b5c28ad8b";
                int size = 32;
                for (int i = size; i < line.length(); i += size) {
                    String line32 = line.substring(i - size, i);
                    byte[] decode = hexStringToBytes(line32);
//                    System.out.println(line32);
//                    System.out.println(decode.length);
                    // NoPadding, PKCS7Padding, PKCS5Padding
                    byte[] decrypt = crypt(decode, "1234567890ABCDEF".getBytes(), Cipher.DECRYPT_MODE, "NoPadding");
                    result = new String(decrypt);
//                    System.out.println(result);
                    stringBuilder.append(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(stringBuilder.toString());
        saveData2File(pathOut, stringBuilder.toString());
    }

    private static byte[] crypt(byte[] data, byte[] key, int mode, String padding) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/" + padding);
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        cipher.init(mode, skeySpec);
        return cipher.doFinal(data);
    }

    public static void saveData2File(String filePath, String data) {
        File folder = new File(filePath).getParentFile();
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File eFile = new File(filePath);
        if(eFile.exists()){
            eFile.delete();
        }
//        if (!eFile.exists()) {
//            try {
//                eFile.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            FileOutputStream fos = new FileOutputStream(eFile, true);
            fos.write(data.getBytes("UTF-8"));
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] hexStringToBytes(String hexString) {
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toUpperCase().toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

}
