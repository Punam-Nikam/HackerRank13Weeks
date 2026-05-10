import java.util.*;

public class SparseArrays {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        List<Integer> result = new ArrayList<>();

        for(String query : queries) {

            int count = 0;

            for(String str : strings) {

                if(query.equals(str)) {
                    count++;
                }
            }

            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<String> strings = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            strings.add(sc.nextLine());
        }

        int q = sc.nextInt();
        sc.nextLine();

        List<String> queries = new ArrayList<>();

        for(int i = 0; i < q; i++) {
            queries.add(sc.nextLine());
        }

        List<Integer> result = matchingStrings(strings, queries);

        // Print result
        for(int count : result) {
            System.out.println(count);
        }

        sc.close();
    }
}