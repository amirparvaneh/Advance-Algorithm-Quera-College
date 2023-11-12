package chapter5.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MoreInterval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 1;
        int[][] ranges = new int[n][2];

        for (int i = 0; i < n; i++) {
            ranges[i][0] = scanner.nextInt();
            ranges[i][1] = scanner.nextInt();
        }
        sort_by_upperbound(ranges);

        int[] last_choice = ranges[0];

        for (int i = 1; i < n; i++) {
            if (ranges[i][0] >= last_choice[1]){
                last_choice = ranges[i];
                ans++;
            }
        }

        System.out.println(ans);
    }
    public static void sort_by_upperbound(int[][] arr){
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
    }
}
