package chapter7.backtracking;

import java.util.*;
public class NMinister {
    public static final int max = 8;
    public static long ans = 0L;
    public static boolean[] row = new boolean[max];
    public static boolean[] diag1 = new boolean[max * 2];
    public static boolean[] diag2 = new boolean[max * 2];
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int n = myObj.nextInt();
        int k = myObj.nextInt();
        Arrays.fill(row, false);
        Arrays.fill(diag1, false);
        Arrays.fill(diag2, false);
        queenPut(n, k, 0);
        System.out.println(ans);
    }
    public static void queenPut(int n, int k, int col) {
        if (col == n) {
            if (k == 0)
                ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (row[i]) continue;
            if (diag1[i + col]) continue;
            if (diag2[i - col + max]) continue;
            row[i] = diag1[i + col] = diag2[i - col + max] = true;
            queenPut(n, k - 1, col + 1);
            row[i] = diag1[i + col] = diag2[i - col + max] = false;
        }
        queenPut(n, k, col + 1);
    }
}