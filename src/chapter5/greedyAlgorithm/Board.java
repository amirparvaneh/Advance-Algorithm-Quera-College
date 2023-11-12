package chapter5.greedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), c = scanner.nextInt();
        Integer[] x = new Integer[n];
        for (int i = 0 ; i<n ; i++){
            x[i] = scanner.nextInt();
        }
        System.out.println("" + eatCandies(c, x));
    }
    static int eatCandies(int c ,Integer[] x){
        Arrays.sort(x);
        for (int i = x.length-1 ; i>=0 ; i--){
            c = c - Math.min(c, Math.max(0, x[i] - c));
        }
        return c;
    }
}