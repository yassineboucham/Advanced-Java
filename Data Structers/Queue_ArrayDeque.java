
import java.util.Queue;
import java.util.ArrayDeque;
public class Queue_ArrayDeque {
/*
1. Queue

A Queue is a data structure that follows the FIFO (First In, First Out) principle.

FIFO means: the first element added is the first element removed.

Real-life example

Think of a line of people waiting to buy tickets:

Front                          Rear
 ↓                              ↓
Ali  →  Sara  →  Yassine  →  Omar
 ^                               ^
First entered                    Last entered
First to leave                   Last to leave

2. ArrayDeque

ArrayDeque is a class in Java that can be used as a Queue or as a Stack.

It is usually faster than the old Stack class because it uses a resizable array.
*/

public class Main {
    public static void main(String[] args) {

        // Create a Queue using ArrayDeque
        Queue<String> students = new ArrayDeque<>();

        // add() inserts elements at the rear (end) of the queue
        students.add("Ali");
        students.add("Sara");
        students.add("Yassine");

        // Display the queue
        System.out.println("Queue: " + students);
        // Output: [Ali, Sara, Yassine]

        // peek() shows the front element without removing it
        System.out.println("First student: " + students.peek());
        // Output: Ali

        // remove() removes the front element
        System.out.println("Removed student: " + students.remove());
        // Output: Ali

        // Display the queue after removing the first element
        System.out.println("Queue after remove: " + students);
        // Output: [Sara, Yassine]

        // Check if the queue is empty
        System.out.println("Is queue empty? " + students.isEmpty());
        // Output: false
    }
}
}
