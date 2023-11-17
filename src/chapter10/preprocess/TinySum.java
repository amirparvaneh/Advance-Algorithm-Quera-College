package chapter10.preprocess;

import java.util.Scanner;

public class TinySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        long[] partialSum = new long[n+1];
        partialSum[0] = 0;

        for (int i = 1; i < n+1; i++) {
            int a = scanner.nextInt();
            partialSum[i] = partialSum[i-1] + a;
        }

        for (int i = 0; i < q; i++) {
            int l, r;
            l = scanner.nextInt();
            r = scanner.nextInt();
            System.out.println(partialSum[r+1] - partialSum[l]);
        }
    }
}
