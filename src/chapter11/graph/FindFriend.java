package chapter11.graph;

import java.util.*;

public class FindFriend {
    public static ArrayList<Integer>[] adj;
    public static int[] distance;
    public static int[] person;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n - 1;
        int[] v = new int[m * 2];
        for (int i = 0; i < m * 2; i += 2) {
            v[i] = sc.nextInt();
            v[i + 1] = sc.nextInt();
        }

        int q = sc.nextInt();
        person = new int[q];
        for (int i = 0; i < q; i++) {
            person[i] = sc.nextInt();
        }

        adj = new ArrayList[n + 1];
        distance = new int[n + 1];
        adj[0] = null;
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m * 2; i += 2) {
            adj[v[i]].add(v[i + 1]);
            adj[v[i + 1]].add(v[i]);
        }
        bfs(1);

        int firstPerson = n;
        int firstDistance = n;
        for (int i = n; i >= 2; i--) {
            if (personExist(i)) {
                int index = distance[i];
                if (index < firstDistance) {
                    firstPerson = i;
                    firstDistance = index;
                } else if (index == firstDistance) {
                    if (i < firstPerson) {
                        firstPerson = i;
                    }
                }
            }
        }
        System.out.println("" + firstPerson);
    }

    public static boolean personExist(int index) {
        for (int i = 0; i < person.length; i++) {
            if (person[i] == index) {
                return true;
            }
        }
        return false;
    }

    public static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        distance[s] = 0;

        while (queue.size() > 0) {
            int v = queue.remove();
            for (Integer u : adj[v]) {
                if (distance[u] > distance[v] + 1) {
                    distance[u] = distance[v] + 1;
                    queue.add(u);
                }
            }
        }
    }
}
