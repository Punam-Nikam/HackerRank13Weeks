// //PROBLEM - 29 KANGAROO JUMPS
// Determine whether two kangaroos starting at different positions and jumping at different speeds will land at the same location after the same number of jumps.
// Return "YES" if they meet at the same point at the same time, otherwise return "NO".
import java.util.*;

class KangarooJumps {

    public static String kangaroo(int x1, int v1, int x2, int v2) {

        if(v1 > v2 && (x2 - x1) % (v1 - v2) == 0)
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int v1 = sc.nextInt();
        int x2 = sc.nextInt();
        int v2 = sc.nextInt();

        System.out.println(kangaroo(x1, v1, x2, v2));
    }
}