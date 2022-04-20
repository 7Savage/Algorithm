package swordtooffer;

//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
// 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
public class P66_构建乘积数组 {
    //表格分区
    //时间复杂度 O(N) ： 其中 N 为数组长度，两轮遍历数组 a ，使用 O(N) 时间。
    //空间复杂度 O(1) ： 变量 tmp 使用常数大小额外空间（数组 b 作为返回值，不计入复杂度考虑）。
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        int temp = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}
