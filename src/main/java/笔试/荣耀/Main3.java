package 笔试.荣耀;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str1=scanner.nextLine().trim().split(" ");
        String[] str2=scanner.nextLine().trim().split(" ");
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < str1.length; i++) {
            if (str1[i].equals("")){
                continue;
            }
            sb1.append(str1[i]+" ");
        }
        for (int i = 0; i < str2.length; i++) {
            if (str2[i].equals("")){
                continue;
            }
            sb2.append(str2[i]+" ");
        }
        String[] right = sb1.toString().trim().split(" ");
        String[] toBJ =sb2.toString().trim().split(" ");
        int fullMark = right.length;
        int res = fullMark;
        int i =0;
        int j=0;
        while (i< right.length&&j< toBJ.length&&res>=0){
            if (right[i].equals(toBJ[j])){
                i++;
                j++;
                continue;
            }
            if (match(right[i],toBJ[j])){
                res--;
                i++;
                j++;
                continue;
            }

            if (right[i+1].equals(toBJ[j])){
                res=res-2;
                i++;
                continue;
            }

            if (right[i].equals(toBJ[j+1])){
                j++;
                res--;
                continue;
            }

            if (right[i+1].equals(toBJ[j+1])){
                i++;
                j++;
                res = res-3;
                continue;
            }
        }
        if (j<toBJ.length&&i<j){
            res -=(j-i);
        }
        System.out.println(res);
    }

    public static boolean match(String s1,String s2){
        int[] nums1=new int[256];
        int[] nums2= new int[256];
        for (int i = 0; i < s1.length(); i++) {
            nums1[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            nums2[s2.charAt(i)]++;
        }
        int th =s1.length()%2==0?s1.length()/2:s1.length()/2+1;
        int cnt =0;
        for (int i = 0; i < 256; i++) {
            cnt+=Math.abs(nums1[i]-nums2[i]);
        }
        if (cnt>=th){
            return true;
        }
        return false;
    }
}
