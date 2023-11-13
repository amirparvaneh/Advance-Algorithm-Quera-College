package chapter6.dynamicprogramming;

import java.util.Scanner;

public class BiggestSub {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] a = new long[n];
        long[] maxSum = new long[n];
        maxSum[0] = a[0] = sc.nextInt();
        for (int i = 1; i < n; i++){
            a[i] = sc.nextInt();
            maxSum[i] = Math.max(a[i],a[i] + maxSum[i - 1]);
        }
        long ans = maxSum[0];
        for (int i = 1; i < n; i++){
            ans = Math.max(ans, maxSum[i]);
        }
        System.out.println(ans);
    }
}