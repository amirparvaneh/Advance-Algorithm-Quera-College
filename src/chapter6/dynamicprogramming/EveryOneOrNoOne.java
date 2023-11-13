package chapter6.dynamicprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class EveryOneOrNoOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ToyPackage> packages = new ArrayList<>();
        int n = scanner.nextInt();
        int money = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int q = scanner.nextInt();
            int count = 0;
            int totalPrice = 0;
            int min = Integer.MAX_VALUE;
            while (q > 0) {
                int price = scanner.nextInt();
                count++;
                totalPrice += price;
                if (price < min) min = price;
                q--;
            }
            packages.add(new ToyPackage(count, totalPrice, min));
        }
        long[][] dp = new long[money + 1][n + 1]; //money count
        for (int i = 0; i < money + 1; i++) {
            dp[i][0] = 0;
            dp[i][0] = 0;
        }
        for (int j = 1; j < n + 1; j++) {
            for (int i = 0; i < money + 1; i++) {
                ToyPackage lastPackage = packages.get(j - 1);
                dp[i][j] = dp[i][j - 1];
                if (i >= lastPackage.price) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - lastPackage.price][j - 1] + lastPackage.count);
                }
                if (i >= packages.get(j - 1).min) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - lastPackage.min][j - 1] + 1);
                }
            }
        }
        System.out.println(dp[money][n]);
        int i = n;
        String ans = "";
        while (i > 0) {
            ToyPackage lastPackage = packages.get(i - 1);
            if (dp[money][i] == dp[money][i - 1]) {
                ans = "0" + ans;
                i--;
                continue;
            }
            if (money >= lastPackage.min) {
                if (dp[money][i] == dp[money - lastPackage.min][i - 1] + 1) {
                    money -= lastPackage.min;
                    ans = "1" + ans;
                    i--;
                    continue;
                }
            }
            if (money >= lastPackage.price) {
                if (dp[money][i] == dp[money - lastPackage.price][i - 1] + lastPackage.count) {
                    money -= lastPackage.price;
                    ans = "2" + ans;
                    i--;
                }
            }
        }
        System.out.println(ans);
    }

    public static class ToyPackage {
        int count;
        int price;
        int min;

        public ToyPackage(int count, int price, int min) {
            this.count = count;
            this.price = price;
            this.min = min;
        }
    }
}

