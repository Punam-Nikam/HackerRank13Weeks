//PROBLEM - 52 New Year Chaos

// There are n people standing in a queue, initially in the order 1, 2, 3, ..., n. A person can bribe the person directly in front of them to swap places, but each person can bribe at most two times. Given the final order of the queue, print the minimum number of bribes, or print "Too chaotic" if someone must have bribed more than two people.

import java.util.*;

public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {

        int bribes = 0;

        for (int i = q.size() - 1; i >= 0; i--) {

            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {

                if (q.get(j) > q.get(i))
                    bribes++;
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.print("Enter number of people: ");
            int n = sc.nextInt();

            List<Integer> q = new ArrayList<>();

            System.out.println("Enter final queue:");

            for (int i = 0; i < n; i++) {
                q.add(sc.nextInt());
            }

            minimumBribes(q);
        }

        sc.close();
    }
}