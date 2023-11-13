package chapter11.graph;

import java.util.*;
public class Schedule {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n+1][n+1];
        boolean[][] b = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = in.nextInt();
            }
        }

        Queue<Node> q = new LinkedList<>();
        int min=0, max=0;
        for (int ii = 1; ii <= n; ii++) {
            for (int jj = 1; jj <= n; jj++) {
                if (!b[ii][jj]) {
                    boolean bmax=false, bmin=false;
                    q.clear();q.add(new Node(ii, jj));b[ii][jj] = true;
                    while (!q.isEmpty()) {
                        Node node = q.poll();
                        int i = node.i;
                        int j = node.j;

                        if (i>1 && j>1 && !b[i-1][j-1] && a[i-1][j-1] == a[i][j]) {
                            q.add(new Node(i-1, j-1));
                            b[i-1][j-1] = true;
                        } else if (i>1 && j>1 && a[i-1][j-1] != a[i][j]) {
                            if (a[i-1][j-1] < a[i][j]) bmax = true; else bmin = true;
                        }

                        if (i>1 && !b[i-1][j] && a[i-1][j] == a[i][j]) {
                            q.add(new Node(i-1, j));
                            b[i-1][j] = true;
                        } else if (i>1 && a[i-1][j] != a[i][j]) {
                            if (a[i-1][j] < a[i][j]) bmax = true; else bmin = true;
                        }

                        if (i>1 && j<n && !b[i-1][j+1] && a[i-1][j+1] == a[i][j]) {
                            q.add(new Node(i-1, j+1));
                            b[i-1][j+1] = true;
                        } else if (i>1 && j<n && a[i-1][j+1] != a[i][j]) {
                            if (a[i-1][j+1] < a[i][j]) bmax = true; else bmin = true;
                        }

                        if (j>1 && !b[i][j-1] && a[i][j-1] == a[i][j]) {
                            q.add(new Node(i, j-1));
                            b[i][j-1] = true;
                        } else if (j>1 && a[i][j-1] != a[i][j]) {
                            if (a[i][j-1] < a[i][j]) bmax = true; else bmin = true;
                        }

                        if (j<n && !b[i][j+1] && a[i][j+1] == a[i][j]) {
                            q.add(new Node(i, j+1));
                            b[i][j+1] = true;
                        } else if (j<n && a[i][j+1] != a[i][j]) {
                            if (a[i][j+1] < a[i][j]) bmax = true; else bmin = true;
                        }

                        if (j>1 && i<n && !b[i+1][j-1] && a[i+1][j-1] == a[i][j]) {
                            q.add(new Node(i+1, j-1));
                            b[i+1][j-1] = true;
                        } else if (j>1 && i<n && a[i+1][j-1] != a[i][j]) {
                            if (a[i+1][j-1] < a[i][j]) bmax = true; else bmin = true;
                        }

                        if (i<n && !b[i+1][j] && a[i+1][j] == a[i][j]) {
                            q.add(new Node(i+1, j));
                            b[i+1][j] = true;
                        } else if (i<n && a[i+1][j] != a[i][j]) {
                            if (a[i+1][j] < a[i][j]) bmax = true; else bmin = true;
                        }

                        if (j<n && i<n && !b[i+1][j+1] && a[i+1][j+1] == a[i][j]) {
                            q.add(new Node(i+1, j+1));
                            b[i+1][j+1] = true;
                        } else if (j<n && i<n && a[i+1][j+1] != a[i][j]) {
                            if (a[i+1][j+1] < a[i][j]) bmax = true; else bmin = true;
                        }

                    }
                    if (bmax && !bmin) {
                        max++;
                    } else if (bmin && !bmax) {
                        min++;
                    } else if (!bmin && !bmax) {
                        max++;
                        min++;
                    }
                }
            }
        }

        System.out.println(max + " " + min);
    }

}

class Node {
    int i, j;
    public Node (int i, int j) {
        this.i = i;
        this.j = j;
    }
}