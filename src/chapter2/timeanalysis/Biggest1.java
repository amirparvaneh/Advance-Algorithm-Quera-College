package chapter2.timeanalysis;

import java.util.Scanner;
public class Biggest1 {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sin.nextLong();

        System.out.println(BSRFinder(arr));
    }

    public static long BSRFinder(long[] arr) {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int n = arr.length - 1;
            for (int k = i; k < arr.length; k++) {
                long tempMax = 0;
                for (int j = n; j >= i; j--) {
                    tempMax += arr[j];
                }
                if (tempMax > max)
                    max = tempMax;
                n--;
            }
        }
        return max;
    }
}
