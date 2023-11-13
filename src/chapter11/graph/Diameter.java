package chapter11.graph;

import java.util.*;

public class Diameter {
    static int distance = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int v = input.nextInt();
            int u = input.nextInt();
            graph.get(v).add(u);
            graph.get(u).add(v);
        }
        int ans = BFS(graph,  1);
        distance = 0;
        BFS(graph, ans);
        System.out.println(distance);
    }
    static int BFS(ArrayList<ArrayList<Integer>> graph, int start){
        boolean[] visited = new boolean[graph.size()];
        int[] parent = new int[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int maxDistance = 0;
        int max = 0;
        visited[start] = true;
        while (!queue.isEmpty()){
            int front = queue.remove();
            for (int element:graph.get(front)) {
                if (!visited[element]){
                    visited[element] = true;
                    queue.add(element);
                    parent[element] = parent[front] + 1;
                    maxDistance = parent[front] + 1;
                    max = element;
                }
            }
        }
        distance += maxDistance;
        return max;
    }
}

