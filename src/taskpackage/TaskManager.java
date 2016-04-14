package taskpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	
	static List<Task> taskList;
	static int idCounter = 1;
	public static void main (String[] args)
	{
	    taskList = new ArrayList<Task>();
	    menu();
	}
	
	static void menu()
	{
		
		int choice = 0;
		do{
			menuOptions();
		try {
			choice =Integer.parseInt(System.console().readLine());
			if(choice == 1)
			{
				addTask();
			}
			else if(choice == 2)
			{
				
			}
			else
			{
				System.out.println("Option does not exist");
			}
				
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
		}
		
		}
		while(choice != 1 || choice != 2);
		
	}
	
	static void menuOptions()
	{
		System.console().flush();
		System.out.println("Please enter your choice");
		System.out.println("1. Add new task");
		System.out.print("2. List tasks");
		
	}
	
	static void addTask()
	{
		System.console().flush();
		System.out.println("Add task description or enter 0 to exit");
		String text = System.console().readLine();
		if(text.equals("0"))
		{
			menu();
		}
		else
		{
			Task t = new Task(idCounter, text);
			idCounter++;
			taskList.add(t);
			addTask();
		}
		
	}

	

}
