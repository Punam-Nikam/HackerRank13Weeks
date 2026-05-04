//Problem -3 (week-1)
// Time Conversion
// Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

import java.util.*;

class Result {
    public static String timeConversion(String s) {
    
    int hour = Integer.parseInt(s.substring(0, 2));
    String rest = s.substring(2, 8); // example: ":05:45"
    
    if (s.endsWith("PM")) {
        if (hour != 12) {
            hour += 12;
        }
    } else { // ends with "AM"
        if (hour == 12) {
            hour = 0;
        }
    }
    
    // Format hour with leading zero and add rest
    return String.format("%02d", hour) + rest;
}
}
public class TimeConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(Result.timeConversion(s));
        sc.close();
    }
}
