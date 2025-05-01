import java.util.Map;
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
					4-View Tasks
					5-Quit"""
			);
			Logic logic = new Logic();
			logic.UserInput();
		}
	}
}
