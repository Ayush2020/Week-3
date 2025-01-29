
class TextState {
    String content; // The text content at a given state
    TextState prev, next; // Doubly linked list pointers

    // Constructor to create a new state with content
    TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}
class TextEditor {
    private TextState currentState;
    private int historySize;
    private int historyCount;
    private TextState head, tail;

    // Constructor to initialize the text editor with a specific history size
    public TextEditor(int historySize) {
        this.historySize = historySize;
        this.historyCount = 0;
        this.currentState = null;
        this.head = this.tail = null;
    }

    // Add a new text state at the end
    public void addState(String content) {
        TextState newState = new TextState(content);

        // If history size exceeds limit, remove the oldest state (head)
        if (historyCount == historySize) {
            head = head.next; // Move head to the next state
            if (head != null) {
                head.prev = null;
            }
        } else {
            historyCount++;
        }

        // Link the new state
        if (tail == null) {
            head = tail = newState; // First state
        } else {
            tail.next = newState; // Link previous state to new one
            newState.prev = tail; // Link new state to previous one
            tail = newState; // Move tail to the new state
        }

        currentState = tail; // Set the current state to the most recent
    }

    // Undo: Move to the previous state
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo to: " + currentState.content);
        } else {
            System.out.println("No more undo operations available.");
        }
    }

    // Redo: Move to the next state
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo to: " + currentState.content);
        } else {
            System.out.println("No more redo operations available.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current text: " + currentState.content);
        } else {
            System.out.println("No content available.");
        }
    }
}

public class UndoRedoController {
    public static void main(String[] args) {
        // Initialize text editor with a history limit of 5 states
        TextEditor editor = new TextEditor(5);

        // Simulating user actions
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.addState("Hello, World!!");
        editor.addState("Hello, World!!!");

        // Display current state
        editor.displayCurrentState(); // "Hello, World!!!"

        // Perform undo operations
        editor.undo(); // "Hello, World!!"
        editor.undo(); // "Hello, World!"

        // Perform redo operations
        editor.redo(); // "Hello, World!!"
        editor.redo(); // "Hello, World!!!"

        // Adding more states, exceeding the limit
        editor.addState("Hello, Universe!");
        editor.addState("Hello, Universe!!!");

        // Display current state (last state after adding new ones)
        editor.displayCurrentState(); // "Hello, Universe!!!"

        // Performing undo after exceeding limit
        editor.undo(); // "Hello, Universe!"
        editor.undo(); // "Hello, World!!!"
        editor.undo(); // "Hello, World!!"
        editor.undo(); // "Hello, World!"
    }
}

