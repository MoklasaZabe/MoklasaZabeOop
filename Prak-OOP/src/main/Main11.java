package main;


import gui.Sportshallen.SportstaettenControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main11 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new Control(primaryStage);
		Stage fensterSportstaetten = new Stage();
		new SportstaettenControl(fensterSportstaetten);
	}	
	
	public static void main(String[] args){
		launch(args);
		System.out.println(" ");
	}
}

//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


//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