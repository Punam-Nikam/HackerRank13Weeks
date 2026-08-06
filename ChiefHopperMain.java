//PROBLEM - 74 // Maximum Subarray Sum

import java.util.*;

public class ChiefHopperMain {

    public static int chiefHopper(int[] arr) {

        int energy = 0;

        // Traverse from last building
        for (int i = arr.length - 1; i >= 0; i--) {

            energy = (energy + arr[i] + 1) / 2;
        }

        return energy;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Enter number of buildings
        System.out.print("Enter number of buildings: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Enter heights
        System.out.println("Enter building heights:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = chiefHopper(arr);

        System.out.println("Minimum Initial Energy = " + ans);

        sc.close();
    }
}