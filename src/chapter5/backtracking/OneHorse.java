package chapter5.backtracking;

import java.util.Scanner;

public class OneHorse {
    static int n;
    static boolean[][] map;
    static boolean[][] watched;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int k = in.nextInt();
        map = new boolean[n][n];
        map[0][0] = true;
        watched = new boolean[n][n];
        solution(map, k, 0, 0);
        System.out.println(ans);
    }

    static void solution(boolean[][] map, int k, int i, int j) {
        if (k == 0) {
            if (!watched[i][j]) {
                ans++;
                watched[i][j] = true;
            }
            return;
        }
        // isSafe check that cell is not true or out of bound
        if (isSafe(map, i-1, j-2)) {
            map[i-1][j-2] = true;
            solution(map, k-1, i-1, j-2);
            map[i-1][j-2] = false;
        }
        if (isSafe(map, i-1, j+2)){
            map[i-1][j+2] = true;
            solution(map, k-1, i-1, j+2);
            map[i-1][j+2] = false;
        }
        if (isSafe(map, i-2, j-1)) {
            map[i-2][j-1] = true;
            solution(map, k-1, i-2, j-1);
            map[i-2][j-1] = false;
        }
        if (isSafe(map, i-2, j+1)){
            map[i-2][j+1] = true;
            solution(map, k-1, i-2, j+1);
            map[i-2][j+1] = false;
        }
        if (isSafe(map, i+1, j-2)) {
            map[i+1][j-2] = true;
            solution(map, k-1, i+1, j-2);
            map[i+1][j-2] = false;
        }
        if (isSafe(map, i+2, j-1)) {
            map[i+2][j-1] = true;
            solution(map, k-1, i+2, j-1);
            map[i+2][j-1] = false;
        }
        if (isSafe(map, i+1, j+2)) {
            map[i+1][j+2] = true;
            solution(map, k-1, i+1, j+2);
            map[i+1][j+2] = false;
        }
        if (isSafe(map, i+2, j+1)) {
            map[i+2][j+1] = true;
            solution(map, k-1, i+2, j+1);
            map[i+2][j+1] = false;
        }
    }

    static boolean isSafe(boolean[][] map, int i, int j) {
        if (i >= n || j >= n || i < 0 || j < 0) {
            return false;
        }
        return true;
    }
}
