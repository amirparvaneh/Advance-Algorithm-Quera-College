package chapter4.reverseAlgorithm;


import java.util.Arrays;
import java.util.Scanner;

public class Compartmentalization {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long sum_A = Arrays.stream(arr).sum();
        long ans = sum_A;
        for (int mask = 0; mask < (1 << n); mask++) {
            long sum_B = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    sum_B += arr[i];
                }
            }
            ans = Math.min(Math.abs((2 * sum_B) - sum_A), ans);
        }
        System.out.println(ans);


    }
}

