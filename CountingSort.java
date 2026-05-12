// PROBLEM - 14 //COUNTING SORT 
// Given an array of integers between 0 and 99, return a frequency array that stores how many times each number appears.

import java.util.*;

public class CountingSort {

    public static List<Integer> countingSort(List<Integer> arr) {

        List<Integer> freq = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            freq.add(0);
        }

        for (int num : arr) {
            freq.set(num, freq.get(num) + 1);
        }

        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        List<Integer> result = countingSort(arr);
        for (int x : result) {
            System.out.print(x + " ");
        }
        sc.close();
    }
}
