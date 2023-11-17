package chapter10.preprocess;

import java.util.Scanner;

public class NiceGift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int k = scanner.nextInt();
        int QConst = 1000000007;
        long[] dp = new long[100001];
        dp[0] = 1L;
        for (int i = 1; i <= 100000; i++) {
            dp[i] = dp[i - 1];
            if (i >= k) dp[i] = (dp[i] + dp[i - k]) % QConst;
        }
        long[] ps = new long[100002];
        ps[0] = 0L;
        for (int i = 1; i <= 100001; i++) {
            ps[i] = (ps[i - 1] + dp[i - 1]) % QConst;
        }
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println((ps[b + 1] - ps[a] + QConst) % QConst);
        }
    }
}