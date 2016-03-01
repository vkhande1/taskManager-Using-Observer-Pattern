package taskManager.observers;

import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.util.Logger;

public class UsersTab implements Observer, DisplayFile {
	String[] body;
	List<String> list = new ArrayList<String>();;
	String[] parts;

	public void update(String updates) {
		Logger.getInstance().printToStdout(3, "UsersTab update method called");
		String data = updates.toString().replace(":", " ");
		data = data.toString().replace("-", " ");
		parts = data.toString().split(" ");

		for (String s : parts) {
			list.add(s);
		}
		list.remove(0);
		Display();
	}

	public void Display() {
		Logger.getInstance().printToStdout(3, "UsersTab Display method called");
		FileProcessor.writeToFile();
		//System.out.println("---TAB BEGIN---");
		System.out.println("---USERS---");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("User:" + " " + list.get(i) + "  " + "Status:"
					+ " " + list.get(i = i + 1));
		}
		System.out.println();
		//System.out.println("---TAB END---");
	}

}
