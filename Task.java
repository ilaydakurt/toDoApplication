
public class Task {
    private static int taskCounter;
    private int taskID;
    private int priority;
    private String explanation;

    // default constructor
    Task() {
    }

    
    /**
    * Second Constructor
    * @param priority priority of the object that will be created
    * @param explanation explanation of the object that will be created
    */

    Task(int priority, String explanation) {
        setter(priority, explanation);
        taskCounter = taskCounter + 1; // calculate the number of tasks
        this.taskID = taskCounter + 99; // task ids start with 100, to calculate it, add number of tasks to 100. 
    }

    /**
    * Set the fields of objects.
    * @param priority priority of the object that will be created
    * @param explanation explanation of the object that will be created
    */
    public void setter(int priority, String explanation) {

        // check the priority is appropriate or not
        if (priority == 1 || priority == 2 || priority == 3) {
            this.priority = priority;
        } else {
            System.out.println("Priority should be 1, 2 or 3");
        }
        this.explanation = explanation;
    }
    
    /**
    * Get task id of object
    * @return taskID
    */
    public int getTaskID() {
        return taskID;
    }
        
    /**
    * Return task information in string format
    * @return infoString
    */
    public String toString() {
        String infoString = "Task ID=" + taskID + ", Priority=" + priority + ", " + explanation;
        return infoString;
    }

}