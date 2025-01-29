class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    Task head;

    public TaskScheduler() {
        head = null;
    }

    // Add a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;  // Circular nature: next of head points to itself
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;  // Circular nature: new task points back to head
            head = newTask;
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;  // Circular nature: next of head points to itself
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;  // Circular nature: new task points back to head
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position == 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 0;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
            if (temp == head) break;  // Avoid infinite loop if position is invalid
        }

        if (temp == null || temp.next == head) {
            System.out.println("Position out of bounds");
            return;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove a task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        Task prev = null;
        while (temp != null && temp.taskId != taskId) {
            prev = temp;
            temp = temp.next;
            if (temp == head) break;  // Avoid infinite loop if task not found
        }

        if (temp == null || temp == head && prev == null) {
            System.out.println("Task not found.");
            return;
        }

        // If the task to be deleted is the head node
        if (temp == head) {
            prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            head = head.next;
            prev.next = head;
        } else {
            prev.next = temp.next;
        }
        temp = null;  // Deallocate the task
    }

    // View the current task and move to the next task in the circular list
    public Task viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return null;
        }
        return head;
    }

    // Display all tasks in the list starting from the head node
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public Task searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return null;
        }

        Task temp = head;
        do {
            if (temp.priority == priority) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found with the given priority.");
        return null;
    }
}

public class TestTaskScheduler {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks to the scheduler
        scheduler.addAtEnd(1, "Task 1", 5, "2025-02-10");
        scheduler.addAtEnd(2, "Task 2", 3, "2025-02-15");
        scheduler.addAtEnd(3, "Task 3", 1, "2025-02-20");

        // Display all tasks
        System.out.println("All tasks in the scheduler:");
        scheduler.displayTasks();

        // Add a task at the beginning
        scheduler.addAtBeginning(0, "Task 0", 4, "2025-02-05");
        System.out.println("\nAfter adding Task 0 at the beginning:");
        scheduler.displayTasks();

        // Add a task at position 2
        scheduler.addAtPosition(2, 4, "Task 4", 2, "2025-02-25");
        System.out.println("\nAfter adding Task 4 at position 2:");
        scheduler.displayTasks();

        // View the current task
        Task currentTask = scheduler.viewCurrentTask();
        if (currentTask != null) {
            System.out.println("\nCurrent Task: " + currentTask.taskName);
        }

        // Search for a task by Priority
        Task foundTask = scheduler.searchByPriority(2);
        if (foundTask != null) {
            System.out.println("\nTask with priority 2: " + foundTask.taskName);
        }

        // Remove a task by Task ID
        scheduler.removeByTaskId(2);
        System.out.println("\nAfter removing Task 2:");
        scheduler.displayTasks();

        // Display all tasks again
        System.out.println("\nFinal list of tasks:");
        scheduler.displayTasks();
    }
}
