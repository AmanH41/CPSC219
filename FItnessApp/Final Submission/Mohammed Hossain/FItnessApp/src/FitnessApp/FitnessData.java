package FitnessApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * 
 * @author Aman.H
 *
 *         Store all data for all days - figure which day - store data
 *         appropriately
 * 
 */

public class FitnessData {
	ArrayList<WorkDone> totalData;
	String username;

	public FitnessData() {
		username = "Random";
		totalData = new ArrayList<WorkDone>();
		WorkDone today = new WorkDone(LocalDate.now());
		totalData.add(today);

	}

	public void addData(String workType, int minutesWorked, double intensity, double calories, double totalCalories,
			LocalDateTime startDateTime) {
		// iterate through totalData to make sure we have a workday for "today"
		for (WorkDone wd : totalData) {
			if (wd.getDateOfWork().equals(startDateTime.toLocalDate())) {
				wd.addRecord(workType, minutesWorked, intensity, calories, totalCalories, startDateTime);
				return;
			}
		}
		WorkDone today = new WorkDone(startDateTime.toLocalDate());
		today.addRecord(workType, minutesWorked, intensity, calories, totalCalories, startDateTime);
		totalData.add(today);
	}

	// write data to a file, filename is based upon username
	// make sure username is set befor we get sarted

	public void writeToFile() {
		// to make the filename look really good, check also for spaces and special
		// characters and take them out
		String outPutFileName = username.toLowerCase() + ".txt";

		try {
			File outputFile = new File(outPutFileName);
			System.out.println("Writing output to " + outputFile.getCanonicalPath());

			BufferedWriter workDayWriter = new BufferedWriter(new FileWriter(outputFile));
			workDayWriter.write(this.toString());
			workDayWriter.close();

		} catch (IOException iE) {
			System.out.println("Sorry! For some reason we couldn't write to: " + outPutFileName);
			iE.printStackTrace();

		}

	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}


	public String toString() {

		String output = "";

		output = output.concat(Integer.toString(totalData.size()));

		for (WorkDone wd : totalData) {

			output = output.concat(wd.toString());
			output = output.concat("\n");
		}

		return output;
	}

}
