package chapter6.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class GoTochal {
    public static void main(String[] args) {
        long QConstant = 1000000007;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] height = new long[n];
        HashMap<Long, Integer> compress = new HashMap<>();
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextLong();
        }
        long[] help = height.clone();
        Arrays.sort(help);
        long previousValue = -1;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (previousValue != help[i]) {
                compress.put(help[i], count);
                count++;
            }
            previousValue = help[i];
        }
        for (int i = 0; i < n; i++) {
            height[i] = compress.get(height[i]);
        }
        long[][][] dp = new long[n + 1][n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][i][j] = 1L;
                if (i != n) {
                    if (height[i] >= j) dp[i][i + 1][j] = 2L;
                    else dp[i][i + 1][j] = 1L;
                }
            }
        }
        for (int r = 2; r < n + 1; r++) {
            for (int l = r - 2; l >= 0; l--) {
                for (int limit = n; limit >= 0; limit--) {
                    dp[l][r][limit] = (QConstant + dp[l + 1][r][limit] + dp[l][r - 1][limit] - dp[l + 1][r - 1][limit])%QConstant;
                    if (height[l] >= limit) {
                        if (height[l] == height[r-1]) dp[l][r][limit] = (dp[l][r][limit] + dp[l + 1][r - 1][(int) height[l]]) % QConstant;
                    }
                }
            }
        }
        System.out.println(dp[0][n][0] - 1);
    }
}

