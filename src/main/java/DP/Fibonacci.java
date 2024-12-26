package DP;

import java.util.Arrays;

public class Fibonacci {
    private static int fiboRecur(int n){
        if(n <= 1) return n;

        return fiboRecur(n-1) + fiboRecur(n-2);
    }

    private static int dpMemo(int n){
        //We have to store fibo of all so that we dont have to compute again n again
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n);
    }
    private static int helper(int[] dp, int n){
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = (helper(dp, n-1) + helper(dp, n-2));
    }
    public static void main(String[] args) {
        //Given n, find nth fibonacci
        int n = 100;
        int ans = fiboRecur(n);
        System.out.println("Recursive "+ans);

        int ans1 = dpMemo(n);
        System.out.println("DP Memo " + ans1);

        int ans2 = dpTabulation(n);
        System.out.println("DP Tabulation " + ans2);
    }
    private static int dpTabulation(int n){
        //We have to store fibo of all so that we dont have to compute again n again
        int[] dp = new int[n+1];
        if(n <= 1) return n;

        //We know vals for 0 and 1 so store it and compute for other
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
//0 1 1 2 3 5