package chapter5.greedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class ClerkLife {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0 ; i < n ; i++){
            array[i] = scanner.nextInt();
        }
        System.out.println("" + solve(array));
    }
    public static int solve(int[] array){
        int currentTime = 0 ;
        int ans = 0 ;
        Arrays.sort(array);
        for (int i = 0 ; i<array.length ; i++){
            if (currentTime<array[i]){
                currentTime++;
                ans++;
            }
        }
        return currentTime;
    }
}