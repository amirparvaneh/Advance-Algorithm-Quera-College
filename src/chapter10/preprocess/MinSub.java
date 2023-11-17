package chapter10.preprocess;

import java.util.*;

public class MinSub {

    static int mina[];

    public static void main(String[] args) {

        Scanner intput = new Scanner(System.in);
        int n = intput.nextInt();
        int m = intput.nextInt();

        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = intput.nextInt();
        }
        creatmin(a, n);

        for (int i = 0; i < m; i++) {
            int l = intput.nextInt();
            int r = intput.nextInt();
            findmin(l, r, n);
        }


    }

    public static int min(int a, int b) {
        return (a > b) ? b : a;
    }

    public static int mid(int l, int r) {
        int mid = l + (r - l) / 2;
        return mid;
    }

    public static void creatmin(int[] a, int n) {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int maxsize = 2 * (int) Math.pow(2, x) - 1;
        mina = new int[maxsize];
        min(a, 0, n - 1, 0);
    }

    public static int min(int[] a, int l, int r, int i) {

        if (l == r) {
            mina[i] = a[l];
            return mina[i];
        }

        int mid = mid(l, r);
        mina[i] = min(min(a, l, mid, 2 * i + 1), min(a, mid + 1, r, 2 * i + 2));
        return mina[i];
    }

    public static void findmin(int l, int r, int n) {
        int i = 0;
		/*if(l<0 || r>n || l>r) {
			return ;
		}*/
        int min = findm(0, n - 1, l, r, 0);
        System.out.println(min);
    }

    public static int findm(int l, int r, int lr, int rr, int i) {

        if (l >= lr && r <= rr) {
            return mina[i];
        }
        if (l > rr || r < lr) {
            return Integer.MAX_VALUE;
        }
        int mid = mid(l, r);
        return min(findm(l, mid, lr, rr, 2 * i + 1), findm(mid + 1, r, lr, rr, 2 * i + 2));


    }


}
