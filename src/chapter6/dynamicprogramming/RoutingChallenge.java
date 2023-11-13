package chapter6.dynamicprogramming;

import java.util.Scanner;

public class RoutingChallenge {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] array  = new int[n][m];
        long[][][] dp = new long[n][m][2];
        for (int i = 0 ; i<n ; i++){
            for (int j = 0 ; j<m ; j++){
                array[i][j] = scanner.nextInt();
            }
        }
        dp[0][0][0] = array[0][0];
        dp[0][0][1] = array[0][0];
        for (int  i = 1 ; i<m ; i++){
            dp[0][i][1] = dp[0][i-1][1] + array[0][i];
            dp[0][i][0] = Long.MAX_VALUE;
        }
        for (int i = 1 ; i<n ; i++){
            for (int j = 0 ; j<m ; j++){
                Long min = Math.min(dp[i-1][j][0] , dp[i-1][j][1]);
                Long s = Long.MAX_VALUE;
                if (j != 0) {
                    s = dp[i][j-1][1];
                }
                dp[i][j][1] = Math.min(min,s) + array[i][j];
            }
            for (int j = m-1 ; j>= 0 ; j--){
                long min = Math.min(dp[i-1][j][0],dp[i-1][j][1]);
                long s = Long.MAX_VALUE;
                if (j != m-1){
                    s = dp[i][j+1][0];
                }
                dp[i][j][0] = Math.min(min,s) + array[i][j];
            }
        }
        System.out.println(dp[n-1][m-1][1]);
    }
}
