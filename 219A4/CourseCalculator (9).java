import java.util.ArrayList;

/* CourseCalculator.java
 * 
 * This program calculates your final grade for CPSC 219 as a weighted average
 * given a set of raw grades in each of five grading categories and the corresponding
 * weights.
 * 
 * All grades below are presented as GPAs, between 0.0 and 4.3
 * 
 * Recall that you will have:
 *   6 Individual Assignments (10% or 0.1 of your overall grade)
 *   8 Individual Quizzes (30% or 0.2 of your overall grade)
 *   	- 6 only count for grades, but we'll take care of this later
 *   1 Project (50% or 0.5 of your overall grade)
 *   Participation Grades (10% or 0.1 of your overall grade)
 */

public class CourseCalculator {
	
	// Raw grades 
	// Values should be between 0 and 4 (U of C's 4-point grading scale)
	// These values can be changed to test whether the grade calculation is accurate
		
	ArrayList<Double> assignmentGrades;
	ArrayList<Double> quizGrades;
	double projectGrade = 0.0;
	double participationGrade = 0.0;
	double finalGrade = 0.0;

	/* CourseCalculator
	  * Constructor for the class: DO NOT MODIFY 
	 * 
	 * You may wish to note how other methods are called to help you implement them
	 */
		
	public CourseCalculator()
	{
		loadAssignmentGrades(new double[]{2.0, 2.0, 2.0, 2.0, 2.0, 2.0});
		loadQuizGrades(new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0});
		projectGrade = 2.0;
		participationGrade = 2.0;
		calculateFinalGrade();
	}
	
	public void loadAssignmentGrades(double [] rawAGrades)
	{
		assignmentGrades = new ArrayList<Double>();
		for (int arrayCounter = 0; arrayCounter < rawAGrades.length; arrayCounter++)
		{
			// we used to have to create a Double for our double
			// i.e assignmentGrades.add(new Double(rawAGrades[arrayCounter]))
			// but not after Java 9. Now Java does this automatically.
			assignmentGrades.add(rawAGrades[arrayCounter]);
		}
	}
	public void loadQuizGrades(double[] rawQGrades)
	{
		quizGrades = new ArrayList<Double>();
		for (int arrayCounter = 0; arrayCounter < rawQGrades.length; arrayCounter++)
		{
			quizGrades.add(rawQGrades[arrayCounter]);
		}
		
	}

	public double calculateAssignmentGrade()
	{
		final double iAssignmentGradeWeight = 0.1;		
		return findAverageGrade(assignmentGrades) * iAssignmentGradeWeight;
		//return findAverageGrade(dropNGrades(assignmentGrades, 2)) * iAssignmentGradeWeight;
	}
		
	public double calculateQuizGrade()
	{
		final double iQuizGradeWeight = 0.3;
		return findAverageGrade(dropNGrades(quizGrades, 2)) * iQuizGradeWeight;
	}
		
		
	public double calculateProjectGrade()
	{
			final double projectGradeWeight = 0.5;
			return projectGrade * projectGradeWeight;
	}
	
	public double calculateParticipationGrade()
	{
			final double participationGradeWeight = 0.1;
			return participationGrade * participationGradeWeight;
	}
		
	public void calculateFinalGrade()
	{
		finalGrade = calculateAssignmentGrade() +
				calculateQuizGrade() +
				calculateProjectGrade() + 
				calculateParticipationGrade();
	}
	
	public String toString()
	{
		return "Your final grade will be " + finalGrade;
	}
		
	public ArrayList<Double> dropNGrades(ArrayList <Double> gradeList, int numberToDrop)
	{
		ArrayList<Double> droppedList = new ArrayList<Double>();
		for(int itemCounter = 0; itemCounter < gradeList.size(); itemCounter++)
		{
			droppedList.add(gradeList.get(itemCounter));
		}
		
		int dropCounter = 0;
		while((numberToDrop <= gradeList.size()) && (dropCounter < numberToDrop))
		{
			int minIndex = 0;		
			for(int itemCounter = 0; itemCounter < droppedList.size(); itemCounter++)
			{
				if (-1 == droppedList.get(itemCounter).compareTo(droppedList.get(minIndex).doubleValue()))
				{
					minIndex = itemCounter;
				}
			}
			droppedList.remove(minIndex);
			dropCounter++;
		}
		
		return droppedList;
	}
		
		
	/* This method should calculate the mean of all the values in the array.
	 * 
	 * To do this, you should sum all the values in the array and divide 
	 * this sum by the number of values in the array
	 * 
	 *  @param An array of doubles containing the raw grades to be averaged 
	 * 	@return The mean of the values contained in the input array
	 */
	
	public double findAverageGrade(ArrayList<Double> rawGrades)
	{
		double mean = 0.0;
		double sum = 0.0;
		
		for (int gradeCounter = 0; gradeCounter < rawGrades.size(); gradeCounter++)
		{
			sum += rawGrades.get(gradeCounter).doubleValue();
		}
		
		mean = sum / rawGrades.size();
		
		if ((mean < 0.0) || (mean > 4.0))
		{
			mean = 0.0;
		}
		// include a check: if your mean is greater than 4.0 or less than 0.0
		// have the method return 0
				
		return mean;
	}
	
	
	/**
	 * @return the iAssignmentGrades
	 */
	public ArrayList<Double> getAssignmentGrades() {
		ArrayList<Double> assignmentClone = new ArrayList<Double>();
		for (int i = 0; i < assignmentGrades.size(); i++)
		{
			assignmentClone.add(assignmentGrades.get(i));
		}
		return assignmentClone;
	}

	/**
	 * @return the iQuizGrades
	 */
	public ArrayList<Double> getQuizGrades() {
		ArrayList<Double> quizClone = new ArrayList<Double>();
		for (int i = 0; i < quizGrades.size(); i++)
		{
			quizClone.add(quizGrades.get(i));
		}
		return quizClone;
	}

	/**
	 * @return the participationGrade
	 */
	
	public double getParticipationGrade() {
		return participationGrade;
	}
	
	/**
	 * @return the projectGrade
	 */

	public double getProjectGrade() {
		return projectGrade;
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


