package gui.Sportshallen;

import business.Model;
import javafx.stage.Stage;
import observer.IsObservable;
import observer.IsObserver;

public class SportstaettenControl implements IsObserver {

	private SportstaettenView view;
	private Model model;
	
	
	public SportstaettenControl (Stage stage) {
		
		model =  model.getInstanz();
		view = new SportstaettenView(stage,this,model);	
		model.addObserver(this);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		view.zeigeFreizeitbaederAn();
	}
}
