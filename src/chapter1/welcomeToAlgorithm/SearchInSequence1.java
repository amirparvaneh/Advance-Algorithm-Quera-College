package chapter1.welcomeToAlgorithm;

import java.util.Scanner;

public class SearchInSequence1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] sequence = new int[n];
        int[] question = new int[q];
        int[] result = new int[q];
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            question[i] = scanner.nextInt();
            int counter = 0;
            for (int s : sequence) {
                if (s < question[i]) {
                    counter++;
                }
            }
            result[i] = counter;
        }
        for (int i : result){
            System.out.println(i);
        }
    }
}
