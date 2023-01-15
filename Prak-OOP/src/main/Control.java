package main;


import business.Model;
import javafx.stage.Stage;
import observer.IsObserver;

import java.io.IOException;

public class Control implements IsObserver{

	private Model model;
	private View view;
	
	public Control (Stage stage) {
		model = model.getInstanz();
		view = new View (model,this,stage);
		model.addObserver(this);
	}
	
	void schreibeFreizeitbaederInDatei (String typ) {
		try {
			if("csv".equals(typ)) {
				model.schreibeFreizeitbaederInCsvDatei();
			}else if("txt".equals(typ)) {
				model.schreibeFreizeitbaederInTxtDatei();
			}
			else {
				view.zeigeInformationsfensterAn("Noch nicht implemntiert!");
			}
		} catch (IOException exc) {
			view.zeigeFehlermeldungAn("IOException beim Speihern");
		} catch (Exception exc) {
			view.zeigeFehlermeldungAn("Unbekannte Fehler beim Speichern");
		}
	}

	@Override
	public void update() {
		view.zeigeFreizeitbaederAn();
		//view.Jalal();
	}
}