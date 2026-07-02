import java.util.*;

public class MisereNimGame {

    public static String misereNim(List<Integer> s) {

        boolean allOnes = true;
        int xor = 0;

        // Calculate XOR of all piles and check if every pile has only one stone
        for (int stones : s) {
            xor ^= stones;

            if (stones != 1)
                allOnes = false;
        }

        // Case 1: All piles contain only one stone
        if (allOnes) {
            if (s.size() % 2 == 0)
                return "First";
            else
                return "Second";
        }

        // Case 2: At least one pile has more than one stone
        if (xor == 0)
            return "Second";
        else
            return "First";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            List<Integer> s = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                s.add(sc.nextInt());
            }

            System.out.println(misereNim(s));
        }

        sc.close();
    }
}