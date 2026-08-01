//PROBLEM - 65 Super Reduced String
/*
Problem:
Remove adjacent equal characters repeatedly.
If string becomes empty, print "Empty String".
*/
import java.util.*;
public class SuperReducedString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String s = sc.next();

        Stack<Character> stack = new Stack<>();

        // Traverse each character
        for (char ch : s.toCharArray()) {

            // If same as top, remove pair
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }

            // Otherwise push character
            else {
                stack.push(ch);
            }
        }

        // If stack becomes empty
        if (stack.isEmpty()) {
            System.out.println("Empty String");
        }

        // Otherwise print remaining characters
        else {

            StringBuilder ans = new StringBuilder();

            for (char ch : stack) {
                ans.append(ch);
            }

            System.out.println("Reduced String: " + ans);
        }

        sc.close();
    }
}
