//Problem -18
//Mars Exploration - Given a received message consisting of repeated "SOS" signals, count how many characters were altered during transmission. 
//Compare the received string with the expected repeating "SOS" pattern.

import java.util.*;

public class MarsExploration {

    public static int marsExploration(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) 
        {
            if (i % 3 == 0 || i % 3 == 2) 
            {
                if (s.charAt(i) != 'S') {
                    count++;
                }
            } else {

                if (s.charAt(i) != 'O') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int result = marsExploration(s);

        System.out.println(result);

        sc.close();
    }
}
