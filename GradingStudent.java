// Problem : 8 
// (Grading Students) - This program rounds student grades according to the university grading policy based on the nearest multiple of 5.

import java.util.*;

public class GradingStudent {

    // Function to round grades
    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {

            // No rounding if grade is less than 38
            if (grade < 38) {
                result.add(grade);
            } 
            else {

                // Find next multiple of 5
                int nextMultiple = ((grade / 5) + 1) * 5;

                // Round if difference is less than 3
                if (nextMultiple - grade < 3) {
                    result.add(nextMultiple);
                } 
                else {
                    result.add(grade);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of students
        int n = sc.nextInt();

        List<Integer> grades = new ArrayList<>();

        // Input grades
        for (int i = 0; i < n; i++) {
            grades.add(sc.nextInt());
        }

        // Call function
        List<Integer> result = gradingStudents(grades);

        // Print output
        for (int grade : result) {
            System.out.println(grade);
        }

        sc.close();
    }
}
