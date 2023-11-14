package chapter9.datastructures;

import java.util.*;

public class CakeCutting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q, w, h, x, t1, t2;

        char c;
        w = in.nextInt();
        h = in.nextInt();
        q = in.nextInt();
        TreeSet<Integer> wset = new TreeSet<>();
        TreeMap<Integer, Integer> wmap = new TreeMap<>();
        wset.add(0);
        wset.add(w);
        wmap.put(w, 1);

        TreeSet<Integer> hset = new TreeSet<>();
        TreeMap<Integer, Integer> hmap = new TreeMap<>();
        hset.add(0);
        hset.add(h);
        hmap.put(h, 1);

        for (int i = 0; i < q; i++) {
            c = in.next().charAt(0);
            x = in.nextInt();
            if (c == 'V') {
                t1 = x - wset.floor(x);
                t2 = wset.ceiling(x) - x;
                if (wmap.get(t1 + t2) == 1) {
                    wmap.remove(t1 + t2);
                } else {
                    wmap.put(t1 + t2, wmap.get(t1 + t2) - 1);
                }
                wmap.put(t1, wmap.getOrDefault(t1, 0) + 1);
                wmap.put(t2, wmap.getOrDefault(t2, 0) + 1);
                wset.add(x);
            } else {
                t1 = x - hset.floor(x);
                t2 = hset.ceiling(x) - x;
                if (hmap.get(t1 + t2) == 1) {
                    hmap.remove(t1 + t2);
                } else {
                    hmap.put(t1 + t2, hmap.get(t1 + t2) - 1);
                }
                hmap.put(t1, hmap.getOrDefault(t1, 0) + 1);
                hmap.put(t2, hmap.getOrDefault(t2, 0) + 1);
                hset.add(x);
            }
            t1 = wmap.floorKey(w);
            t2 = hmap.floorKey(h);
            System.out.println(((long) t1) * t2);
        }
    }
}
