import java.util.Scanner;
public class StudentGradeCalculatorTask2{
    public static void main(String[] args){
        System.out.println("-----------------------------------");
        System.out.println("     Student Grade Calculator ");
        System.out.println("-----------------------------------");
        Scanner scan = new Scanner(System.in);
        // getting total number of sujects
        System.out.print("Enter number of subjects : ");
        int n = scan.nextInt();
        System.out.println();
        int[] marks = new int[n];
        // getting marks in each subject
        for(int i=0;i<n;i++){
            System.out.print("Enter the mark in subject " + (i+1) + " out of 100 : ");
            marks[i]=scan.nextInt();
            System.out.println();
        }
        // Calculating total marks
        int totalMarks = 0;
        for(int var:marks){
            totalMarks += var;
        }
        // Calculating Percentage
        double averagePercentage = (double)totalMarks / (n);
        String  grade = "";
        //Assigning Grade
        if(averagePercentage >= 90 && averagePercentage <=100)
            grade = "A+";
        else if(averagePercentage>=80)
            grade = "A";
        else if(averagePercentage>=70)
            grade = "B";
        else if(averagePercentage>=60)
            grade = "C";
        else if(averagePercentage>=50)
            grade = "D";
        else if(averagePercentage>=35)
            grade = "E";
        else
            grade = "F";
        // Displaying Results
        System.out.println("-----------------------------------");
        System.out.println("             RESULTS ");
        System.out.println("-----------------------------------");
        System.out.println("Total Marks        : " + totalMarks+" / "+(n*100));
        System.out.println("Average Percentage : " + averagePercentage  + " %");
        System.out.println("Grade              : " + grade);
        System.out.println("-----------------------------------");
    }
}