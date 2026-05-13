//Problem - 16 
//Counting Valleys - Given a sequence of uphill (U) and downhill (D) steps during a hike, determine how many valleys the hiker travels through. A valley starts below sea level and ends when the hiker returns to sea level.

import java.util.*;

public class CountingValleys {

    public static int countingValleys(int steps, String path) {

        int level = 0;
        int valleys = 0;

        for (int i = 0; i < steps; i++) {

            char step = path.charAt(i);

            // Step Up
            if (step == 'U') {
                level++;

                // Coming back to sea level from valley
                if (level == 0) {
                    valleys++;
                }
            }

            // Step Down
            else {
                level--;
            }
        }

        return valleys;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int steps = sc.nextInt();
        String path = sc.next();

        int result = countingValleys(steps, path);

        System.out.println(result);

        sc.close();
    }
}