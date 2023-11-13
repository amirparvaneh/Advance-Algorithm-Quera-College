package chapter6.dynamicprogramming;


import java.util.Scanner;

public class CommonSub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringOne = scanner.next();
        String stringTwo = scanner.next();
        int[][] dp = new int[stringOne.length() + 1][stringTwo.length() + 1]; //LCS in [0,i) and [0,j)
        String[][] dpString = new String[stringOne.length() + 1][stringTwo.length() + 1];
        for (int i = 0; i < stringOne.length() + 1; i++) {
            dp[i][0] = 0;
            dpString[i][0] = "";
        }
        for (int i = 0; i < stringTwo.length() + 1; i++) {
            dp[0][i] = 0;
            dpString[0][i] = "";
        }
        for (int i = 1; i < stringOne.length() + 1; i++) {
            for (int j = 1; j < stringTwo.length() + 1; j++) {
                if (stringOne.charAt(i - 1) == stringTwo.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    dpString[i][j] = dpString[i - 1][j - 1] + stringOne.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                    dpString[i][j] = dpString[i - 1][j];
                    if (dp[i][j] < dp[i][j - 1]) {
                        dp[i][j] = dp[i][j - 1];
                        dpString[i][j] = dpString[i][j - 1];
                    }
                }
            }
        }
        System.out.println(dp[stringOne.length()][stringTwo.length()]);
        System.out.println(dpString[stringOne.length()][stringTwo.length()]);
    }
}

