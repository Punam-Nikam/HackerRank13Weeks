// Determine whether two arrays can be rearranged so that the sum of corresponding elements in every pair is greater than or equal to a given value k.
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {

        // Sort both arrays
        Collections.sort(A);
        Collections.sort(B);

        int n = A.size();

        // Compare smallest of A with largest of B
        for(int i = 0; i < n; i++) {

            if(A.get(i) + B.get(n - 1 - i) < k) {

                return "NO";
            }
        }

        return "YES";
    }
}
public class ArrayMaxSum {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {

            try {

                String[] firstMultipleInput =
                        bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> A =
                        Stream.of(bufferedReader.readLine()
                        .replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> B =
                        Stream.of(bufferedReader.readLine()
                        .replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.twoArrays(k, A, B);

                bufferedWriter.write(result);
                bufferedWriter.newLine();

            } catch (IOException ex) {

                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}