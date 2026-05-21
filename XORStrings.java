// ## Problem - 21 XOR Strings
// #  Given two binary strings (strings containing only 0 and 1) of equal length, perform the XOR operation on each corresponding pair of characters
// #  and return the resulting binary string.

///  PYTHON PROBLEM OF DEBUGING

import java.io.*;

public class XORStrings {

        static String string_xor(String s, String t) {

                String res = "";

                for(int i = 0; i < s.length(); i++) {

                if(s.charAt(i) == t.charAt(i))
                    res += "0";
                else
                    res += "1";
    }

    return res;
    }

    public static void main(String[] args) throws IOException {
            
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        String s = br.readLine();
        String t = br.readLine();

        System.out.print(string_xor(s, t));
    }
}
