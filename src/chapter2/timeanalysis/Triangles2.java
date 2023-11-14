package chapter2.timeanalysis;

import java.util.Scanner;

public class Triangles2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int ans = 0;
        for (int a = 1; a <= n / 2; a++) {
            for (int b = a; b <= n - a; b++) {
                if (b <= n - (a + b) && (a + b) > n - (a + b)) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
