//Problem - 2
//  Design a contacts application that supports adding names and efficiently finding how many contacts start with a given prefix. The application should handle two types of operations:
// 1. "add name": Add a contact name to the application.
// 2. "find prefix": Find the number of contacts that start with the given prefix.
// 3. The application should be optimized for performance, especially for the "find" operation, which should be efficient even with a large number of contacts. Consider using appropriate data structures to achieve this efficiency.
//test case sample
// 4
// add hack
// add hackerrank
// find hac
// find hak

import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> contacts(List<List<String>> queries) {

    Map<String, Integer> prefixCount = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    for (List<String> query : queries) {

        String operation = query.get(0);
        String value = query.get(1);

        if (operation.equals("add")) {

            StringBuilder prefix = new StringBuilder();

            for (char ch : value.toCharArray()) {
                prefix.append(ch);
                String key = prefix.toString();
                prefixCount.put(key, prefixCount.getOrDefault(key, 0) + 1);
            }

        } else if (operation.equals("find")) {

            result.add(prefixCount.getOrDefault(value, 0));
        }
    }

    return result;
}
}

public class Contacts {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        for (int i = 0; i < queriesRows; i++) {
            queries.add(Arrays.asList(bufferedReader.readLine().split(" ")));
        }

        List<Integer> result = Result.contacts(queries);

        for (int res : result) {
            bufferedWriter.write(res + "\n");
        }

        bufferedWriter.flush();
    }
}
