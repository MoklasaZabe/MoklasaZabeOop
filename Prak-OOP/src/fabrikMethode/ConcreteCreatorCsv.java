package fabrikMethode;

import java.io.IOException;

public class ConcreteCreatorCsv extends Creator {
	
	public Product fabrikmethode() throws IOException {

		return new ConcreteProductCsv();
	}

}
