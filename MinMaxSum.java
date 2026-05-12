///Problem -2 (Find min and max sum)

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    int n=arr.size();
    long[] additions =new long[n];
    
    for(int i=0;i<n;i++){
        long add=0;
        for(int j=0;j<n;j++){
            if(j!=i){
                add=add+arr.get(j);
            }
        }   
    additions[i]=add;
    }
    long min=additions[0];
    long max=additions[0];
    for(int i=0;i<n;i++){
        if(additions[i]>max){
            max=additions[i];
        }
        if(additions[i]<min){
            min=additions[i];
        }
    }
    System.out.println(min +" "+max);
 }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
