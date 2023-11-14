package chapter1.welcomeToAlgorithm;

import java.util.Scanner;
import java.util.Arrays;
public class ArithmeticSequence2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] arr = new long[n];
        for  (int i = 0; i < n; i++){
            arr[i] = sc.nextLong() - (i * k);
        }
        Arrays.sort(arr);
        long median = n % 2 == 0 ? arr[n / 2 - 1] : arr[(n + 1) / 2 - 1];
        long sum = 0;
        for (int i = 0; i < n; i++){
            sum += Math.abs(arr[i] - median);
        }
        System.out.println(sum);
    }
}