package chapter2.timeanalysis;

import java.util.Scanner;

public class CountTriangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                int c = n - a - b;
                if (c >= b && a + b > c) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
