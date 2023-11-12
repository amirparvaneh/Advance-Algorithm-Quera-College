package chapter9.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WhoIsMyPro {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] counter = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            counter[a[i]-1]++;
        }

        int[] queue = new int[n];
        int front = 0;
        int back = 0;
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (counter[i] == 0) {
                queue[back] = i;
                back++;
                check[i] = true;
            }
        }

        while (front < back) {
            counter[a[queue[front]]-1]--;
            if (counter[a[queue[front]]-1] == 0) {
                queue[back] = a[queue[front]]-1;
                back++;
                check[a[queue[front]]-1] = true;
            }
            front++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!check[i])
                result.add(a[i]);
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}