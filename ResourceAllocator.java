/* 
 * The goal of this program is to do resource allocation using both an optimistic resource manager 
 * and the banker's algorithm of Dijistra. 
 *
 */

import java.io.*;
import java.util.*;

public class ResourceAllocator {
	private static List<Queue<List<String>>> tasks = new ArrayList<Queue<List<String>>>();
	private static Map<Integer, Integer> resources = new HashMap<Integer, Integer>();


	private static void sortInput(Scanner input){
		/*-------- first line of input -----------*/
		// 1st int is how many tasks
		// 2nd int is how many resources
		int totalTasks = input.nextInt();
		int totalResources = input.nextInt();
		System.out.println("tasks: " + totalTasks);
		System.out.println("resources: " + totalResources);
		// get the resources into the hashmap
		for(int i = 1; i <= totalResources; i++){
			resources.put(i, input.nextInt());
		}
		/*-------- prepare empty queues for all the tasks -----------*/
		for(int j = 0; j <= totalTasks; j++){
			Queue<List<String>> cur = new LinkedList<List<String>>();
			tasks.add(cur);
		}
		/*
	 	 * pre-processing the task string to map to each task
	 	 * current format is like : "request task-number delay resource-type number-requested"
	 	 * after processing, 
	 	 * each task queue will be: "request delay resource-type number-requested" format
	 	 */
		while(input.hasNext()){
			List<String> current = new ArrayList<String>();
			current.add(input.next());
			int taskNumber = input.nextInt();
			// add "delay", "resource-type", "number-requested" to the list
			for(int k = 0; k < 3; k++){
				current.add(input.next());
			}
			// add the processed task string to the according task queue
			tasks.get(taskNumber).offer(current);
		}
		// done processing the input file
		input.close();
	}



	// read the input file of commandline, and sort the inputs by tasks
	private static Scanner readFile(){
		try{
			System.out.println("Enter the input file name: ");
			Scanner scanner = new Scanner(System.in);
			String filename = scanner.nextLine();
			Scanner input = new Scanner(new BufferedReader(new FileReader(filename)));
			System.out.println("Done reading file!");
			return input;
		}
		catch(Exception ex) {
			System.out.println("Error reading file!");
			System.exit(0);
		}
		return null;
	}

	private static void printQueue(){
		for(int i = 1; i < tasks.size(); i++){
			System.out.println("Task" + i + " : ");
			Queue<List<String>> curQueue = tasks.get(i);
			while(!curQueue.isEmpty()){
				List<String> cur = curQueue.poll();
				for(String x: cur){
					System.out.print(x + " ");
				}
				System.out.println();
			}
		}
	}

	// Driver method
	public static void main(String[] args) {
		Scanner input = readFile();
		sortInput(input);
		printQueue();
	}

}