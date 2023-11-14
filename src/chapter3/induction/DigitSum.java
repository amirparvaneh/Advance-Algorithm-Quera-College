package chapter3.induction;

import java.util.Scanner;

public class DigitSum {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int x = scan.nextInt();
        System.out.println(f(x));
    }

    static int f(int x) {
        if (x == 0) return 0;
        return f(x / 10) + (x % 10);
    }
}