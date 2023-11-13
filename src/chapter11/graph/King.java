package chapter11.graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class King {
    public static int n;

    public static String getString(int[] array) {
        StringBuilder string = new StringBuilder();
        for (int j : array) {
            string.append(j);
        }
        return string.toString();
    }

    public static ArrayList<String> generatePermutation(int[] current, int startIndex, ArrayList<String> answer) {
        if (startIndex == current.length - 1) {
            answer.add(getString(current));
        }
        for (int i = startIndex; i < current.length; i++) {
            int help = current[startIndex];
            current[startIndex] = current[i];
            current[i] = help;
            generatePermutation(current, startIndex + 1, answer);
            help = current[startIndex];
            current[startIndex] = current[i];
            current[i] = help;
        }
        return answer;
    }

    public static ArrayList<String> getNeighbors(String string) {
        int i = 2;
        ArrayList<String> answer = new ArrayList<>();
        while (i <= string.length()) {
            StringBuilder string1 = new StringBuilder(string.substring(0, i));
            StringBuilder string2 = new StringBuilder(string.substring(i));
            string1.reverse();
            answer.add((string1.append(string2)).toString());
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] help = new int[n];
        for (int i = 0; i < n; i++) {
            help[i] = i + 1;
        }
        ArrayList<String> permutations = generatePermutation(help, 0, new ArrayList<>());
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        HashMap<String, Boolean> marked = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        Queue bfsQueue = new Queue();
        for (String permutation :
                permutations) {
            graph.put(permutation, getNeighbors(permutation));
            marked.put(permutation, false);
        }
        StringBuilder source = new StringBuilder();
        for (int i = 0; i < n; i++) {
            source.append(scanner.nextInt());
        }
        bfsQueue.enqueue(source.toString());
        marked.remove(source.toString());
        marked.put(source.toString(), true);
        distance.put(source.toString(), 0);
        String target = "";
        for (int i = 1; i <= n; i++) {
            target = target + i;
        }
        Loop:
        while (!bfsQueue.isEmpty()) {
            String current = bfsQueue.dequeue();
            for (String neighbor :
                    graph.get(current)) {
                if (!marked.get(neighbor)) {
                    bfsQueue.enqueue(neighbor);
                    marked.remove(neighbor);
                    marked.put(neighbor, true);
                    distance.put(neighbor, distance.get(current) + 1);
                    if (neighbor.equals(target)) break Loop;
                }
            }
        }
        System.out.println(distance.get(target));
    }

    public static class Queue {
        Node front = null;
        Node rear = null;
        int size = 0;

        public void enqueue(String x) {
            if (size != 0) {
                this.rear.next = new Node(x, null);
                this.rear = this.rear.next;
            } else {
                Node node = new Node(x, null);
                this.front = node;
                this.rear = node;
            }
            size++;
        }

        public String dequeue() {
            Node node = this.front;
            if (size == 1) {
                this.front = null;
                this.rear = null;
            } else {
                this.front = this.front.next;
            }
            size--;
            return node.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static class Node {
        String value;
        Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

