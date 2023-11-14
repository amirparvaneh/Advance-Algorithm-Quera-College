package chapter4.reverseAlgorithm;

import java.util.Scanner;

public class NOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String ans = f(n);
        System.out.println(ans);
    }

    public static String f(int n){
        int[][] a = new int[n][(int) Math.pow(n,n)];
        int[] pow = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            pow[i] = (int) Math.pow(n,i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (j / pow[n - i - 1]) % n + 1;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < Math.pow(n,n); i++) {
            for (int j = 0; j < n; j++) {
                ans.append(a[j][i]).append(" ");
            }
            ans.append("\n");
        }
        return ans.toString();
    }
}

