package taskManager.driver;

import java.io.File;
import java.io.FileNotFoundException;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;
import taskManager.observers.PerformanceTab;
import taskManager.observers.PerformanceTabFilterImpl;
import taskManager.observers.ProcessesTab;
import taskManager.observers.ProcessesTabFilterImpl;
import taskManager.observers.UsersTab;
import taskManager.observers.UsersTabFilterImpl;
import taskManager.subject.DashBoardSubject;
import taskManager.subject.Subject;
import taskManager.util.FileProcessor;
import taskManager.util.Logger;

public class Driver {

	static String filename;

	public static void main(String[] args) {
		Subject subject = new DashBoardSubject();
		DashboardFilter f1 = new PerformanceTabFilterImpl();
		DashboardFilter f2 = new UsersTabFilterImpl();
		DashboardFilter f3 = new ProcessesTabFilterImpl();
		Observer o1 = new PerformanceTab();
		subject.registerObserver(o1,f1);
		Observer o2 = new UsersTab();
		subject.registerObserver(o2,f2);
		Observer o3 = new ProcessesTab();
		subject.registerObserver(o3,f3);


	if (args.length > 2) {
				File file = new File(args[0]);
				String outputfile = args[1];
				
				try {
					FileProcessor.readfromFile(file,outputfile);
					Logger.getInstance().setDebug(Integer.parseUnsignedInt(args[2]));
					
				} catch (FileNotFoundException e) {
					System.err.println("File not found");
					System.exit(1);
				} catch (NumberFormatException e){
					System.err.println("Please provide the positive integer value as your Debug value");
				}
			} else {
				System.err.println("Invalid arguments count: " + args.length + "Please put the correct arguments names, inputFile, outputFile, debug value");
				System.exit(1);
			}
		
		
		
		
	}
}
