package 笔试.BOSS直聘;

import java.util.*;

//最小公倍数
public class Main1 {

    public static long getGcd(long m,long n){
        while(n > 0){
            long temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

    //求解数m和n和最小公倍数
    public static long getLcm(long m,long n){
        long gcd = getGcd(m,n);
        return m*n / gcd;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.print(getLcm(a, b));
    }

}
