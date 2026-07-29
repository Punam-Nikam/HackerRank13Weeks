/*
Problem Statement:
Given the total money and the cost of each ice cream flavor,
find two different flavors whose total cost equals the given money.
Print their 1-based indices.
*/

import java.util.*;

public class IceCreamParlor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total money: ");
        int money = sc.nextInt();

        System.out.print("Enter number of flavors: ");
        int n = sc.nextInt();

        int[] cost = new int[n];

        System.out.println("Enter flavor costs:");

        for (int i = 0; i < n; i++)
            cost[i] = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int need = money - cost[i];

            if (map.containsKey(need)) {

                System.out.println("\nAnswer:");
                System.out.println((map.get(need) + 1) + " " + (i + 1));
                return;
            }

            map.put(cost[i], i);
        }

        sc.close();
    }
}