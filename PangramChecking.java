//Problem - 17
//Pangram Checking - A pangram is a sentence that contains every letter of the English alphabet at least once. Given a string, 
//determine if it is a pangram.

import java.util.*;
public class PangramChecking {

    public static void main(String[] args) {

        String str = "The quick brown fox jumps over the lazy dog";

        str = str.toLowerCase();
       
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                set.add(ch);
            }
        }

        if (set.size() == 26) {
            System.out.println("Pangram");
        } else {
            System.out.println("Not Pangram");
        }
    }
}
//using another ways - (array)

//         boolean[] alphabet = new boolean[26];

//         for (int i = 0; i < str.length(); i++) {

//             char ch = str.charAt(i);

//             if (ch >= 'a' && ch <= 'z') {
//                 alphabet[ch - 'a'] = true;
//             }
//         }

//         boolean allPresent = true;

//         for (boolean letter : alphabet) {
//             if (!letter) {
//                 allPresent = false;
//                 break;
//             }
//         }

//         if (allPresent) {
//             System.out.println("Pangram");
//         } else {
//             System.out.println("Not Pangram");
//         }
//     }
// }
