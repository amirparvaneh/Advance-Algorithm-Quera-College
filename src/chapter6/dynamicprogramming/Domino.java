package chapter6.dynamicprogramming;

import java.util.Scanner;

public class Domino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = fib(n+1);
        System.out.println(ans);
    }
    static int fib(int n)
    {
        int f[] = new int[n+2];
        int i;
        f[0] = 0;
        f[1] = 1;
        for (i = 2; i <= n; i++)
        {
            f[i] =  ((f[i-1] % 1000000007) + (f[i-2] % 1000000007)) % 1000000007;
        }
        return f[n];
    }

}