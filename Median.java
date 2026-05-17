//Week-1 (MOCK TEST)

import java.util.*;

public class Median {

    public static int findMedian(List<Integer> arr) {

        
        Collections.sort(arr);

        return arr.get(arr.size() / 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            arr.add(sc.nextInt());
        }

        System.out.println(findMedian(arr));
    }
}