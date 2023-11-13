package chapter6.dynamicprogramming;

import java.util.Scanner;

public class MaxRouteSchedule {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        long[][] table = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i][j] = sc.nextInt();
            }
        }
        long[][] dp = new long[n][m];
        char[][] parent = new char[n][m];
        dp[n-1][0] = table[n-1][0];
        for (int i = n-2; i >= 0; i--){
            dp[i][0] = dp[i + 1][0] + table[i][0];
            parent[i][0] = 'U';
        }
        for (int j = 1; j < m; j++){
            dp[n-1][j] = dp[n-1][j-1] + table[n-1][j];
            parent[n-1][j] = 'R';
        }
        for (int i = n - 2 ; i >= 0; i--){
            for (int j = 1; j < m; j++){
                if(dp[i + 1][j] > dp[i][j - 1]){
                    dp[i][j] = dp[i+1][j] + table[i][j];
                    parent[i][j] = 'U';
                }
                else {
                    dp[i][j] = dp[i][j-1] + table[i][j];
                    parent[i][j] = 'R';
                }
            }
        }
        System.out.println(dp[0][m - 1]);
        String ans = new String();
        int currentRow = 0;
        int currentColumn = m-1;
        while ((currentRow != n-1) || (currentColumn != 0)){
            if (parent[currentRow][currentColumn] == 'U'){
                ans += "U";
                currentRow++;
            }
            else{
                ans += "R";
                currentColumn--;
            }
        }
        for (int i = ans.length()-1; i >=0; i--){
            System.out.print(ans.charAt(i));
        }
    }
}


/*
5 10
15 -565 156 -456 856 45 -552 152 132 63
-120 165 623 851 -65 85 -8455 -544 -41 -89
855 -565 -854 -102 -456 95 -89 132 -874 -56
874 -2165 3544 85 621 -746 868 1556 -854 -8542
-874 -8954 249 -894 -895 18 95 949 49 -8748*/