package FitnessApp;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class FitnessAppGUI extends Application
{

	FitnessData myData;
	WorkRecord myFitness= new WorkRecord();;
	
	Button minutesButton;
	
	public FitnessAppGUI() 
	{
		super();
		myData = new FitnessData();
		myData.setUsername("aman");
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		
		
		/*
		 * VBox root = new VBox(); root.setPrefSize(600, 600);
		 * 
		 * TextField input = new TextField(); input.setFont(Font.font(18)); Text output
		 * = new Text();
		 * 
		 * Button button = new Button("Enter"); button.setOnAction(e ->
		 * {output.setText(input.getText()); });
		 * 
		 * 
		 * root.getChildren().addAll( input, button, output );
		 */
		 
		
		FlowPane root = new FlowPane(Orientation.HORIZONTAL);
		
		// drop down for WorkType
		ChoiceBox<String> WorkTypeDrop = new ChoiceBox<>();
		
		//getItems returns the observabileList object which you can add items to
		HBox WorkTypeList = new HBox();
		WorkTypeDrop.getItems().addAll("walking", "running", "weight lifting", "swimming", "Jumping jacks", "bicycling");
		WorkTypeList.getChildren().add(WorkTypeDrop);
		
		//set default value 
		WorkTypeDrop.setValue("walking");
		
		//layout for work type list 
		WorkTypeList.setPadding(new Insets(5, 5, 5, 5));
		root.getChildren().add(WorkTypeList);

		//set number for mins
		HBox minutesRow = new HBox();
		TextField minutesBox = new TextField("Enter minutes worked");
		minutesRow.getChildren().add(minutesBox);
		

		//layout for minutes 	
		minutesRow.setPadding(new Insets(5, 5.0, 5.0, 5.0));
		root.getChildren().add(minutesRow);
		
		//handler for minute button 
		//minutesButton.setOnAction(e -> getMinutes(minutesBox.getText()));
		
		//drop down for Intensity 
		ChoiceBox<String> intensityDrop = new ChoiceBox<>();
		
		//getItems returns athe observableList object which you can add items to 
		HBox intensityList = new HBox();
		intensityDrop.getItems().addAll("low", "medium", "high");
		intensityList.getChildren().add(intensityDrop);
		
		//set default value
		intensityDrop.setValue("medium");
		
		//layout for intensity 
		intensityList.setPadding(new Insets(5, 5, 5, 5));
		root.getChildren().add(intensityList);
		
		

		//set ouptput for calorie 
		Text output = new Text();

		
		//get calories
		Button CaloriesButton  = new Button("Click to get calories burnt");
		
		root.getChildren().add(CaloriesButton);
		CaloriesButton.setOnAction(e -> output.setText(setCalories(WorkTypeDrop, minutesBox.getText(), intensityDrop)));
		root.getChildren().add(output);
		

		Scene scene = new Scene(root);
		primaryStage.setTitle("Fitness App User: " +  myData.getUsername());
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}


	private String setCalories(ChoiceBox<String> workTypeDrop, String text, ChoiceBox<String> intensityDrop) {
		
		try {
		String workType = workTypeDrop.getValue();
		String minutes = text;
		String Intensity = intensityDrop.getValue();
		
		String workTypeRaw = myFitness.checkWorkType(workType);
		int minutesWorkedRaw = myFitness.getWorkMinutes(minutes);
		double intensityFromUserRaw = myFitness.setIntensity(Intensity);
		
		double avgcalorie = myFitness.setavgBurnt(workTypeRaw, minutesWorkedRaw, intensityFromUserRaw);
		
		String cal = ("Calories burnt: " + Double.toString(avgcalorie));
		return cal;
		}
		catch(NumberFormatException e) 
		{
			
			String cal = "Form was incorrectly filled";
			return cal;
		}

	}
	


	public static void main(String [] args)
	{
		launch(args);
	}
}
	
