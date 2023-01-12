import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class CourseCalculatorTest {
	@Test 
	public void test_loadAssignmentGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			expectedList.add(testArray[testCounter]);
		}
		
		testCalculator.loadAssignmentGrades(testArray);
		ArrayList<Double> actualList = testCalculator.getAssignmentGrades();
		
		assertArrayEquals("Testing the loading of assignmentGrades", expectedList.toArray(), actualList.toArray());
	}
	
	@Test 
	public void test_loadQuizGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			expectedList.add(testArray[testCounter]);
		}
		
		testCalculator.loadQuizGrades(testArray);
		ArrayList<Double> actualList = testCalculator.getQuizGrades();
		
		assertArrayEquals("Testing the loading of quizGrades",expectedList.toArray(), actualList.toArray());
	}
	
	@Test 
	public void test_calculateAssignmentGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		testCalculator.loadAssignmentGrades(testArray);
		double testActual = testCalculator.calculateAssignmentGrade();
		double expected = 0.1;
		assertEquals("Checking whether the calculatingAssignment method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test 
	public void test_calculateQuizGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 0.0, 0.0, 0.0};
		testCalculator.loadQuizGrades(testArray);
		double testActual = testCalculator.calculateQuizGrade();
		double expected = 0.3;
		assertEquals("Checking whether the calculateQuizGrade method returns the correct value", expected, testActual, 0.00001);
	}
	

	@Test
	public void test_calculateProjectGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double testActual = testCalculator.calculateProjectGrade();
		double expected = 1.0;
		assertEquals("Checking whether the calculateProjectGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_calculatePartipcationGrade_Default()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double testActual = testCalculator.calculateParticipationGrade();
		double expected = 0.2;
		assertEquals("Checking whether the calculateParticipationGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	
	@Test
	public void test_dropNGrades_DropOne()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(testArray[testCounter]);
			expectedList.add(testArray[testCounter]);
		}

		ArrayList<Double> actualList = (testCalculator.dropNGrades(testList, 1));
		expectedList.remove(0);
				
		assertArrayEquals("Using dropNGrades() to drop one grade", expectedList.toArray(), actualList.toArray());
	}
	
	@Test
	public void test_dropNGrades_DropTwo()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(testArray[testCounter]);
			expectedList.add(testArray[testCounter]);
		}

		ArrayList<Double> actualList = (testCalculator.dropNGrades(testList, 2));
		expectedList.remove(1);
		expectedList.remove(0);
				
		assertArrayEquals("Using dropNGrades() to drop two grades",expectedList.toArray(), actualList.toArray());
	}
	
	@Test
	public void test_dropNGrades_DropTooMany()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(testArray[testCounter]);
			expectedList.add(testArray[testCounter]);
		}

		ArrayList<Double> actualList = (testCalculator.dropNGrades(testList, 3));
						
		assertArrayEquals("Using dropNGrades() to drop too many grades",expectedList.toArray(), actualList.toArray());
	}
	
	@Test
	public void test_dropNGrades_encapsulated()
	{
		CourseCalculator testCalculator = new CourseCalculator();
		double [] testArray = {1.0, 2.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		ArrayList<Double> expectedList = new ArrayList<Double>();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(testArray[testCounter]);
			expectedList.add(testArray[testCounter]);
		}

		ArrayList<Double> actualList = (testCalculator.dropNGrades(testList, 3));
						
		assertNotSame("Testing to ensure a copy of the list is returned.", testList, actualList);
	}
	
	@Test
	public void test_findAverageGrade_Default()
	{
		double expected = 2.5;
		CourseCalculator testCalculator = new CourseCalculator();
		ArrayList<Double> testList = new ArrayList<Double>();
		double [] testArray = {1.0, 2.0, 3.0, 4.0};
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(testArray[testCounter]);
		}
		double testActual = testCalculator.findAverageGrade(testList);
		assertEquals("Checking whether the findAverageGrade method returns the correct value", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_findAverageGrade_Too_Small()
	{
		double expected = 0.0;
		double [] testArray = {-1.0, 2.0, -13.0, -1.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		CourseCalculator testCalculator = new CourseCalculator();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(testArray[testCounter]);
		}		
		double testActual = testCalculator.findAverageGrade(testList);
		assertEquals("Checking whether the findAverageGrade method checks for results that are too small", expected, testActual, 0.00001);
	}
	
	@Test
	public void test_findAverageGrade_Too_Large()
	{
		double expected = 0.0;
		double [] testArray = {1.0, 2.0, 13.0, 1.0};
		ArrayList<Double> testList = new ArrayList<Double>();
		CourseCalculator testCalculator = new CourseCalculator();
		for (int testCounter = 0; testCounter < testArray.length; testCounter++)
		{
			testList.add(testArray[testCounter]);
		}	
		double testActual = testCalculator.findAverageGrade(testList);
		assertEquals("Checking whether the findAverageGrade method checks for results that are too small", expected, testActual, 0.00001);
	}
	
}
