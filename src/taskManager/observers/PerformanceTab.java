package taskManager.observers;

import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.util.Logger;

public class PerformanceTab implements Observer, DisplayFile {
	String[] body;
	String[] splited;
	List<String> list = new ArrayList<String>();

	
	public void update(String updates) {
		Logger.getInstance().printToStdout(3, "PerformanceTab update method called");
		splited = updates.toString().split(":");

		for (String s : splited) {
			list.add(s);
		}
		list.remove(0);
		// list.remove(1);
		
		Display();

	}

	public void Display() {
		Logger.getInstance().printToStdout(3, "PerformanceTab Display method called");
		FileProcessor.writeToFile();
		// System.out.println("---TAB END---");
		//System.out.println("---TAB BEGIN---");
		System.out.println("---PERFORMANCE---");
		System.out.println("Memory Total:" + " " + list.get(0) + "  "
				+ "Memory Used:" + " " + list.get(1) + "  " + "Memory  Free:"
				+ " " + list.get(2) + "  " + "Memory  Cached:" + " "
				+ list.get(3));
		System.out.println("CPU Idle:" + " " + list.get(4) + "  "
				+ "CPU User Level:" + " " + list.get(5) + "  "
				+ "CPU System Level:" + " " + list.get(6));
				System.out.println("");
		// System.out.println("---TAB END---");

	}

}
