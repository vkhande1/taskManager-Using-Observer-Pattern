package taskManager.subject;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;

public interface Subject {
	
	public void registerObserver(Observer o, DashboardFilter f);
	//public void removeObserver(Observer o);
	public void notifyObservers();

}
