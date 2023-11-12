package chapter10.preprocess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Wants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        ArrayList<Integer>[] al = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            al[i].add(i+1);
        }

        for (int i = 0; i < q; i++) {
            int t = scanner.nextInt();
            if (t == 1) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                for (int j = 0; j < al[a-1].size(); j++) {
                    al[b-1].add(al[a-1].get(j));
                }
                al[a-1].clear();
            } else if (t == 2) {
                int c = scanner.nextInt();
                System.out.println(al[c-1].size());
            } else if (t == 3) {
                int d = scanner.nextInt();
                if (al[d-1].size() == 0) System.out.println(-1);
                else {
                    Collections.sort(al[d - 1]);
                    for (int j = 0; j < al[d - 1].size(); j++) {
                        System.out.print(al[d - 1].get(j) + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Please enter a valid number for t");
            }
        }
    }
}
