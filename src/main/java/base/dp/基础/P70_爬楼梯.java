package base.dp.基础;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
public class P70_爬楼梯 {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp=new int[3];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            int sum=dp[1]+dp[2];
            dp[1]=dp[2];
            dp[2]=sum;
        }
        return dp[2];
    }
}
