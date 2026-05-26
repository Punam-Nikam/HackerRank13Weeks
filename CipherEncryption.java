import java.util.*;
public class CipherEncryption {
    
    public static String caesarCipher(String s, int k) {

        String result = "";

        k = k % 26;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // lowercase letters
            if (ch >= 'a' && ch <= 'z') {

                ch = (char)(((ch - 'a' + k) % 26) + 'a');
            }

            // uppercase letters
            else if (ch >= 'A' && ch <= 'Z') {

                ch = (char)(((ch - 'A' + k) % 26) + 'A');
            }

            result += ch;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String s = sc.nextLine();

        int k = Integer.parseInt(sc.nextLine());

        System.out.println(caesarCipher(s, k));
    }
}