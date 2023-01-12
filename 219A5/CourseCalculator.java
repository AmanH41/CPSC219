package application;

import java.util.ArrayList;

/* CourseCalculator.java
 * 
 * This program calculates your final grade for CPSC 219 as a weighted average
 * given a set of raw grades in each of four grading categories and the corresponding
 * weights.
 * 
 * Recall that you will have:
 *   6 Individual Assignments (10% or 0.1 of your overall grade)
 *   6 Individual Quizzes (30% or 0.3 of your overall grade)
 *   1 Project (50% or 0.5 of your overall grade)
 *   1 Participation Grade (10% or 0.1 of your overall grade)
 */

public class CourseCalculator {
	
	private double finalGrade = 0.0;
	private ArrayList<Category> scheme;
	
	/* CourseCalculator
	 * Constructor for the class: DO NOT MODIFY 
	 * 
	 * You may wish to note how other methods are called to help you implement them
	 */
		
	public CourseCalculator()
	{
		
		double [] assignmentGrades = {2.0, 2.0, 2.0, 2.0, 2.0, 2.0};
		double [] quizGrades = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		scheme = new ArrayList<Category>();
		
		scheme.add(new MultiGrade("Assignment", 0.1, 0, assignmentGrades));
		scheme.add(new MultiGrade("Quiz", 0.3, 2, quizGrades ));
		scheme.add(new SingleGrade("Project", 0.5, 4.0));
		scheme.add(new SingleGrade("Participation", 0.1, 4.0));
		calculateFinalGrade();
	}
	
	public void calculateFinalGrade()
	{
		finalGrade = 0.0;
		
		for (int categoryCounter = 0; categoryCounter < scheme.size(); categoryCounter++)
		{
			finalGrade += scheme.get(categoryCounter).calculateGrade();
		}
		
	}
	
	/* double findGrade(String categoryName)
	 * 
	 * @param String categoryName The name of the category whose grade should be returned
	 * @return the weighted grade of the category used as an argument, or 0.0 if 
	 *   the category is not part of the grade scheme
	 * 
	 */
	
	// TODO: implement the findGrade method such that its behaviour is described by the comment above
	
	public double findGrade(String categoryName) {
		
		return 0.0;
	}
	
	public void updateGrade(String categoryName, int index, double newGrade)
	{
		for (Category gradeCategory:scheme)
		{
			if (0 == categoryName.compareTo(gradeCategory.getName()))
			{
				gradeCategory.setGrade(index, newGrade);
			}
		}
	}
	
	public ArrayList<String> getSchemeNames()
	{
		ArrayList<String> schemeNames = new ArrayList<String>();
		for (Category gradeCategory:scheme)
		{
			schemeNames.add(new String(gradeCategory.getName()));
		}
		
		return schemeNames;
	}
	
	
	public String toString()
	{
		return "Your final grade will be " + finalGrade;
	}
		
	/**
	 * @return the finalGrade
	 */
	public double getFinalGrade() {
		return finalGrade;
	}

	public static void main(String [] args)
	{
		CourseCalculator myCalculator = new CourseCalculator();
		System.out.println(myCalculator.toString());
	}
	
}


