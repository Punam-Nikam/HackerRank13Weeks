//Problem - 5
//camel case convertor
import java.util.*;

public class CamelCaseConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            String input = sc.nextLine();

            String[] parts = input.split(";");

            String operation = parts[0];
            String type = parts[1];
            String text = parts[2];

            // SPLIT OPERATION
            if (operation.equals("S")) {

                // remove () for methods
                if (type.equals("M")) {
                    text = text.replace("()", "");
                }

                String result = "";

                for (int i = 0; i < text.length(); i++) {

                    char ch = text.charAt(i);

                    // if uppercase letter
                    if (Character.isUpperCase(ch)) {
                        result += " " + Character.toLowerCase(ch);
                    } else {
                        result += ch;
                    }
                }

                // remove extra starting space
                result = result.trim();

                System.out.println(result);
            }

            // COMBINE OPERATION
            else if (operation.equals("C")) {

                String[] words = text.split(" ");

                String result = "";

                for (int i = 0; i < words.length; i++) {

                    String word = words[i];

                    // CLASS
                    if (type.equals("C")) {

                        result += Character.toUpperCase(word.charAt(0))
                                + word.substring(1);

                    }

                    // VARIABLE or METHOD
                    else {

                        if (i == 0) {
                            result += word;
                        } else {
                            result += Character.toUpperCase(word.charAt(0))
                                    + word.substring(1);
                        }
                    }
                }

                // add () for method
                if (type.equals("M")) {
                    result += "()";
                }

                System.out.println(result);
            }
        }

        sc.close();
    }
}
