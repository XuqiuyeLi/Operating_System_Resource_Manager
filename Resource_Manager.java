public class Optimistic_Manager{
	private static Map<Integer, Integer> resources;
	private static List<Queue<List<String>>> tasks;
	private static Queue<List<String>> waitingRequests;
	private static int cycle; // to keep track of total time cycles
	private static int[] waitingTimes; // to keep track of each task's waiting time

	Resource_Manager(List<Queue<List<String>>> tasks, Map<Integer, Integer> resources){
		this.resources = resourceMap;
		this.tasks = tasks;
		this.cycle = 0;
		this.waitingRequests = new Queue<List<String>>();
		this.waitingTimes = new int[tasks.size()];
	}

	// Optimistic Manager does not check initial claim
	public static void initiate(){
		for(int i = 1; i <= this.tasks.size(); i++){
			// process the initate command from each task, do nothing with initial claims
			this.tasks.get(i).poll();
		}
		this.cycle++;
	}

	/* Request a number of resourcs from the available resources,
	 * If available, granted, else push to the waitingRequest queue
	 */
	public static void request(int task, int resource, int number_requested){

		this.cycle++;
	}

	/* Release resources occupied from a task
	 * Try to satify pending requests from watingRequest queue
	 */
	public static void release(int task, int resource, int number_released){
		this.cycle++;
	}

	// terminate a task queue
	public static void terminate(int task){

	}

	/*
	 * Put the total available resources into a HashMap
	 */
	public static void detectDeadlock(){
		
	}


	public static void getResult(){
		this.initate();
		for(int i = 1; i <= this.tasks.size(); i++){
			// process first task of each Task Queue after initial claims
			List<String> curTask = this.tasks.get(i).poll();
			switch (curTask.get(0)){
				case "request":
					this.request(i, curTask.get(1), curTask.get(2));
					break;
				case "release":
					this.release(i, curTask.get(1), curTask.get(2));
					break;
				case "terminate":
					this.terminate(i);
					break;
			}
		}
	}
}