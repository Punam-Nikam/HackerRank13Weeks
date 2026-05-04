///Problem - 1 (Plus minus)

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int zcount = 0, pcount = 0, ncount = 0;
        int n = arr.size();
        
        for (int num : arr) {
            if (num < 0) 
               ncount++;
            else if (num > 0) 
               pcount++;
            else 
                zcount++;
        }
        
        System.out.printf("%.6f\n", (double) pcount / n);
        System.out.printf("%.6f\n", (double) ncount / n);
        System.out.printf("%.6f\n", (double) zcount / n);
    }
}
public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
