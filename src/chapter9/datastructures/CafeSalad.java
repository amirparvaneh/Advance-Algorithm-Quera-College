package chapter9.datastructures;

import java.util.*;

public class CafeSalad{

    public static long k, q;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Customer> pr = new PriorityQueue<>();
        q = in.nextLong();
        for (long i = 0; i < q; i++) {
            k = in.nextLong();
            String[] line = in.nextLine().trim().split(" ");
            for (int j = 0; j < k; j++) {
                pr.add(new Customer(line[j * 2], Long.parseLong(line[j * 2 + 1]) + i));
            }
            long t = 0;
            List<Customer> delete = new ArrayList<>();
            while (!pr.isEmpty() && t-i <= 1) {
                Customer c = pr.poll();
                t = c.expire;
                if (t - i == 1) {
                    delete.add(c);
                } else {
                    pr.add(c);
                }
            }
            if (!pr.isEmpty()) {
                Optional<Customer> first = pr.stream().sorted(Comparator.comparing(o -> o.name)).findFirst();
                pr.remove(first.get());
                delete.add(first.get());
            }
            delete.stream().sorted(Comparator.comparing(o -> o.name)).forEach(e -> {
                System.out.print(e.name + " ");
            });
            System.out.println();
        }
    }

    public static class Customer implements Comparable {

        public String name;
        public long expire;

        public Customer(String name, long expire) {
            this.name = name;
            this.expire = expire;
        }

        @Override
        public int compareTo(Object o) {
            Customer c = (Customer) o;
            return (int) (this.expire - c.expire);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return expire == customer.expire &&
                    name.equals(customer.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, expire);
        }
    }

}
