package design;

import java.util.Scanner;

public class MaxRectangle {
    //解法一：O(n^2)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        int minLength;
        int maxSeq = 0;

        String[] arr = data.split(",");
        for (int i = 0; i < arr.length - 1; i++) {
            minLength = Integer.MAX_VALUE;
            minLength = Math.min(minLength, Integer.parseInt(arr[i]));
            for (int j = i + 1; j <= arr.length - 1; j++) {
                //每次都取所选的边中最短的那条
                minLength = Math.min(minLength, Integer.parseInt(arr[j]));
                //求出最大的面积
                maxSeq = Math.max(maxSeq, (j - i) * minLength);
            }
        }
        System.out.println(maxSeq);
    }


    //解法二:O(n^2)
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(ans(arr));
    }
    public static int ans(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            //向左扩展
            for(int left = i - 1; left >=0; left--) {
                if(arr[left] < arr[i]) {
                    break;
                }else {
                    temp += arr[i];
                }
            }
            //向右扩展
            for(int right = i + 1; right < arr.length; right++) {
                if(arr[right] < arr[i]) {
                    break;
                }else {
                    temp += arr[i];
                }
            }
            if(temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
