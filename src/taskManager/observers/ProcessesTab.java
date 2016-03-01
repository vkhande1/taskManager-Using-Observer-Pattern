package taskManager.observers;

import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.util.Logger;

public class ProcessesTab implements Observer, DisplayFile {
	String[] parts;
	List<String> list = new ArrayList<String>();;


	public void update(String updates) {
		Logger.getInstance().printToStdout(3, "ProcessesTab update method called");
		String data = updates.toString().replace(":", " ");
		data = data.toString().replace("-", " ");
		parts = data.toString().split(" ");
		for (String s : parts) {
			//s = String.format("%-8s", s);
			list.add(s);
		}
		list.remove(0);
		Display();
	}

	public void Display() {
		Logger.getInstance().printToStdout(3, "ProcessesTab Display method called");
		FileProcessor.writeToFile();
		//System.out.println("---TAB BEGIN---");
		System.out.println("---PROCESSES---");
		String PID = "PID";
		String COMMAND = "COMMAND";
		String USER = "USER";
		String CPU = "%CPU";
		String MEM = "%MEM";
		System.out.println(String.format("%5s", PID) +" "+ String.format("%-8s", COMMAND) + "        "+String.format("%-8s", USER) +" " +String.format("%-5s", CPU) + String.format("%-5s", MEM));
		for (int i = 0; i < list.size(); i++) {
			String first = list.get(i);
			String second = list.get(i + 1);
			String third =  list.get(i + 2);
			String fourth = list.get(i + 3);
			String fifth = list.get(i = i + 4);
			System.out.println(String.format("%5s", first) +" " + String.format("%-8s", second) + "        " + String.format("%-8s", third) +" "+ String.format("%4s", fourth) +  String.format("%5s", fifth));
					
					
					
					
		}
		System.out.println();
		//System.out.println("---TAB END---");

	}

}
