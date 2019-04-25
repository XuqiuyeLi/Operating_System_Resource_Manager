// Functions for banker's

public class Banker {
	private static Map<Integer, Integer> resources;
	private static List<Queue<List<String>>> tasks;
	private static int cycle;

	Banker(Map<Integer, Integer> resourceMap, List<Queue<List<String>>> tasks){
		this.resources = resourceMap;
		this.tasks = tasks;
		this.cycle = 0;
	}
	/*
	 * If the task's initial claim exceeds the resource present or during execution, 
	 * a task's requests exceed its claims, print error message, abort the task, release all its resources
	 */
	public boolean errorCheck(List<String> task){
		String errorMessage = "Aborted";
	}

	public boolean isSafe(){

	}

	public static boolean initiate(){

	}
	public static boolean request(){
		
	}
	public static boolean release(){

	}
	public static boolean terminate(){

	}
	// return a string of Banker pass result
	public static String getResult(){
		StringBuilder sb = new StringBuilder();
		sb.append("       Banker       \n");

	}
}