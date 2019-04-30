public class Resource_Manager{
	private Map<Integer, Integer> resources;
	private List<Task> tasks;
	private Queue<List<String>> waitingRequests;
	private int cycle; // to keep track of total time cycles
	private int[] waitingTimes; // to keep track of each task's waiting time

	Resource_Manager(Map<Integer, Integer> resourceMap, List<Task> tasks){
		resources = resourceMap;
		tasks = tasks;
		cycle = 0;
		waitingRequests = new Queue<List<String>>();
		waitingTimes = new int[tasks.size()];
	}

	// Optimistic Manager does not check initial claim
	public void initiate(){
		for(int i = 1; i <= tasks.size(); i++){
			// process the initate command from each task, do nothing with initial claims
			tasks.get(i).poll();
		}
		cycle++;
	}

	/* Request a number of resourcs from the available resources,
	 * If available, granted, else push to the waitingRequest queue
	 */
	public void request(int task, int resource, int number_requested){

		this.cycle++;
	}

	/* Release resources occupied from a task
	 * Try to satify pending requests from watingRequest queue
	 */
	public void release(int task, int resource, int number_released){
		this.cycle++;
	}

	// terminate a task queue
	public void terminate(int task){

	}

	/*
	 * check for deadlock danger in the previous cycle
	 */
	public void detectDeadlock(Queue<Task> blockQueue){
		for(int i = 0; i < tasks.size(); i++){
			/*check unfinished or aborted tasks*/
            if(!tasks.get(i).isFinished() && !tasks.get(i).isAborted()){
                // from the minimun task number, abort task
                tasks.get(i).abortTask();
                // release all the resources allocated from this task 
                for(int j = 0; j < allocated[i].length; j++){
                	int available = resources.get(j + 1) + allocated[i][j];
                	resources.put(j + 1, available);
                }
                // remove the aborted task
                blockQueue.remove(tasks[i]);
                // check again, if is not deadlock then stop aborting
                if(!isDeadlock()){
                    isDanger = false;
                    break;
                }
            }
            /*finish check unfinished or aborted tasks*/
        }
	}

	/*
	 * check for the current situation is deadlock or not
	 */
	public void isDeadlock(){
        for(int i = 0; i < tasks.size() ;i++){
            //only check unfinished or unaborted
            if(!tasks.get(i).isFinished() && !tasks.get(i).isAborted()){
                List<String> curActivity = task.get(i).getNext();
                int requestResource = curActivity.get(2);
                int numReq = curActivity.get(3);
                //if one task can be allocated then of course no deadlock
                if(resources.get(requestResource) >= numReq){
                    return false;
                }
            }
        }
        //if all tasks cannot be allocated
        return true;
	}

	public void print(){

	}

	public void getResult(){
		initate();
		for(int i = 1; i <= tasks.size(); i++){
			// check for deadlock in previous cycle
			if(detectDeadlock){
				// abort last task
			}

			// check blocked task first
			while(!waitingRequests.isEmpty()){

			}

			// process not-blocked first task of each Task Queue after initial claims
			List<String> curTask = tasks.get(i).poll();
			switch (curTask.get(0)){
				case "request":
					request(i, curTask.get(1), curTask.get(2));
					break;
				case "release":
					release(i, curTask.get(1), curTask.get(2));
					break;
				case "terminate":
					terminate(i);
					break;
			}
		}
		print();
	}
}