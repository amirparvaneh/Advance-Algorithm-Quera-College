package chapter2.timeanalysis;

import java.util.Scanner;

public class Triangles1 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scan.nextInt();
        int ans = 0;
        for (int a = 1; a < n; a++) {
            for (int b = a; b < n; b++) {
                for (int c = b; c < n; c++) {
                    if (a + b + c == n && a + b > c) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
