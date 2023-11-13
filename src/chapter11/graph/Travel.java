package chapter11.graph;

import java.util.*;

public class Travel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, x, y;
        n = in.nextInt();
        int[][] a = new int[n][2];
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }
        int r = -1;
        for (int i = 0; i < n; i++) {
            if (!b[i]) {
                f(a, b, i);
                r++;
            }
        }
        System.out.println(r);
    }

    private static void f(int[][] a, boolean[] b, int i) {
        b[i] = true;
        int x, y;
        x = a[i][0];
        y = a[i][1];
        for (int j = 0; j < a.length; j++) {
            if (!b[j] && (a[j][0] == x || a[j][1] == y)) {
                f(a, b, j);
            }
        }
    }
}