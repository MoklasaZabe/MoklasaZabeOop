package fabrikMethode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteProductTxt extends Product {

	BufferedWriter aus;
	
	public ConcreteProductTxt() throws IOException {
		aus = new BufferedWriter(new FileWriter("Freizeitbaeder.txt", true));
	}
	
	public void fuegeInDateiHinzu(Freizeitbad freizeit) throws IOException {
		aus.write("\nDaten des Freizeitbades \nName des Freizeitbades : \t" + freizeit.getName()
		+ "\nÖffnungszeit des Freizeitbads:\t " + freizeit.getGeoeffnetVon() + " _ " + freizeit.getGeoeffnetBis()
		+ "\nBockenlänge des Freizeitbads :" + freizeit.getBeckenlaenge()
		+ "\n Wasssertemperatur des Freizeitbads \t" + freizeit.getTemperatur());
	}
	
	public void schliesseDatei() throws IOException {
		aus.close();
	}

}
