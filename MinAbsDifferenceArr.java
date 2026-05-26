import java.util.*;

public class MinAbsDifferenceArr {

    public static int minimumAbsoluteDifference(List<Integer> arr) {

    
        Collections.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size() - 1; i++) {

            int diff = Math.abs(arr.get(i) - arr.get(i + 1));

            if (diff < min) {
                min = diff;
            }
        }

        return min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int result = minimumAbsoluteDifference(arr);

        System.out.println(result);
    }
}