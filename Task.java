public class Task{
	ArrayList<String> processed; // resouce already allocated
	Queue<String> remaining; // to be processed
	int id; 
	int terminateTime; // the total cycle when this task terminates
	int blocked; // number of blocked tasks
	boolean aborted; // if this task is aborted or not

	public Task(int i, Queue<String> tasks){
		processed = new ArrayList<String>();
		remaining = tasks;
		id = i;
        aborted = false;
        blocked = 0;
        terminateTime = 0;
    }

    public boolean hasNext(){
    	while(!remaining.isEmpty()){
    		return true;
    	}
    	return false;
    }
    public String getNext(){
    	String next = remaining.poll();
    	processed.add(next);
    	return next;
    }
    // check if current task is aborted already
    public boolean isAborted(){
        if(aborted == true) return true;
        else return false;
    }
    // terminate current task and set terminate time
    public void terminateTask(int time){
        terminateTime = time;
    }

    public void abortTask(){
        //finish
        aborted = true;
        blocked= 0;
        //System.out.println("Banker aborts task(s) "+id+" before run begins: claim for resource");
    }
    public void printResult(){
    	if(aborted){
    		System.out.println("Task " + id + "      " + "Aborted");
    	}
    	else{
    		int percentage = (blocked / terminateTime) * 100;
    		System.out.println("Task " + id + "      " + terminateTime + "   " + blocked + "   " + percentage + "%");
    	}
    }
}