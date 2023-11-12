package chapter7.backtracking;

import java.util.Scanner;
import java.util.ArrayList;

public class Sequence {

    static boolean[] mark = new boolean[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> total = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int size = sc.nextInt();
            int[] a = new int[size];
            for (int j = 0; j < size; j++) {
                a[j] = sc.nextInt();
            }
            total.add(a);
        }
        System.out.println(solve(n, 0, total));
    }

    private static int solve(int n, int current, ArrayList<int[]> sequences) {
        if (current == n) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < sequences.get(current).length; i++) {
            int num = sequences.get(current)[i];
            if (!mark[num]) {
                mark[num] = true;
                res += solve(n, current + 1, sequences);
                mark[num] = false;
            }
        }
        return res;
    }
}