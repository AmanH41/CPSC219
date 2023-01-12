package FitnessApp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * workday
 * 
 * @author hossa
 *
 *         This class stores all of the records for a given day for a single
 *         user
 *
 */

public class WorkDone {
	ArrayList<WorkRecord> dayRecords;
	LocalDate dateOfWork;

	/**
	 * @param dateOfWork This is the day that all of the work records in this object
	 *                   were performed
	 */
	public WorkDone(LocalDate dateOfWork) {
		super();
		this.dateOfWork = dateOfWork;
		dayRecords = new ArrayList<WorkRecord>();
	}

	/**
	 * @param dayRecords
	 */
	public WorkDone(ArrayList<WorkRecord> dayRecords) {
		super();
		this.dayRecords = new ArrayList<WorkRecord>();

		for (WorkRecord wr : dayRecords) {
			this.dayRecords.add(new WorkRecord(wr));
		}
	}

	// copy constructor
	public WorkDone(WorkDone toCopy) 
	{
		super();

		this.dateOfWork = toCopy.dateOfWork;
		this.dayRecords = new ArrayList<WorkRecord>();

		for (WorkRecord wr : toCopy.dayRecords) 
		{
			this.dayRecords.add(new WorkRecord(wr));
		}
	}

	public void addRecord(WorkRecord session) 
	{
		dayRecords.add(new WorkRecord(session));
	}

	public void addRecord(String workType, int minutesWorked, double intensity, double calories, double totalCalories, LocalDateTime startDateTime) 
	{
		dayRecords.add(new WorkRecord(workType, minutesWorked, intensity, calories, totalCalories, startDateTime));
	}

	/**
	 * @return the dayRecords
	 */
	public ArrayList<WorkRecord> getDayRecords() {
		ArrayList<WorkRecord> recordClone = new ArrayList<WorkRecord>();

		for (WorkRecord wr : dayRecords) {
			recordClone.add(new WorkRecord(wr));
		}

		return recordClone;
	}

	/**
	 * @param dayRecords the dayRecords to set
	 */
	public void setDayRecords(ArrayList<WorkRecord> dayRecords) {
		this.dayRecords = dayRecords;
	}

	/**
	 * @return the dateOfWork
	 */
	public LocalDate getDateOfWork() {
		return dateOfWork;
	}

	/**
	 * @param dateOfWork the dateOfWork to set
	 */
	public void setDateOfWork(LocalDate dateOfWork) {
		this.dateOfWork = dateOfWork;
	}

	public String toString() {
		String output = dateOfWork.toString() + ": \n";

		if (!dayRecords.isEmpty()) {
			for (WorkRecord wr : dayRecords) {
				output = output.concat(wr.toString());
				output = output.concat("\n");
			}
		}

		return output;
	}


}


