import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		while (true){
			System.out.println(
					"""
					TodoList
					1-Add Task
					2-mark Task
					3-Remove Task
					4-Quit"""
			);
			UserInput();
		}
	}

	private static void UserInput(){
		Scanner scanner = new Scanner(System.in);
		String Choice = scanner.nextLine().trim().toLowerCase();
		if(Choice.isEmpty()){
			System.out.println("Choice can't be empty ");
			return;
		}
		switch (Choice){
			case "add task" -> System.out.println("add task");
			case "mark task" -> System.out.println("mark Task");
			case "remove task" -> System.out.println("remove task");
			case "quit" -> System.exit(1);
			default -> System.out.println("Enter a valid choice");
		}
	}
}
