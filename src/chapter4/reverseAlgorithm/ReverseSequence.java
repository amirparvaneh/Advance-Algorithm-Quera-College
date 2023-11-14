package chapter4.reverseAlgorithm;

import java.util.Scanner;

public class ReverseSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(f(n));
    }
    public static int f(int n) {
        if (n == 0) {
            return  5;
        }
        int tmp = f(n - 1);
        if (n % 2 == 0) {
            return tmp - 21;
        } else return  tmp * tmp;
    }
}
