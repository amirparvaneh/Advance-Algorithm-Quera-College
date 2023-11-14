package practical2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MobileMarket {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Mobile[] m = new Mobile[n];
        for (int x = 0; x < n; x++) {
            m[x] = new Mobile(in.nextInt(), in.nextInt());
        }
        int res = 0;
        for (int x = 0; x < n; x++) {
            Boolean flag = true;
            for (int y = 0; y < n; y++) {
                if (x != y && m[x].p >= m[y].p && m[x].q <= m[y].q) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                res++;
            }
        }
        System.out.println(res);
    }

    public static class Mobile {
        int p;
        int q;
        Mobile(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }

}

