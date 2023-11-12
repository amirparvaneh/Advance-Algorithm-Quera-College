package chapter5.greedyAlgorithm;

import java.util.Scanner;

public class CufCake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int sections = input.nextInt();
        int[] numbers = new int[number];
        for (int i = 0; i < number; i++)
            numbers[i] = input.nextInt();

        switch (sections) {
            case 1:
                System.out.println(max(numbers));
                break;
            case 2:
                System.out.println(Math.min(numbers[0], numbers[number - 1]));
                break;
            default:
                System.out.println(min(numbers));
        }
    }

    static int max(int[] array) {
        int max = array[0];
        for (int i : array)
            if (i > max)
                max = i;
        return max;
    }

    static int min(int[] array) {
        int min = array[0];
        for (int i : array)
            if (i < min)
                min = i;
        return min;
    }
}
