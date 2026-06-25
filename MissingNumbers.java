// PROBLEM - 38 Week - 5


import java.util.*;

public class MissingNumbers {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        Map<Integer, Integer> freq = new HashMap<>();

        // count in brr
        for (int num : brr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // subtract arr
        for (int num : arr) {
            freq.put(num, freq.get(num) - 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int key : freq.keySet()) {
            if (freq.get(key) > 0) {
                result.add(key);
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int m = sc.nextInt();
        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            brr.add(sc.nextInt());
        }

        List<Integer> result = missingNumbers(arr, brr);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}