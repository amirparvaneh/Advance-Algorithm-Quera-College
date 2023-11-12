package chapter5.greedyAlgorithm;

import java.util.*;

public class Energy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();

        ArrayList<Fruit> fruits = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long lost = scanner.nextLong();
            long gained = scanner.nextLong();
            if (gained > lost){
                fruits.add(new Fruit(lost, gained));
            }
        }

        Fruit.sort_fruits(fruits);

        for (int i = 0; i < fruits.size(); i++) {
            if (k >= fruits.get(i).lost_energy_for_peeling){
                k += (fruits.get(i).gained_energy_of_eating - fruits.get(i).lost_energy_for_peeling);
            }
        }
        System.out.println(k);
    }
    private static class Fruit {
        long lost_energy_for_peeling;
        long gained_energy_of_eating;
        private Fruit(long lost_energy_for_peeling, long gained_energy_of_eating){
            this.lost_energy_for_peeling = lost_energy_for_peeling;
            this.gained_energy_of_eating = gained_energy_of_eating;
        }

        private static void sort_fruits(ArrayList<Fruit> fruits){
            fruits.sort(new Comparator<Fruit>() {
                @Override
                public int compare(Fruit o1, Fruit o2) {
                    return Long.compare(o1.lost_energy_for_peeling, o2.lost_energy_for_peeling);
                }
            });
        }
    }
}
