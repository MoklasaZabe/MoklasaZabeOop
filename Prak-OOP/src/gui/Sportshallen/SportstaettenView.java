package gui.Sportshallen;

import business.Freizeitbad;
import business.Model;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import javafx.scene.control.Alert.AlertType;

public class SportstaettenView {

	private SportstaettenControl sportcontrol;
	private Model model;
	private Pane pane = new Pane();

	private Button btnAnzeige = new Button("Anzeige");
	private TextArea txtAnzeige = new TextArea();

	private Label lblAnzeige = new Label("Anzeige");

	public SportstaettenView(Stage stage, SportstaettenControl control, Model model) {
		this.sportcontrol = control;
		this.model = model;

		Scene scene = new Scene(this.pane, 560, 340);
		stage.setTitle("Anzeige von Sportstätten");
		stage.setScene(scene);
		stage.show();
		this.initListener();
		this.initKomponenten();

	}

	private void initListener() {

		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				zeigeFreizeitbaederAn();
			}
		});
	}

	private void initKomponenten() {
		// Labels

		Font font = new Font("Arial", 19);
		lblAnzeige.setLayoutX(310);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");

		pane.getChildren().addAll(lblAnzeige);
		// Textfelder

		// pane.getChildren().addAll(txtName, txtGeoeffnetVon, txtGeoeffnetBis,
		// txtBeckenlaenge, txtWassTemperatur);

		// Textbereich
		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(310);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(220);
		txtAnzeige.setPrefHeight(185);
		pane.getChildren().add(txtAnzeige);

		// Buttons
		btnAnzeige.setLayoutX(310);
		btnAnzeige.setLayoutY(290);
		pane.getChildren().addAll(btnAnzeige);
	}

	public void zeigeFreizeitbaederAn() {
		if (model.getFreizeitbad().size() > 0) {

			StringBuffer text = new StringBuffer();

			for (Freizeitbad i : model.getFreizeitbad()) {
				text.append(i.gibFreizeitbadZurueck(' ') + "\n");
			}
			this.txtAnzeige.setText(text.toString());

		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}
}
