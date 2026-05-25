///PROBLEM - 30 ARRAY LIST PAIRS

// Sort the array and find the minimum absolute difference between adjacent elements.
// Print all pairs of numbers having that smallest difference.


import java.util.*;
public class ArrayListPairs {

    public static List<Integer> closestNumbers(List<Integer> arr) {

        Collections.sort(arr);

        List<Integer> result = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        // Find minimum difference
        for(int i = 0; i < arr.size() - 1; i++)
        {
            int diff = arr.get(i + 1) - arr.get(i);

            if(diff < min)
            {
                min = diff;
            }
        }

        // Store pairs having minimum difference
        for(int i = 0; i < arr.size() - 1; i++)
        {
            int diff = arr.get(i + 1) - arr.get(i);

            if(diff == min)
            {
                result.add(arr.get(i));
                result.add(arr.get(i + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            arr.add(sc.nextInt());
        }

        List<Integer> ans = closestNumbers(arr);

        for(int num : ans)
        {
            System.out.print(num + " ");
        }
    }
}
}
