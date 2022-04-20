package swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 约瑟夫环问题
 */
public class P62_圆圈中最后剩下的数字 {
    //暴力解决
    public int lastRemaining(int n, int m) {
        List<Integer> list = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    //f(n,m) = [f(n−1,m)+m]%n
    //f(n,m)表示最后剩下那个人的索引号
    public int lastRemaining2(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
