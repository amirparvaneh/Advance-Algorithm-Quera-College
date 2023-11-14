package chapter9.datastructures;

import java.util.*;

public class AirportPlanning {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<Long> ts = new TreeSet<>();

        int q = in.nextInt();
        long k = in.nextLong();

        boolean[] granted = new boolean[q];
        for (int i = 0; i < q; i++) {
            long x = in.nextLong();
            boolean permission = true;

            Long higher = ts.higher(x-1);
            if (higher != null && higher - x < k) {
                permission = false;
            }
            if (permission) {
                Long lower = ts.lower(x+1);
                if (lower != null && x - lower < k) {
                    permission = false;
                }
            }

            if (permission) {
                ts.add(x);
                granted[i] = true;
            }
        }
        for (int i = 0; i < q; i++) {
            if (granted[i]) {
                System.out.println("Permission Granted!");
            } else {
                System.out.println("Permission Denied!");
            }
        }

    }
}