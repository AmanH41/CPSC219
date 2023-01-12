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

public class Square {
    int posX = 0;
    int posY = 0;
    
    int side = 0;

    public Square(int newX, int newY, int newSide) {
        posX = newX;
        posY = newY;
        side = newSide;
    }

    public Square(int newX, int newY) {
        posX = newX;
        posY = newY;
        side = 1;
    }
    

    public static void main(String [] args)
    {
        int myPosX = 5;
        int mySide = 1;

        Square sq1 = new Square(myPosX, mySide);
    }  
    
}


