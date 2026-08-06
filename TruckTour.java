//PROBLEM - 75 // Maximum Subarray Sum

import java.util.*;

public class TruckTour {

    public static int truckTour(int[][] pumps) {

        int start = 0;
        int fuel = 0;
        int total = 0;

        for (int i = 0; i < pumps.length; i++) {

            int petrol = pumps[i][0];
            int distance = pumps[i][1];

            int diff = petrol - distance;

            fuel += diff;
            total += diff;

            // Cannot continue from current start
            if (fuel < 0) {
                start = i + 1;
                fuel = 0;
            }
        }

        if (total >= 0)
            return start;
        else
            return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();

        int[][] pumps = new int[n][2];

        System.out.println("Enter Petrol and Distance:");

        for (int i = 0; i < n; i++) {
            pumps[i][0] = sc.nextInt(); // Petrol
            pumps[i][1] = sc.nextInt(); // Distance
        }

        int ans = truckTour(pumps);

        System.out.println("Starting Petrol Pump Index = " + ans);

        sc.close();
    }
}