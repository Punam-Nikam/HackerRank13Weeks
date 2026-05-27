//PROBLEM - 35 MAX MIN DIFF

// Select k integers from the array such that the difference between the maximum and minimum selected elements is minimized.
// Return the minimum possible unfairness value.

import java.util.*;

public class MaxMinDiff {

    public static int maxMin(int k, List<Integer> arr) {

        Collections.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.size() - k; i++) {

            int diff = arr.get(i + k - 1) - arr.get(i);

            min = Math.min(min, diff);
        }

        return min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(maxMin(k, arr));
    }
}