package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.Logger;

public class ProcessesTabFilterImpl implements DashboardFilter{
	
	ProcessesTabFilterImpl filter;

	public ProcessesTabFilterImpl() {
		Logger.getInstance().printToStdout(2, "ProcessesTabFilterImpl constructor called");
		this.filter = this;
	}
	
	public ProcessesTabFilterImpl filter(){
		return filter;
	}

	public boolean check(String filterString) {
		Logger.getInstance().printToStdout(3, "ProcessesTabFilterImpl check method called");
		if (filterString.startsWith("Processes")){
			return true;	
		}
		else{	
			return false;
		}
	}

}
