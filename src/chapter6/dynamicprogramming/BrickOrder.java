package chapter6.dynamicprogramming;

import java.util.Scanner;

public class BrickOrder {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int q = sc.nextInt();
        long[] a = new long[100100];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        a[3] = 2;
        for(int i = 4; i < 100001; i++){
            a[i] =((long)((a[i - 1] + a[i - 2] + a[i - 3] - a[i - 4]) % (1e9 + 7)) );
        }
        for (int j = 0; j < q; j++){
            int n = sc.nextInt();
            if(a[n] < 0){
                System.out.println(a[n] + 1000000007);
            } else
                System.out.println( a[n]);
        }
    }
}
