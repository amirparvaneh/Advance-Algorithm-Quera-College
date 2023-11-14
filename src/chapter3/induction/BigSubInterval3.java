package chapter3.induction;


import java.util.Scanner;


public class BigSubInterval3 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        long maxSum = arr[0];
        long ans = maxSum;
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum + arr[i], arr[i]);
            ans = Math.max(maxSum, ans);
        }
        System.out.println(ans);
    }
}