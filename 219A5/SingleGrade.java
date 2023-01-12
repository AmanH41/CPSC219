package application;

/*****************************
 * class ProjectCategory
 * 
 * This class represents the project grade of the course. 
 * It contains the following instance variables:
 * 
 */


public class SingleGrade extends Category {
	public SingleGrade(String name, double weight, double rawGrade)
	{
		super(name, weight, new double[]{rawGrade});
	}


}
