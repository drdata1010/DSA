package DP;

import java.util.Arrays;

public class ClimbingStairs {
    private static int stairsRecur(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;

        int left = stairsRecur(n-1); //counting single steps
        int right = stairsRecur(n-2); //counting double steps

        //return total
        return left + right;
    }
    private static int stairsMemo(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return helper(dp, n);
    }
    private static int helper(int[] dp, int n){
        if(n == 0) return 1;
        if(n == 1) return 1;

        if(dp[n] != -1) return dp[n];

        return dp[n] = helper(dp, n-1) + helper(dp, n-2);
    }

    private static int tabulation(int n){
        if(n <= 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    private static int tabulationOptimized(int n){
        int prev2 = 0;
        int prev = 1;
        int curr = 0;

        for(int i = 0; i < n; i++){
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        /*
        * You are climbing a staircase. It takes n steps to reach the top.Each time you can either
        * climb 1 or 2 steps. In how many distinct ways can you climb to the top?
        * */
        int steps = 3;
        int ways = stairsRecur(steps);
        System.out.println("Recursive " + ways);
        int ways1 = stairsMemo(steps);
        System.out.println("Memoization " + ways1);
        int ways2 = tabulation(steps);
        System.out.println("Tabulation " + ways2);
        int ways3 = tabulationOptimized(steps);
        System.out.println("Tabulation without space " + ways2);

    }
}
