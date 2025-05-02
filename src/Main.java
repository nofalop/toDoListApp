import java.util.Map;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		while (true){
			System.out.println(
					"""
					============================
						   Todo List Menu
					============================
					1 - Add Task
					2 - Mark Task as Done
					3 - Remove Task
					4 - View Tasks
					5 - Quit
					============================
					Please choose an option:
					"""
			);

			Logic logic = new Logic();
			logic.UserInput();
		}
	}
}
