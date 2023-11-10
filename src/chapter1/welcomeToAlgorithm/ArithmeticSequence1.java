package chapter1.welcomeToAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Double.POSITIVE_INFINITY;

public class ArithmeticSequence1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for  (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int ans = (int)POSITIVE_INFINITY;
        for (int i = min - ((n - 1) * k); i <= max; i++){
            int cost = 0;
            for (int j = 0; j < n; j++){
                cost += Math.abs((i + (j) * k) - arr[j]);
            }
            if(cost < ans){
                ans = cost;
            }
        }
        System.out.println(ans);
    }
}
