package chapter1.welcomeToAlgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CorrectM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        List<Long> sequence = Arrays.stream(s1).map(Long::parseLong).sorted().collect(Collectors.toList());

        int mid;
        if (n % 2 == 0) {
            mid = (((n - 1) / 2));
        } else {
            mid = (((n - 1) + 1) / 2);
        }

        Long M = sequence.get(mid);
        Long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(sequence.get(i) - M);
        }

        System.out.println(M + " " + sum);

    }
}