package FitnessApp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * 
 *
 * @author hossa
 *
 *text based interface for gathering data 
 *the data will then be moved to FitnessData
 *
 */

public class FitnessMenu {
	
	private FitnessData appData;
	
	public FitnessMenu() 
	{
		appData = new FitnessData();
	}
	
	public void askForData() 
	{


		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter Username:");
		appData.setUsername(userInput.nextLine());
		
		WorkRecord a = new WorkRecord();
		a.count = 0;
		
		boolean validEntry = false;
		while(!validEntry)
		{
			String NO_FLAG = "no";
			System.out.print("will you perfrom any physical activitys today:"); 
			
			String userFlag = userInput.nextLine().toLowerCase();
			
			if (userFlag.equals(NO_FLAG))
			{
				validEntry = true;
				break;
			}
			else
			{
				// get details about work
				
				System.out.println("What type of physical Activity will you perfrom today?");
			   	System.out.print("Walking(1), Running(2), Weight lifting(3), Swimming(4), Jumping jacks(5) or Bicycling(6):");
				String workTypeRaw = a.checkWorkType(userInput.nextLine());
				
				System.out.print("How long will you perfrom this activity for (minutes):" );
				int minutesWorkedRaw = a.getWorkMinutes(userInput.nextLine());
				
		   	    System.out.println("What intensity will you work in today (High, Medium or Low):");
		   	    double intensityFromUserRaw = a.setIntensity(userInput.nextLine());
		   	    
		   	    double avgcalorie = a.setavgBurnt(workTypeRaw, minutesWorkedRaw, intensityFromUserRaw);
		   	    
		   	    double rawtotalCalories = a.allCalorie(avgcalorie, a.count);
		   	    a.updateCount(rawtotalCalories);
				// add to this.appData()
				
		   	    this.appData.addData(workTypeRaw, minutesWorkedRaw, intensityFromUserRaw, avgcalorie,  rawtotalCalories, LocalDateTime.now());
		   	    
		   	    
			}
			
		}

		
		userInput.close();

	}
	
	public void outPutAllData() 
	{
		System.out.println(appData.toString());
		appData.writeToFile();
	}
	
	public static void main(String[] args) 
	{
		FitnessMenu myFitness = new FitnessMenu();
		
		myFitness.askForData();
		myFitness.outPutAllData();
		
		
	}
	
}






