//PROBLEM - 36 STRING PASSWORD
// Determine the minimum number of characters needed to make a password strong.
// A strong password must contain uppercase, lowercase, digit, special character, and minimum length 6.
import java.util.*;

public class StringPassword {


    public static int minimumNumber(int n, String password) {

        int digit = 0;
        int lower = 0;
        int upper = 0;
        int special = 0;

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (ch >= '0' && ch <= '9') {
                digit = 1;
            }

            else if (ch >= 'a' && ch <= 'z') {
                lower = 1;
            }

            else if (ch >= 'A' && ch <= 'Z') {
                upper = 1;
            }

            else {
                special = 1;
            }
        }

        int missing = (1 - digit) + (1 - lower)
                    + (1 - upper) + (1 - special);

        return Math.max(missing, 6 - n);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String password = sc.next();

        System.out.println(minimumNumber(n, password));
    }
}