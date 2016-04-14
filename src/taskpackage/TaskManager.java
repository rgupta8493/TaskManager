package taskpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		String choiceText= "";
		int choice = 0;
		do{
			menuOptions();
			choiceText = readTask();
		try {
			choice =Integer.parseInt(choiceText);
			if(choice == 1)
			{
				addTask();
			}
			else if(choice == 2)
			{
				listTask();
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
		
		System.out.println("Please enter your choice");
		System.out.println("1. Add new task");
		System.out.println("2. List tasks");
		
	}
	
	static void addTask()
	{
		
		System.out.println("Add task description or enter 0 to exit");
		String text = readTask();
		if(text.equals("0"))
		{
			menu();
		}
		else
		{
			Task t = new Task(idCounter, text);
			idCounter++;
			taskList.add(t);
			System.out.println("New task added with id:" + taskList.size());
			screenSeparator();
			addTask();
		}
		
	}
	
	static void listTask()
	{
		System.out.println("ToDo List");
		for (int i = 0; i < taskList.size(); i++)
		{
			System.out.println(i + 1 + "." + " " + taskList.get(i).getDescription() + "\n");
		}
		
		String choice = readTask();
		try
		{
			int selected = Integer.parseInt(choice);	
			selected--;
			while(selected < 0 || selected > taskList.size())
			{
				System.out.println("Not an valid id");
				selected = Integer.parseInt(choice);
			}
			
			taskList.remove(selected);
			System.out.println("Task removed");
			
		}
		
		catch(Exception e)
		{
			System.out.println("Not a valid number");
		}
		
	}

	

	static void screenSeparator(){
		System.out.println("--------------------------------------------------------------");
	}
	
	static String readTask()
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String text = null;
	      try {
	    	  text = br.readLine();
	      } catch (IOException ioe) {
	         System.out.println("Error reading input");
	         
	      }
	      
	      return text;
	}
	
	
}
