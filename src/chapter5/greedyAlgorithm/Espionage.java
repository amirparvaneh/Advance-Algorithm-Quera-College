package chapter5.greedyAlgorithm;

import java.util.*;

public class Espionage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] names = new String[n];

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
        }
        int q = scanner.nextInt();

        if (q < n){
            System.out.println(0);
            return;
        }
        int ans = 0;
        String[] days = new String[q];
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            days[i] = scanner.nextLine();
        }
        HashSet<String> set = new HashSet<>(List.of(names));
        ArrayList<String> bunch = new ArrayList<>();

        n1: for (int i = 0; i < q; i++) {
            if (set.size() == 1){
                int counter = 0;

                while (!set.contains(days[counter + i])){
                    bunch.add(days[counter+i]);
                    if (i + counter < q-1){
                        counter++;
                    }
                    else {
                        if (set.contains(days[q-1])){
                            ans++;
                        }
                        break n1;
                    }
                }
                i += counter;
                ans++;
                set = new HashSet<>(List.of(names));
                bunch = new ArrayList<>();
            }
            if(set.size() != 1) {
                bunch.add(days[i]);
                set.remove(days[i]);
            }
        }




        System.out.println(ans);
    }
}
