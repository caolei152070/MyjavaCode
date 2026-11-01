package exercise;

import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]w = new int[n+1];
        for (int i = 1; i <= n; i++) {
            w[i] =sc.nextInt();
        }
        sc.close();
        long[][]dp = new long[n+1][4];
        dp[1][1]= 0;
        dp[1][2]= w[1];
        dp[1][3] = Long.MAX_VALUE;
        for(int i=2;i<=n;i++){
            dp[i][1]=max3(dp[i-1][1],dp[i-1][2],dp[i-1][3]);
            dp[i][2]= dp[i-1][1]+w[i];
            dp[i][3]=dp[i-1][2] +w[i];
        }
        long ans=max3(dp[n][1],dp[n][2],dp[n][3]);
        System.out.println(ans);

    }
    static long max3(long a,long b,long c){
        return Math.max(Math.max(a,b),c);
    }
}
