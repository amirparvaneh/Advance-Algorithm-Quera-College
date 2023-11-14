package chapter4.reverseAlgorithm;

import java.util.Scanner;
public class HanoiTower {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        f(n, 'A', 'B', 'C');
    }
    static int count = 1;
    static void f(int n, char from, char to, char help){
        if(n == 1){
            System.out.println(count++ + " " + from + " " + to);
            return;
        }
        f(n - 1, from, help, to);
        System.out.println(count++ + " " + from + " " + to);
        f(n - 1, help, to, from);
    }
}