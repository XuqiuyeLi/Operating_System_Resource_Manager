public class Optimistic_Manager{
	private static Map<Integer, Integer> resources;
	private static List<Queue<List<String>>> tasks;
	private static Queue<List<String>> waitingRequests;
	private static int cycle;

	Resource_Manager(List<Queue<List<String>>> tasks, Map<Integer, Integer> resources){
		this.resources = resourceMap;
		this.tasks = tasks;
		this.cycle = 0;
		this.waitingRequests = new Queue<List<String>>();
	}

	// Optimistic Manager does not check initial claim
	public static boolean initiate(){
		for(int i = 1; i <= tasks.size(); i++){
			// process the initate command from each task
			tasks.get(i).poll();
		}
		cycle++;
	}
	public static boolean request(){
		
	}
	public static boolean release(){

	}
	public static boolean terminate(){

	}

	/*
	 * Put the total available resources into a HashMap
	 */
	public static void detectDeadlock(){
	}


	public static void getResult(){
	}
}