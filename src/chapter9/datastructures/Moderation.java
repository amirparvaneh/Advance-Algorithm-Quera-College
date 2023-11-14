package chapter9.datastructures;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Moderation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int q = in.nextInt();

        PriorityQueue<Long> minHeap = new PriorityQueue(); // x > mid
        PriorityQueue<Long> maxHeap = new PriorityQueue(Collections.reverseOrder()); // x <= mid

        Long[] ans = new Long[q];
        for (int i = 0; i < q; i++) {
            Long x = in.nextLong();

            if (i == 0 || x < maxHeap.peek()) {
                maxHeap.add(x);
            } else {
                minHeap.add(x);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                Long z = maxHeap.poll();
                minHeap.add(z);
            } else if (minHeap.size() > maxHeap.size() + 1) {
                Long z = minHeap.poll();
                maxHeap.add(z);
            }

            if (maxHeap.size() < minHeap.size()) {
                ans[i] = minHeap.peek();
            } else {
                ans[i] = maxHeap.peek();
            }

        }
        for (int i = 0; i < q; i++) {
            System.out.println(ans[i]);
        }
    }
}