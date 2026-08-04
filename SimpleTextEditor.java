//Problem - 70 Simple Text Editor

import java.util.*;

/*
Problem:
Implement a Simple Text Editor.

Operations:
1 text -> Append text
2 k    -> Delete last k characters
3 k    -> Print kth character
4      -> Undo last append/delete
*/

public class SimpleTextEditor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder text = new StringBuilder();

        Stack<String> history = new Stack<>();

        System.out.print("Enter number of operations: ");
        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {

            int type = sc.nextInt();

            switch(type) {

                case 1:

                    history.push(text.toString());

                    String str = sc.next();

                    text.append(str);

                    break;

                case 2:

                    history.push(text.toString());

                    int k = sc.nextInt();

                    text.delete(text.length() - k, text.length());

                    break;

                case 3:

                    int index = sc.nextInt();

                    System.out.println(text.charAt(index - 1));

                    break;

                case 4:

                    if(!history.isEmpty())
                        text = new StringBuilder(history.pop());

                    break;
            }
        }

        sc.close();
    }
}