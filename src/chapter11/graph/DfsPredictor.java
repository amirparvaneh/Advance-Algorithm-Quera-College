package chapter11.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DfsPredictor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
        int x,y;
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        LinkedList<Integer> ll;
        ll = new LinkedList<Integer>();
        graph.add(ll);
        for(int i=0;i<n;i++) {
            ll = new LinkedList<Integer>();
            graph.add(ll);
        }
        for(int i=0;i<m;i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        //DFS
        boolean[] mark = new boolean[n];
        Stack<Integer> dfs = new Stack<Integer>();
        dfs.push(s);
        mark[s-1] = true;
        int now;
        int cnt;
        boolean flag = false;
        while(!dfs.isEmpty()) {
            now = dfs.pop();
            cnt = 0;
            for(int i: graph.get(now)) {
                if(i==t) {
                    flag = true;
                    break;
                }else if(!mark[i-1]){
                    mark[i-1] = true;
                    dfs.push(i);
                }else {
                    cnt++;
                }
            }
            if(cnt==graph.get(now).size())
                mark[now-1] = false;
        }
        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
        sc.close();
    }
}