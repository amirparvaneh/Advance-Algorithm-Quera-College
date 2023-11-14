package chapter3.induction;

import java.util.Scanner;

public class HornerAlgo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt(), x = scanner.nextInt();
        final long M = 1000000007;
        long[] a = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = scanner.nextLong();
        }
        long p = a[0];
        for (int i = 1; i <= n; i++) {
            p = (p * x + a[i]) % M;
        }
        p = (p + M) % M;
        System.out.println(p);
    }
}