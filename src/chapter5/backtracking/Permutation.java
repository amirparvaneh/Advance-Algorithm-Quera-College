package chapter5.backtracking;

import java.util.Scanner;
import java.util.ArrayList;

public class Permutation {
    static int counter = 0;
    static int n = 0;
    static int k = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        solve(list, 0, new ArrayList<>());
        System.out.print(counter);
    }

    private static void solve(ArrayList<Integer> list, int mask, ArrayList<Integer> emptyList) {
        if (mask + 1 == (1 << n)) {
            // System.out.println(emptyList);
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (i < j && emptyList.get(i) > emptyList.get(j))
                        c++;
                }
            }
            if (c == k)
                counter++;
        }
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 0) {
                emptyList.add(list.get(i));
                solve(list, (mask | (1 << i)), emptyList);
                emptyList.remove(emptyList.size() - 1);
            }
        }
    }
}