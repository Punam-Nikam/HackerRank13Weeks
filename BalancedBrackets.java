//PROBLEM - 66 Balanced Brackets
/*
Problem:
Check whether the brackets are balanced.

Return YES or NO.
*/

import java.util.*;
public class BalancedBrackets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bracket string: ");

        String s = sc.next();

        Stack<Character> stack = new Stack<>();

        boolean balanced = true;

        for (char ch : s.toCharArray()) {

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);
            }

            // Closing brackets
            else {

                if (stack.isEmpty()) {

                    balanced = false;
                    break;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {

                    balanced = false;
                    break;
                }
            }
        }

        // If stack still has opening brackets
        if (!stack.isEmpty()) {
            balanced = false;
        }

        if (balanced)
            System.out.println("YES");
        else
            System.out.println("NO");

        sc.close();
    }
}