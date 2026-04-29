import java.util.*;

class Result {

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> res = new ArrayList<>();
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int x : a) {
            if (left.isEmpty() || x <= left.peek())
                left.add(x);

            else
                right.add(x);
            if (left.size() > right.size() + 1)
                right.add(left.poll());
            else if (right.size() > left.size())
                left.add(right.poll());

            if (left.size() == right.size())
                res.add((left.peek() + right.peek()) / 2.0);
            else
                res.add((double) left.peek());
        }

        return res;
    }
}
// List<Integer> temp=new ArrayList<>();
// for(int i=0;i<a.size();i++){
// temp.add(a.get(i));
// Collections.sort(temp);
// int n=temp.size();
// double median;

// if(n%2!=0){
// median=temp.get(n/2);
// }
// else{
// median=(temp.get(n/2-1)+temp.get(n/2))/2.0;
// }
// result.add(median);
// }

// return result;
// }
// }


//simple main code to test the function instead of hackerrank main code
public class MedianOne {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n :");
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        System.out.println("Enter n values : ");
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        List<Double> result = Result.runningMedian(a);

        for (double val : result) {
            System.out.printf("%.1f\n", val);
        }
    }
}