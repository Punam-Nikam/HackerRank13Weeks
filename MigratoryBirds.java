// PROBLEM- 23 MIGRATORY BIRDS
//This problem is = > given an array of bird sightings where each number represents a bird type ID.
// ind which bird type appears the most times
// if multiple bird types have the same highest frequency, return the smallest bird ID\


import java.util.*;

public class MigratoryBirds {

    public static int migratoryBirds(List<Integer> arr) {

        // frequency array
        int[] freq = new int[6];

        // count frequency of each bird
        for (int bird : arr) {
            freq[bird]++;
        }

        int max = 0;
        int answer = 0;

        // find bird with maximum frequency
        for (int i = 1; i <= 5; i++) {

            if (freq[i] > max) {
                max = freq[i];
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // size of array
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        // input elements
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int result = migratoryBirds(arr);

        System.out.println(result);
    }
}