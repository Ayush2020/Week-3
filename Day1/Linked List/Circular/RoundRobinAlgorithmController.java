
class Process {
    int processID;
    int burstTime;
    int remainingBurstTime;
    int priority;
    Process next;  // Points to the next process in the circular list

    // Constructor to create a new process
    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime;  // Initially, remaining burst time equals the burst time
        this.priority = priority;
        this.next = null;
    }
}
class RoundRobinScheduler {
    private Process head;
    private int totalWaitingTime;
    private int totalTurnAroundTime;
    private int processCount;

    // Constructor to initialize the process queue
    public RoundRobinScheduler() {
        head = null;
        totalWaitingTime = 0;
        totalTurnAroundTime = 0;
        processCount = 0;
    }

    // Add a new process to the end of the circular list
    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;  // Circular reference
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
        processCount++;
    }

    // Remove a process by Process ID after its execution
    public void removeProcessByID(int processID) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }

        Process temp = head;
        Process prev = null;

        // If the process to be removed is the head node
        if (temp.processID == processID) {
            if (temp.next == head) {  // Only one process in the list
                head = null;
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
            processCount--;
            System.out.println("Process with ID " + processID + " removed.");
            return;
        }

        // Traverse the circular list and find the process by Process ID
        prev = temp;
        temp = temp.next;
        while (temp != head) {
            if (temp.processID == processID) {
                prev.next = temp.next;
                processCount--;
                System.out.println("Process with ID " + processID + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Process with ID " + processID + " not found.");
    }

    // Simulate the Round Robin Scheduling of processes
    public void scheduleProcesses(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalBurstTime = 0;
        Process temp = head;

        // Calculate total burst time
        do {
            totalBurstTime += temp.burstTime;
            temp = temp.next;
        } while (temp != head);

        int timeElapsed = 0;

        while (processCount > 0) {
            temp = head;
            boolean executed = false;

            // Traverse the circular list to simulate the execution of each process
            do {
                if (temp.remainingBurstTime > 0) {
                    // Execute process for the time quantum or the remaining burst time
                    int execTime = Math.min(timeQuantum, temp.remainingBurstTime);
                    temp.remainingBurstTime -= execTime;
                    timeElapsed += execTime;

                    // Calculate waiting time and turn-around time
                    if (temp.remainingBurstTime == 0) {
                        int turnAroundTime = timeElapsed;
                        int waitingTime = turnAroundTime - temp.burstTime;
                        totalTurnAroundTime += turnAroundTime;
                        totalWaitingTime += waitingTime;
                        removeProcessByID(temp.processID);
                    }
                    executed = true;
                }
                temp = temp.next;
            } while (temp != head && executed);
        }

        // Calculate and display average waiting and turn-around times
        if (processCount > 0) {
            double avgWaitingTime = (double) totalWaitingTime / processCount;
            double avgTurnAroundTime = (double) totalTurnAroundTime / processCount;
            System.out.println("Average Waiting Time: " + avgWaitingTime);
            System.out.println("Average Turnaround Time: " + avgTurnAroundTime);
        }
    }

    // Display the list of processes in the circular queue
    public void displayProcessList() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime +
                    ", Remaining Burst Time: " + temp.remainingBurstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);  // Loop until we come back to the head
    }
}
public class RoundRobinAlgorithmController {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes to the scheduler
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 12, 4);

        // Display processes before scheduling
        System.out.println("Process List Before Scheduling:");
        scheduler.displayProcessList();

        // Simulate the Round Robin Scheduling with a time quantum of 4
        System.out.println("\nScheduling Processes (Time Quantum = 4):");
        scheduler.scheduleProcesses(4);

        // Display the remaining processes (if any) after scheduling
        System.out.println("\nProcess List After Scheduling:");
        scheduler.displayProcessList();
    }
}