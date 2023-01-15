package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import fabrikMethode.ConcreteCreatorCsv;
import fabrikMethode.ConcreteCreatorTxt;
import fabrikMethode.Creator;
import fabrikMethode.Product;
import observer.IsObservable;
import observer.IsObserver;


public class Model implements IsObservable {

	private ArrayList<Freizeitbad> freizeitbad = new ArrayList<Freizeitbad>();
	private static Model model = null;
	private Vector<IsObserver> observers = new Vector <>();
	private Model() {}
	
	public static Model getInstanz() {
		
		if (model == null) {
			model = new Model();
			
		}
		return model;
	}
	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator creator = new ConcreteCreatorCsv();
		Product writer = creator.fabrikmethode();
		
		for (Freizeitbad i : freizeitbad) {
			writer.fuegeInDateiHinzu(i);
		}
	
		writer.schliesseDatei();
	}

	public void schreibeFreizeitbaederInTxtDatei() throws IOException {
		Creator creator = new ConcreteCreatorTxt();
		Product writer = creator.fabrikmethode();
		
		for (int i = 0; i < freizeitbad.size(); i++) {
			writer.fuegeInDateiHinzu(this.freizeitbad.get(i));
		}
		
		writer.schliesseDatei();
		System.out.println(observers.size());
	}

	public ArrayList<Freizeitbad> getFreizeitbad() {
		return freizeitbad;
	}

	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad.add(freizeitbad);
		this.notifyObserver();
	}

	@Override
	public void addObserver(IsObserver obs) {
		this.observers.addElement(obs);
	}

	@Override
	public void removeObervable(IsObserver obs) {
		this.observers.remove(obs);
	}

	@Override
	public void notifyObserver() {
		for (IsObserver o :observers ) {
			o.update();
		}
	}
}
