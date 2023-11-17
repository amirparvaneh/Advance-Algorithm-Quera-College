package chapter10.preprocess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumInArray {

    public static long[] ps;
    public static int[] a;
    public static List<History> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int q = in.nextInt();
        a = new int[n];
        ps = new long[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int t = (int) Math.sqrt(q);
        for (int i = 0; i < q; i++) {
            if(i % t == 0){
                history.clear();
                setPartialSum();
            }
            int type = in.nextInt();
            switch (type) {
                case 1:
                    int l = in.nextInt();
                    int r = in.nextInt();
                    System.out.println(getSum(l, r));
                    break;
                case 2:
                    int idx = in.nextInt();
                    int nv = in.nextInt();
                    history.add(new History(idx, nv - a[idx]));
                    a[idx] = nv;
                    break;
            }
        }
    }

    private static long getSum(int l, int r) {
        long result = ps[r + 1] - ps[l];
        for (History h : history) {
            if (l <= h.idx && h.idx <= r) {
                result += h.x;
            }
        }
        return result;
    }

    private static void setPartialSum() {
        for (int i = 1; i <= a.length; i++) {
            ps[i] = ps[i - 1] + a[i - 1];
        }
    }

    public static class History {
        int idx, x;

        History(int idx, int x) {
            this.idx = idx;
            this.x = x;
        }
    }

}

