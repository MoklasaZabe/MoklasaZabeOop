package fabrikMethode;

import java.io.IOException;

import business.Freizeitbad;

public abstract class Product {

	public abstract void fuegeInDateiHinzu(Freizeitbad freizeit) throws IOException;

	public abstract void schliesseDatei() throws IOException;
}
