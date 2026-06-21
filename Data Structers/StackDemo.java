import java.util.Stack;

public class StackDemo {
    /*
    What is a Stack in Java?
    A Stack is a data structure that stores elements in a Last In, First Out (LIFO) order.
    LIFO means: the last element added is the first element removed.
    Real-life example
    Think of a stack of plates:

    Plate C  ← Top (last added)
    Plate B
    Plate A  ← Bottom (first added)
    
    You put Plate C on top last.
    You remove Plate C first.
    */

public class Main {
    public static void main(String[] args) {
        Stack<String> books = new Stack<>();

        // Add elements
        books.push("Math");
        books.push("Physics");
        books.push("Java");

        System.out.println("Stack: " + books);

        // See the top element
        System.out.println("Top: " + books.peek());

        // Remove the top element
        books.pop();

        System.out.println("After pop: " + books);
    }
}
}
