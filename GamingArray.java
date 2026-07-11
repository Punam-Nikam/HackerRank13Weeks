//PROBLEM - 47 Gaming Array

/*Andy and Bob take turns removing the maximum element and everything to its right from an array (Bob goes first). 
Whoever makes the last possible move wins. Print ANDY or BOB for each game. */


import java.io.*;
import java.util.*;

public class GamingArray {

    // Core logic: count "new maximums" while scanning left to right
    public static String gamingArray(List<Integer> arr) {
        int moves = 0;
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > max) {
                max = val;
                moves++;
            }
        }
        return (moves % 2 == 0) ? "ANDY" : "BOB";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of games ");
        int g = Integer.parseInt(br.readLine().trim());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < g; i++) {
            System.out.println("Enter the size of the array for game " + (i + 1));
            int n = Integer.parseInt(br.readLine().trim()); // array size (not really needed here)
            System.out.println("Enter the elements of the array for game " + (i + 1));
            String[] parts = br.readLine().trim().split("\\s+");

            List<Integer> arr = new ArrayList<>();
            for (String p : parts) {
                arr.add(Integer.parseInt(p));
            }

            String result = gamingArray(arr);
            output.append(result).append("\n");
        }

        System.out.print(output);
    }
}