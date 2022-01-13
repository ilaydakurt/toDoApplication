import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.util.*;
import java.io.FileNotFoundException;  // Import this class to handle errors


public class ToDoList {
    private ArrayList<Task> taskList;

        
    /**
    * Default Constructor
    * This constructor reads the file named "toDoList.txt" and create old tasks again.
    */
    ToDoList() {
        taskList = new ArrayList<Task>();
        addOldTask();
    }
            
    /**
    * Remove the selected task from file
    * @param taskToRemove selected task
    */
    private void removeDataFromFile(String taskToRemove) {
        String oldTasks = readDataFromFile(); // read old data from file
        System.out.println(oldTasks.split(taskToRemove)[0] + "\n\n");
        // System.out.println(oldTasks.split(taskToRemove)[1].split("\n")[1]);
        String newTasks;
        if (oldTasks.split(taskToRemove)[1].split("\n").length>0){
        newTasks = oldTasks.split(taskToRemove)[0] + oldTasks.split(taskToRemove)[1].split("\n")[1]; // find and remove selected data from file
    } else {
        newTasks = oldTasks.split(taskToRemove)[0] + oldTasks.split(taskToRemove)[1];
        newTasks = newTasks.trim();
        }
        writeDataToFile(newTasks); // update file with new data
    }

    /**
    * Write given task to file
    * @param taskToWrite data that contains old tasks and selected task
    */
    private void writeDataToFile(String taskToWrite) {
        try {
            FileWriter toDoListFileWriter = new FileWriter("toDoList.txt"); // filewriter
            toDoListFileWriter.write(taskToWrite); // write to file 
            toDoListFileWriter.close();
        } catch (IOException e) {
            System.out.print("WRITING FILE ERROR: " + e); // print error if occures
        }
    }

    /**
    * Read tasks from file
    * @return toDoListData Data in file
    */
    private String readDataFromFile() {
        File toDoListFile = new File("toDoList.txt"); // file for reading
        String toDoListData = ""; // create empty string which is used to return data
        try {
            Scanner toDoListFileReader = new Scanner(toDoListFile); // read file
            while (toDoListFileReader.hasNextLine()) { // read by line
                String data = toDoListFileReader.nextLine();
                toDoListData = toDoListData + data + "\n"; // add line to toDoListData to return
            }
            toDoListFileReader.close();
        } catch (FileNotFoundException e) {
            System.out.print("READING FILE ERROR: " + e); // print error if occures
        }
        return toDoListData;
    }

    /**
    * Create tasks with old data in file at the beginning of program
    */
    private void addOldTask() {
        String toDoListData = readDataFromFile(); // read file
        // String newToDoListData = ""; // for changes of ids after program restart.

        // check file is empty or not. if not empty, create task with data in the file
        if (toDoListData != "") {
            String[] oldTasks = toDoListData.split("\n");
            String newToDoListData = "";
            for (String task : oldTasks) {
                int priority = Integer.valueOf(task.split("Priority=")[1].split(",")[0]); // get priority from string
                String explanation = task.split(", ")[2]; // get explanation from string
                Task oldTask = new Task(priority, explanation);
                taskList.add(oldTask); // create and add taskList
                newToDoListData = newToDoListData + oldTask.toString() + "\n";
            }
            writeDataToFile(newToDoListData); // to update ids rewrite data into file
        }
    }

    /**
    * Create task
    * @param newTask data of task to create
    */
    public void addTask(Task newTask) {
        taskList.add(newTask); // add new task to taskList
        System.out.println("Task added to the Todo List.");
        String toDoListData = readDataFromFile(); // read old tasks from file 
        writeDataToFile(toDoListData + newTask.toString()); // write new task over file
    }

    /**
    * Remove task
    * @param taskID id of task that will be deleted
    */

    public void removeTask(int taskID) {
        int check = 0; // controller of existence of task
        for (Task task : taskList) {
            if (task.getTaskID() == taskID) {
                check = 1;
                taskList.remove(task);
                removeDataFromFile(task.toString());
                System.out.println("Task with ID: " + taskID + " is removed.");
                break;
            }
        }
        // if task is not found, print error
        if (check ==0) {
            System.out.println("Task with ID: " + taskID + " is not found in the Todo List");
        }
    }

    /**
    * List tasks
    */
    public void listTasks() {
        System.out.println("\nThere are " + taskList.size() + " tasks in the Todo List:"); // count of tasks
        // print
        for (Task task : taskList) {
            System.out.println(task.toString());
        }
    }

    /**
    * Search tasks by keyword
    * @param keyword keyword used to search
    */
    public void search(String keyword) {
        System.out.println("Search results for the keyword: " + keyword);
        int counter = 0; // number of related tasks

        // print related tasks
        for (Task task : taskList) {
            if (task.toString().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task.toString());
                counter = counter + 1;
            }
        }
        System.out.println("Founds " + counter + " tasks in the Todo List");
    }
}
