// Test week - 3
// Find how many integers exist such that:

// every element in the first array is a factor of that integer
// and that integer is a factor of every element in the second array.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;

        // Problem constraints limit values to 100 max
        for (int i = 1; i <= 100; i++) {
            boolean isValid = true;

            // Condition 1: All elements in 'a' must be factors of 'i'
            for (int factor : a) {
                if (i % factor != 0) {
                    isValid = false;
                    break;
                }
            }

            // Condition 2: 'i' must be a factor of all elements in 'b'
            if (isValid) {
                for (int multiple : b) {
                    if (multiple % i != 0) {
                        isValid = false;
                        break;
                    }
                }
            }

            // If both conditions are met, increment the count
            if (isValid) {
                count++;
            }
        }

        return count;
    }
}

public class CommonFactorFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(a, b);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}