import java.util.Map;
import java.util.Scanner;

public class Logic {
	private void addTask(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a Task: ");
		String userTask = scanner.nextLine().toLowerCase();

		if(userTask.isEmpty()){
			return;
		}
		if (userTask.length() >= 10){

			System.out.println("Task can't be >= 10 characters long");
			return;
		}
		Info.taskInfo.put(userTask, false);
	}

	private void markTask(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Pick a Task: ");

		viewTasks();

		String selectedItem = scanner.nextLine().toLowerCase();
		//Loops through the dic and finds the selected item
		//if not found returns it redo the func
		for(Map.Entry<String, Boolean> entry : Info.taskInfo.entrySet()) {
			if(entry.getKey().equals(selectedItem)){
				Info.taskInfo.put(selectedItem, true);
				return;
			}
			System.out.println("Enter a task from your task list");
		}
	}

	private void removeTask(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a task to remove: ");

		viewTasks();

		String selectedItem = scanner.nextLine().toLowerCase();

		for(Map.Entry<String, Boolean> entry : Info.taskInfo.entrySet()) {
			if (entry.getKey().equals(selectedItem)) {
				Info.taskInfo.remove(selectedItem, entry.getValue());
				return;
			}
			else{
				System.out.println("Enter a valid Task");
			}
		}
	}

	public void UserInput() {

		Scanner scanner = new Scanner(System.in);
		String Choice = scanner.nextLine().trim().toLowerCase();

		if (Choice.isEmpty()) {
			System.out.println("Choice can't be empty ");
			return;
		}

		//Checks Tasks, if empty Exits returns none else continues to the switch statement
		if (
				Choice.equals("mark task") ||
				Choice.equals("remove task") ||
				Choice.equals("view tasks")){
			if(Info.taskInfo.isEmpty()){
				System.out.println("Task lists is empty");
				return;
			}
		}
		switch (Choice){
			case "add task" -> addTask();
			case "mark task" -> markTask();
			case "remove task" -> removeTask();
			case "view tasks" -> viewTasks();
			case "quit" -> System.exit(1);
			default -> {
				clearConsole();
				System.out.println("Enter a valid choice");
			}
		}
	}

	public void viewTasks(){

		for(Map.Entry<String, Boolean> entry : Info.taskInfo.entrySet()){
			System.out.printf(
					"""
					___________________________________
					|  Task                | Completed |
					|----------------------|-----------|
					| %-20s | %-9b |
					|______________________|___________|
					""", entry.getKey(), entry.getValue()
			);

		}
	}

	public void clearConsole(){
		try {
			//checks if the os is windows
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			System.out.println("Could not clear console.");
		}
	}
}
