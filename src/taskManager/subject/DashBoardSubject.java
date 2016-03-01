package taskManager.subject;
import java.util.HashMap;
import java.util.Map;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;
import taskManager.observers.PerformanceTab;
import taskManager.observers.PerformanceTabFilterImpl;
import taskManager.observers.ProcessesTab;
import taskManager.observers.ProcessesTabFilterImpl;
import taskManager.observers.UsersTab;
import taskManager.observers.UsersTabFilterImpl;
import taskManager.util.FileProcessor;
import taskManager.util.Logger;

public class DashBoardSubject implements Subject{
	Map<Observer,DashboardFilter> map;
	private String sendupdates;
	
	public DashBoardSubject(){
		Logger.getInstance().printToStdout(2, "DashBoardSubject constructor called");
		 map = new HashMap<Observer,DashboardFilter>();
	}

	public void notifyObservers() {
		Logger.getInstance().printToStdout(3, "notifyObservers");
		DashboardFilter user = new UsersTabFilterImpl();
		if(user.check(sendupdates)){
			Observer u = new UsersTab();
			u.update(sendupdates);
		}
		DashboardFilter processes = new ProcessesTabFilterImpl();
		if(processes.check(sendupdates)){
			Observer pr = new ProcessesTab();
			pr.update(sendupdates);
		}
		DashboardFilter performance = new PerformanceTabFilterImpl();
		if(performance.check(sendupdates)){
			Observer p = new PerformanceTab();
			p.update(sendupdates);
		}
		
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setupdates(String sendupdatesin) {
		Logger.getInstance().printToStdout(3, "setupdates method called");
		
		FileProcessor.writeToFile();
		System.out.println("---TAB(s) BEGIN---");
		sendupdatesin = sendupdatesin.toString().replaceAll("\\*", " ");
		String updates [] = sendupdatesin.toString().split(" ");
		for(String s : updates){
			this.sendupdates = s;
			measurementsChanged();
		}
		System.out.println("---TAB(s) END---");
		
		
	}


	public void registerObserver(Observer o, DashboardFilter f) {
		Logger.getInstance().printToStdout(3, "registerObserver method called ");
		map.put(o, f);
		
	}


	/*public void removeObserver(Observer o) {
		int i = map.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
		
	}*/



}
