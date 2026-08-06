//PROBLEM - 76 // Weighted uniform Strings

import java.util.*;

public class WeightedUniformStrings{

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {

        HashSet<Integer> weights = new HashSet<>();

        int currentWeight = 0;

        for (int i = 0; i < s.length(); i++) {

            int value = s.charAt(i) - 'a' + 1;

            // Same character -> extend current uniform substring
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                currentWeight += value;
            } else {
                // New character -> start new weight
                currentWeight = value;
            }

            weights.add(currentWeight);
        }

        List<String> result = new ArrayList<>();

        for (int q : queries) {
            if (weights.contains(q))
                result.add("Yes");
            else
                result.add("No");
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Enter the string
        System.out.print("Enter string: ");
        String s = sc.next();

        // Number of queries
        System.out.print("Enter number of queries: ");
        int n = sc.nextInt();

        List<Integer> queries = new ArrayList<>();

        System.out.println("Enter query values:");

        for (int i = 0; i < n; i++) {
            queries.add(sc.nextInt());
        }

        List<String> ans = weightedUniformStrings(s, queries);

        System.out.println("\nOutput:");

        for (String x : ans) {
            System.out.println(x);
        }

        sc.close();
    }
}