import java.util.*;

public class LargerstPerimeterTriangle {

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {

        Collections.sort(sticks);

        for (int i = sticks.size() - 1; i >= 2; i--) {

            int a = sticks.get(i - 2);
            int b = sticks.get(i - 1);
            int c = sticks.get(i);

            // triangle condition
            if (a + b > c) {

                List<Integer> result = new ArrayList<>();

                result.add(a);
                result.add(b);
                result.add(c);

                return result;
            }
        }

        return Arrays.asList(-1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> sticks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sticks.add(sc.nextInt());
        }

        List<Integer> result = maximumPerimeterTriangle(sticks);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}