package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.Logger;

public class PerformanceTabFilterImpl implements DashboardFilter {
	PerformanceTabFilterImpl filter;
			
	public PerformanceTabFilterImpl() {
		Logger.getInstance().printToStdout(2, "PerformanceTabFilterImpl constructor called");
		this.filter =this;
	}
	
	public PerformanceTabFilterImpl tostring(){
		return filter;
	}

	public boolean check(String filterString) {
		Logger.getInstance().printToStdout(3, "PerformanceTabFilterImpl check method called");
		if (filterString.startsWith("Performance"))
		{
			return true;
		}
		else{
			return false;
		}
		
	}

}



