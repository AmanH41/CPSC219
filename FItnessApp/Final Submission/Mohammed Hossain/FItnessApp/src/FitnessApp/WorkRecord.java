package FitnessApp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/****
 * 
 * @author hossa
 *
 *this tracks a single "work unit" for the day, one task, duration, intensity and start time
 *also hold methods for calculations and checks for worktpye and intensity.
 */
public class WorkRecord {

	String workType;
	int minutesWorked;
	double intensity; 
	double calories;
	double totalCalories;
	double count;
	ArrayList<WorkRecord> userRecords;
	LocalDateTime startDateTime;
	
    
	String weightFromUser = "";
	String HeightFromUser = "";
	String askBMI = "";
	
	
	public WorkRecord()
	{
		this.startDateTime = LocalDateTime.now();
		
	}

	/**
	 * @param workType
	 * @param mintutesWorked
	 * @param startDateTime
	 */
	public WorkRecord(String workType, int minutesWorked, double intensity, double calories, LocalDateTime startDateTime) 
	{
		super();
		this.workType = workType;
		this.minutesWorked = minutesWorked;
		this.intensity = intensity;
		this.calories = calories;
		this.startDateTime = startDateTime;
	}
	public WorkRecord(String workType, int minutesWorked, double intensity, double calories, double totalCalories , LocalDateTime startDateTime) 
	{
		super();
		this.workType = workType;
		this.minutesWorked = minutesWorked;
		this.intensity = intensity;
		this.calories = calories;
		this.startDateTime = startDateTime;
		this.totalCalories = totalCalories;
	}
	// copy constructor!
	public WorkRecord(WorkRecord oldRecord)
	{
		this.workType = oldRecord.workType;
		this.minutesWorked = oldRecord.minutesWorked;
		this.startDateTime = oldRecord.startDateTime;
		this.intensity = oldRecord.intensity;
		this.calories = oldRecord.calories;
		this.totalCalories = oldRecord.totalCalories;
	}

	
	public int getMinutesWorked() {
		return minutesWorked;
	}
	
	public int getWorkMinutes(String userInput) {
    	int minutesWorked = Integer.parseInt(userInput);
	    if (minutesWorked < 0) 
	    {
	      minutesWorked = 0;
	    }

	    return minutesWorked;	
    }

	public void setMinutesWorked(int minutesWorked) {
		if (minutesWorked >0) 
		{
			this.minutesWorked = minutesWorked;
		}
		else 
		{
			this.minutesWorked = 0;
		}
	}
	
    public int getAllminutes() {
		// TODO Auto-generated method stub
    	int totalMinutes = 0;
    	
    	for (WorkRecord tempRecord : userRecords) 
    	{
    		totalMinutes  += tempRecord.getMinutesWorked();
    	}
		return totalMinutes;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		if (startDateTime.isAfter(LocalDateTime.now()))
		{
			this.startDateTime = LocalDateTime.now();
		}	
		else 
		{
			this.startDateTime = startDateTime;
		}
	}
	
	public String checkWorkType(String inputType)
	{
	
	workType = inputType.toLowerCase();
	
 	if (workType.equals("walking") ) 
 	{
 		workType = "1";
 	}
 	else if (workType.equals("running")) 
 	{
 		workType = "2";
 	}
 	else if (workType.equals("weight lifting")) 
 	{
 		workType = "3";
 	}
 	else if (workType.equals("swimming"))
 	{
 		workType = "4";
 	}
 	else if (workType.equals("Jumping jacks"))
	{
 		workType = "5";
	}
 	else if (workType.equals("bicycling"))
 	{
 		workType = "6";
	}

 	return workType;
	}

	
	 public double setIntensity(String inputType) 
	    {
			String userInputintensity = inputType.toLowerCase();
			double intensity = 0;
			if (userInputintensity.equals("high")) 
			{
				intensity = 1.5;
			}
			else if (userInputintensity.equals("medium")) 
			{
				intensity = 1;
			}
			else if (userInputintensity.equals("low")) 
			{
				intensity = 0.5;
			}
			else 
			{
				intensity  =  1;
			}		
	    	return intensity;	
	    }
	 
	 public double setavgBurnt(String userWorkType, int userMinutesworked, double userIntensity) 
	    {
			final double avgBurntWalking = 7.6;
		    final double avgBurntRunning = 13.2;
		    final double avgBurntWeightlift = 3.72;
		    final double avgBurntSwimming = 8.2;
		    final double avgBurntJumpingJacks = 9.9;
		    final double avgBurntBicycling = 8.67;
	    	double calories = 0;
	    	
	   	    if (userWorkType.equals("1")) 
	   	    {
	    	calories = (double) (userMinutesworked * avgBurntWalking * userIntensity);     
	   	    }
	   	    else if (userWorkType.equals("2")) 
	   	    {
	    	calories = (double) (userMinutesworked * avgBurntRunning * userIntensity);
	   	    } 
	   	    else if (userWorkType.equals("3"))
	   	    {
	   	    calories = (double) (userMinutesworked * avgBurntWeightlift * userIntensity);
	   	    }
	   	    else if (userWorkType.equals("4")) 
	   	    {
	        calories = (double) (userMinutesworked * avgBurntSwimming * userIntensity);
	   	    }
	   	    else if (userWorkType.equals("5")) 
	   	    {
	        calories = (double) (userMinutesworked * avgBurntJumpingJacks * userIntensity);;
	   	    }
	   	    else if (userWorkType.equals("6")) 
	   	    {
	        calories = (double) (userMinutesworked * avgBurntBicycling * userIntensity);
	   	    }
	   	    else 
	   	    {
	   	    calories = 0;
	   	    }
	    	return calories;
	    	
	    }
	 
	  public double allCalorie(double calories, double count) 
	    {
	   	    totalCalories = calories + count; 
	   	    

	   	    return totalCalories;
	    }
	  
	  public double updateCount (double totalCalories) 
	  {
		  count = totalCalories;
		  
		  return count;
	  }
	  
	 
	    public static double setBMI(String userInputweight, String userInputHeight) 
	    {
	    	float weight = Float.parseFloat(userInputweight);
	    	float height =  Float.parseFloat(userInputHeight);
	    	double BMI = weight / (height*height); 
	    	
	    	return BMI;
	    }
	    
	    public String toString() 
	    {
	    	String output;
	    	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

			output = "Activity done:" + workType+ ", Intensity:" + intensity + newLine + "How long did you do the activity:" + Integer.toString(minutesWorked)+ newLine + "Calories burnt:" +calories+
			newLine +"current total calories:"+ totalCalories;
			
			return output;

	    }
	 

}
