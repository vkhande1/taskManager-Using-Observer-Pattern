package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.Logger;

public class UsersTabFilterImpl implements DashboardFilter{
	
	UsersTabFilterImpl filter;

	public UsersTabFilterImpl() {
		Logger.getInstance().printToStdout(2, "UsersTabFilterImpl constructor called");
		this.filter =this;
	}

	public UsersTabFilterImpl tostring(){
		return filter;
	}
	
	public boolean check(String filterString) {
		Logger.getInstance().printToStdout(3, "UsersTabFilterImpl check method called");
		if (filterString.startsWith("Users")){
			
		return true;
		} else{
			return false;
		}
	}

}
