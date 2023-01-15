package observer;

public interface IsObservable {

	public void addObserver(IsObserver obs);
	public void removeObervable(IsObserver obs);
	public void notifyObserver();
}
