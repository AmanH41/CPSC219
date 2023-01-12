/* CourseCalculator.java
 * 
 * This program calculates your final grade for CPSC 233 as a weighted average
 * given a set of raw grades in each of five grading categories and the corresponding
 * weights.
 * 
 * All grades below are presented as GPAs, between 0.0 and 4.3
 * 
 * Recall that you will have:
 *   6 Individual Assignments (10% or 0.1 of your overall grade)
 *   8 Individual Quizzes (30% or 0.3 of your overall grade)
 *   	- 6 only count for grades, but we'll take care of this later
 *   1 Project (50% or 0.5 of your overall grade)
 *   Participation Grades (10% or 0.1 of your overall grade)
 */

public class CourseCalculator {

	// TODO: these variables should no longer be public (use the default visibility for now)
	// or static

	public static double[] assignmentGrades = {2.0, 2.0, 2.0, 2.0, 2.0, 2.0};
	public static double[] quizGrades = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
	public static double projectGrade = 1.0;   // we'll deal with the demos and other components of the project later
	public static double participationGrade = 3.0;
	public static double finalGrade = 0.0;
	
	
	// Constructor for the class. Do not modify.	
	public CourseCalculator()
	{
		calculateFinalGrade();
	}
	
	// TODO: implement similar methods for quiz and project grades
	// Don't forget to add an appropriate comment block
				
	public double calculateAssignmentComponent(double [] rawGrades)
	{
		final double assignmentGradeWeight = 0.1;
		return findAverageGrade(rawGrades) * assignmentGradeWeight;
	}
	
	
	public double calculateParticipationComponent(double participationGrade)
	{
		final double participationGradeWeight = 0.1;
		return participationGrade * participationGradeWeight;
	}
	

	// You should refer to this method to help you understand how each of the 
	// methods it calls should be implemented.
	// DO NOT MODIFY.
	public void calculateFinalGrade()
	{
		finalGrade = calculateAssignmentComponent(assignmentGrades) +
				calculateQuizComponent(quizGrades) +
				calculateProjectComponent(projectGrade) +
				calculateParticipationComponent(participationGrade);
	}
	
	// Provided only to help your main method run. 
	// You may modify this, but I do not recommend it
	
	public String toString()
	{
		return "Your final grade will be " + finalGrade;
	}
		


	/* This method should calculate the mean of all the values in the array.
	 * 
	 * To do this, you should sum all the values in the array and divide 
	 * this sum by the number of values in the array
	 * 
	 * DO NOT MODIFY THIS METHOD
	 * 
	 *  @param An array of doubles containing the raw grades to be averaged 
	 * 	@return The mean of the values contained in the input array
	 */
	
	
	public double findAverageGrade(double [] rawGrades)
	{
		double mean = 0.0;
		double sum = 0.0;
		
		for (int gradeCounter = 0; gradeCounter < rawGrades.length; gradeCounter++)
		{
			sum += rawGrades[gradeCounter];
		}
		
		mean = sum / rawGrades.length;
				
		// include a check: if your mean is greater than 4.0 or less than 0.0
		// have the method return 0
		if ((mean < 0.0) || (mean > 4.3))
		{
			mean = 0.0;
		}
	
				
		return mean;
	}
	
	// Provided for your convenience only, to help you understand
	//    how the code is put together. You may modify this.
	
	public static void main(String[] args) {
		
		CourseCalculator myCourseCalculator = new CourseCalculator();
		System.out.println(myCourseCalculator.toString());

	}
	
}


