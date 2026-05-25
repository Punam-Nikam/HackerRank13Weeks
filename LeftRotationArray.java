//PROBLEM - 28 lEFT ROTATION ARRAY
//Rotate(Shift) the array to the left by d positions, where each left rotation shifts every element one position toward the beginning of the array.
// Return the final array after completing all rotations.

import java.util.*;
public class LeftRotationArray 
{
    public static void main(String[] args) {
        
        // ArrayList<Integer> list = new ArrayList<>(
        //         Arrays.asList(10, 20, 30, 40, 50));

        Scanner sc=new Scanner(System.in);
        List <Integer> list =new ArrayList<>();

        System.out.println("Enter shift count : ");
        int d=sc.nextInt();
        System.out.println("Enter how many nos : ");
        int n=sc.nextInt();

        System.out.println("Enter numbers : ");
        for(int i=0;i<n;i++){
                int c =sc.nextInt();
                list.add(c);

        }

        Collections.rotate(list, d);

        System.out.println(list);
    }
}
        
