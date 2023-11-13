package chapter6.dynamicprogramming;

import java.util.Scanner;

public class BiggestSubSchedule {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        long[][] numbers = new long[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                numbers[i][j] = input.nextInt();
        long[] b;
        long max;
        long result = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < n; r1++) {
            b = new long[m];
            for (int r2 = r1; r2 < n; r2++) {
                max = 0;
                for (int i = 0; i < m; i++) {
                    b[i] += numbers[r2][i];
                    max = Math.max(b[i], b[i] + max);
                    result = (max > result) ? max : result;
                }
            }
        }
        System.out.println(result);
    }
}