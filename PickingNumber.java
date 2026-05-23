//PROBLEM - 27 - Picking Numbers

// Find the longest subset in an array where the absolute difference between any two elements is less than or equal to 1.
// The subset can contain only same numbers or consecutive numbers.

import java.util.*;
public class PickingNumber {

    public static int pickingNumbers(List<Integer> a) {

        Collections.sort(a);

        int max = 0;

        for(int i = 0; i < a.size(); i++) {

            int count = 0;

            for(int j = i; j < a.size(); j++) {

                if(Math.abs(a.get(i) - a.get(j)) <= 1) {
                    count++;
                }
                else {
                    break;
                }
            }

            if(count > max) {
                max = count;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> a = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        System.out.println(pickingNumbers(a));

        sc.close();
    }
}

