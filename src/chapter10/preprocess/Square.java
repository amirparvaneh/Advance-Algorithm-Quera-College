package chapter10.preprocess;

import java.util.*;

public class Square {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k, n, m, x1, x2, y1, y2;
        n= in.nextInt();
        m= in.nextInt();
        k= in.nextInt();
        int t;
        int[][] a = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            t=0;
            for (int j = 1; j <= m; j++) {
                t += in.nextInt();
                a[i][j] = a[i-1][j] + t;
            }
        }
        int max=0, x, y, z;
        for (int i = 0; i <= n-k; i++) {
            for (int j = 0; j <= m-k; j++) {

                for (int ii = i; ii <= n-k; ii++) {
                    for (int jj = 0; jj <= m-k; jj++) {
                        if (i==ii && j==jj) continue;

                        x = f(a, i, j, i+k, j+k);
                        y = f(a, ii, jj, ii+k, jj+k);
                        z = 0;
                        if (ii<(i+k)){
                            if (j<=jj && jj<(j+k)) {
                                z = f(a, ii, jj, i+k, j+k);
                            } else if (jj<j && j<(jj+k)) {
                                z = f(a, ii, j, i+k, jj+k);
                            }
                        }
                        if ((x+y-z) > max) {
                            max = x+y-z;
                        }

                    }
                }
            }
        }
        System.out.println(n*m-a[n][m]+max);
    }

    private static int f(int[][] a, int i, int j, int i2, int j2) {
        return a[i2][j2] - a[i][j2] - a[i2][j] + a[i][j];
    }
}