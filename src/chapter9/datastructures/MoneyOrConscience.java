package chapter9.datastructures;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MoneyOrConscience {

    public static long k, q;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Long> pr = new PriorityQueue<>();
        q = in.nextLong();
        long ans = 0, t;
        for (long i = 0; i < q; i++) {
            k = in.nextLong();
            for (long j = 0; j < k; j++) {
                pr.add(in.nextLong() + i);
            }

            while (!pr.isEmpty()) {
                t = pr.poll();
                if (t - i > 0) {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }

}

