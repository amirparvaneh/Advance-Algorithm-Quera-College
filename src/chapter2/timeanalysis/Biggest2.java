package chapter2.timeanalysis;


import java.util.Scanner;

public class Biggest2 {
    public static void main(String[] args) {
        var sc= new Scanner(System.in);
        int n= sc.nextInt();
        long a[]=new long[n];

        for(int i=0;i<n;i++){
            long l = sc.nextLong();
            a[i]=l;
        }
        long max=Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long q = 0;
                for (int k = i; k <= j; k++) {
                    q=q+a[k];

                }
                max=Math.max(q,max);
            }
        }
        System.out.println(max);


    }
}

