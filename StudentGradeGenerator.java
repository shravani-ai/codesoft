package TestCode;
import java.util.Scanner;
public class StudentGradeGenerator {
	public static void main(String args[]) {
		
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter All Subject Marks:");
	int n = sc.nextInt();
	int totalmarks = 0;
	for (int i=1; i<=n; i++) {
		System.out.println("Enter Marks for Subject :" + i + "(out of 100)");
		int marks = sc.nextInt();
		
	while(marks <0  || marks >100)
	{
		System.out.println("Inavlid Marks : Enter right marks :");
		System.out.println("Enter marks for Subject" + i + "(out of 100)");
	}
	totalmarks  += marks ;
}
	System.out.println("Student Marks");
	System.out.println("Total Marks in all Subject : " + totalmarks);
	
	int avgpercentage = totalmarks / n;
	System.out.println("Average Persecntage : " + avgpercentage );
	
	
	if(avgpercentage >= 90) {
		System.out.println("Grade is : A+");
	}
	else if(avgpercentage >= 80) {
		System.out.println("Grade is : B+");
		
	}
	else if(avgpercentage >= 70) {
		System.out.println("Grade is : C+");
		
	}else if(avgpercentage >= 60) {
		System.out.println("Grade is : D+");
		
	}else if(avgpercentage <= 50) {
		System.out.println("Grade is : Fail");
		
	}
	}	
}
