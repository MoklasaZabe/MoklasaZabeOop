package fabrikMethode;

import java.io.IOException;

public class ConcreteCreatorTxt extends Creator {

	@Override
	public Product fabrikmethode() throws IOException {
		
		return new ConcreteProductTxt();
	}

}
