package taskManager.util;


public class Logger {
	private int debugLevel;

	public void setDebug(int level){
		debugLevel = level;
	}


	public int getDebug(){
		return debugLevel;
	}

	private volatile static Logger uniqueInstance;

	private Logger(){
	}

	public static Logger getInstance(){
		if (uniqueInstance == null){
			synchronized (Logger.class) {
				if(uniqueInstance == null){
					uniqueInstance = new Logger();
				}
			}
		}
		return uniqueInstance;
	}

	public void printToStdout(int level,String debugMessage)
	{
		
		if(level == 0){

		}
		else if(debugLevel == level){
			FileProcessor.writeTolog();
			System.out.println(debugMessage);
		}
		else {

		}
	}
}
