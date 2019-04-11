// Functions for banker's

public class Banker(){
	private static Map<Integer, Integer> resources;
	String request;

	Banker(Map<Integer, Integer> resourceMap, String request){
		this.resources = resourceMap;
		this.request = request;
	}
	/*
	 * If the task's initial claim exceeds the resource present 
	 * or during execution, a task's requests exceed its claims
	 */
	public boolean errorCheck(){

	}
	public boolean isSafe(){

	}
}