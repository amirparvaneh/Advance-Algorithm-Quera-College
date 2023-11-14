package practical2;

import java.util.Scanner;

public class Triangles {

    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int x = 0; x < t; x++) {
            int n = sc.nextInt();
            board = new int[n][n];
            int ct = 0;
            for (int z = 0; z < n; z++) {
                ct++;
                for (int u = 0; u < ct; u++) {
                    board[z][u] = sc.nextInt();
                }
            }
            System.out.println(solve(n));
        }
    }

    private static int solve(int n) {
        int[][] dp = new int[n][n];
        dp[0][0] = board[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int u = dp[i - 1][j];
                if (j > 0) {
                    u = Math.max(u, dp[i - 1][j - 1]);
                }
                dp[i][j] = u + board[i][j];
            }
        }
        int res = 0;
        for(int i = 0; i< n;i++){
            res = Math.max(res, dp[n-1][i]);
        }
        return res;
    }
}
