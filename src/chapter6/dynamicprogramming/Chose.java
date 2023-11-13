package chapter6.dynamicprogramming;

import java.util.Scanner;

public class Chose {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int q = sc.nextInt();
        long[][] c = new long[2002][2002];
        for (int i = 0; i <= 2001; i++){
            for (int j = 0; j < i; j++){
                if(j == i || j == 0){
                    c[i][j] = 1;
                }
                else {
                    c[i][j] = ( (long) ((c[i-1][j] + c[i-1][j-1]) % (1e9 + 7)));
                }
            }
        }
        while (q-- > 0){
            int n = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(c[n + 1][r]);
        }

    }
}