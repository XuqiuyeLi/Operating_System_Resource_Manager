public class Resource_Manager{
	int cycle;
	private static Map<Integer, Integer> resources;
	private static String[] tasks;
	private static Queue<String> pendingTasks;

	/*
	 * Put the total available resources into a HashMap
	 */
	Resource_Manager(int num_of_tasks, int num_of_resources, int[] resources, String taskString){
		// initialize cycle, resources, and tasks
		int cycle = 0;
		tasks = new String[num_of_tasks];
		resources = new HashMap<Integer, Integer>();
		pendingTasks = new LinkedList<String>();

		// fill the tasks array and resources map from the input file
		tasks = taskString.split("\n");
		for(int i = 1; i <= num_of_resources; i++){
			resources.put(i, resources[i - 1]);
		}
	}

	public static boolean initiate(){

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
}