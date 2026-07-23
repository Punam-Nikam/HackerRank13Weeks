//PROBLEM - 53 Goodland Electricity

// Goodland has n cities arranged in a straight line. Some cities can have power plants (1), while others cannot (0). A power plant built at a city supplies electricity to cities within a distance of k - 1 on both sides. Find the minimum number of power plants required to cover all cities, or return -1 if it is impossible.

import java.util.*;
public class GoodlandElectricity {

    public static int pylons(int k, List<Integer> arr) {

        int n = arr.size();

        int count = 0;

        int current = 0;

        while (current < n) {

            int plant = Math.min(current + k - 1, n - 1);

            while (plant >= current - (k - 1)) {

                if (plant >= 0 && arr.get(plant) == 1)
                    break;

                plant--;
            }

            if (plant < current - (k - 1))
                return -1;

            count++;

            current = plant + k;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        System.out.println("Enter city suitability (0 or 1):");

        for (int i = 0; i < n; i++)
            arr.add(sc.nextInt());

        System.out.println("Minimum Plants = " + pylons(k, arr));

        sc.close();
    }
}
