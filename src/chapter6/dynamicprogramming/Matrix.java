package chapter6.dynamicprogramming;

import java.util.Scanner;

public class Matrix {
    static Scanner sc = new Scanner(System.in);
    static long[][] dp = new long[400][400];

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n+1; i++){
            a[i] = sc.nextInt();
        }
        n++;
        long m[][] = new long[n][n];

        int i, j, k, L;
        long q;
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        for (L = 2; L < n; L++)
        {
            for (i = 1; i < n - L + 1; i++)
            {
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Long.MAX_VALUE;
                for (k = i; k <= j - 1; k++)
                {
                    q = m[i][k] + m[k + 1][j] + ((long)a[i - 1] * a[k] * a[j]);
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
        System.out.println(m[1][n-1]);
    }

}

