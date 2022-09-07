package 笔试.去哪儿;


public class Main2 {
    public static int Decrypt(int encryptedNumber, int decryption, int number) {
        int res = 1;
        encryptedNumber %= number;
        for (int i = 0; i < decryption; i++) {
            res *= encryptedNumber;
            res %= number;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Decrypt(4296,1601,4757));
    }
}
