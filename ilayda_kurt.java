/**
* This is to do list application contains adding new task, removing existing task, listing tasks and searching tasks by keyword.
* @author Ilayda Kurt, Student ID: 2021719099
* @since Date: 07.01.2022
*/

import java.util.*;

class ilayda_kurt {

    public static void main(String[] args) {


        ToDoList toDoList = new ToDoList(); // our to do list 
        System.out.print(
                "ToDo List Operations:\n1: List tasks.\n2: Add a new task.\n3: Delete a task.\n4: Search tasks.\n0: Exit.\nPlease enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(); // the operation preference she wants to do on the to do list
        
        // to do list application actions below.
        while (number != 0) { // it continues until preference is 0.
            
            // list all todos  with the method "listTasks" of ToDoList Class.
            if (number == 1) {
                toDoList.listTasks();
            }

            // add new task with the method "addTask" of ToDoList Class.
            else if (number == 2) {
                System.out.println("\nAdd a new task:");
                System.out.println("Enter task priority (1: Low, 2: Medium, 3:High):");
                int priority = sc.nextInt(); // get priority of new task
                System.out.println("Enter task description: ");
                Scanner string = new Scanner(System.in); // new scanner for a line string
                String explanation = string.nextLine(); // get explanation for new task
                toDoList.addTask(new Task(priority, explanation));
                
            }

            // delete selected task with the method "removeTask" of ToDoList Class.
            else if (number == 3) {
                System.out.println("\nDelete a task:");
                System.out.print("Enter a Task ID to be deleted: ");
                int taskID = sc.nextInt(); // get taskID to remove
                toDoList.removeTask(taskID);
            }

            // search by keyword with the method "search" of ToDoList Class.
            else if (number == 4) {
                System.out.print("\nEnter the search keyword: ");
                Scanner string = new Scanner(System.in); // new scanner for a line string
                String keyword = string.nextLine(); // get keyword to search
                toDoList.search(keyword);
            }
            else if (number != 1 && number != 2 && number != 3 && number != 4 && number != 0) {
                System.out.print("Invalid choice.");
            }
            System.out.print(
                    "\n\n\nToDo List Operations:\n1: List tasks.\n2: Add a new task.\n3: Delete a task.\n4: Search tasks.\n0: Exit.\nPlease enter your choice: ");
            number = sc.nextInt();

        }
        System.out.println("\nBye.");

    }
}
