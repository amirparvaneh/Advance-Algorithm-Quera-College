package chapter1.welcomeToAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SearchSequence2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] sequence = new int[n];
        int[] question = new int[q];
        int[] result = new int[q];

        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }

        Arrays.sort(sequence);

        for (int i = 0; i < q; i++) {
            question[i] = scanner.nextInt();
            result[i] = binarySearch(sequence, question[i]);
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1, count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return count;
    }
}
