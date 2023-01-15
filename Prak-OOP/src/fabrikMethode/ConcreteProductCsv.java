package fabrikMethode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteProductCsv extends Product {

	
	BufferedWriter aus;
	
	public ConcreteProductCsv() throws IOException {
		aus= new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
	}

	public void fuegeInDateiHinzu(Freizeitbad freizeit) throws IOException {
		aus.write(freizeit.gibFreizeitbadZurueck(','));
	}

	@Override
	public void schliesseDatei() throws IOException {
		aus.close();
	}

}
