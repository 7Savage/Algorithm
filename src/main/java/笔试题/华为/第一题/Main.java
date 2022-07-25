package 笔试题.华为.第一题;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = -1;
        int a_tag = 0;
        int b = -1;
        int b_tag = 0;
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String[] s = new String[n];
        for(int i = 0;i<n;i++){
            s[i] = scanner.next();
        }
        for(int i=0;i<n;i++){
            if(s[i].equals("A")){
                if(a==-1){
                    a = b+1;
                    a_tag++;
                }else{
                    if(a_tag < 4){
                        a_tag++;
                    }
                    else{
                        a = Math.max(a,b) + 1;
                        a_tag = 0;
                        a_tag++;
                    }
                }
            }else{
                if(b==-1){
                    b = a+1;
                    b_tag++;
                }
                else{
                    if(b_tag < 1){
                        b_tag++;
                    }
                    else{
                        b = Math.max(a,b)+1;
                        b_tag = 0;
                        b_tag++;
                    }
                }
            }
        }
        if(s[n-1].equals("A")){
            if(a+1<=m) {
                System.out.println(a + 1);
                System.out.println(a_tag);
            }else{
                System.out.println(0);
                System.out.println(0);
            }
        }else{
            if(b+1<=m) {
                System.out.println(b + 1);
                System.out.println(b_tag);
            }else{
                System.out.println(0);
                System.out.println(0);
            }
        }

    }
}
