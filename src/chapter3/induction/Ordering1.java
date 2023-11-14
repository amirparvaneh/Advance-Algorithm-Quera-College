package chapter3.induction;

import java.util.Scanner;

public class Ordering1 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int p = i;
            while (p > 0 && arr[p] < arr[p - 1]) {
                swap(arr, p, p - 1);
                p--;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int[] a, int index_1, int index_2) {
        int tmp = a[index_1];
        a[index_1] = a[index_2];
        a[index_2] = tmp;
    }
}