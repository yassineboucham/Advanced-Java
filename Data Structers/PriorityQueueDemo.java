import java.util.PriorityQueue;

public class PriorityQueueDemo {
/*
1. What is a PriorityQueue?

A PriorityQueue is a special type of queue where elements are ordered by their priority, not by the order they were added.

By default, Java's PriorityQueue stores elements in ascending order (smallest element has the highest priority).

Example

If we add:

5, 2, 8, 1

The queue organizes them like this:

Front (highest priority)
        ↓
        1, 2, 5, 8

When we remove elements, it removes:

1 → 2 → 5 → 8
Main PriorityQueue Operations
add() → Add an element to the queue.
peek() → Show the highest-priority element without removing it.
remove() or poll() → Remove the highest-priority element.
isEmpty() → Check if the queue is empty.    
*/


public class Main {
    public static void main(String[] args) {

        // Create a PriorityQueue of integers
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        // Add elements (order of insertion does not matter)
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);

        // Display the queue
        System.out.println("PriorityQueue: " + numbers);
        // The internal order may not look fully sorted

        // peek() shows the smallest element (highest priority)
        System.out.println("First element: " + numbers.peek());
        // Output: 1

        // remove() removes the highest-priority element
        System.out.println("Removed: " + numbers.remove());
        // Output: 1

        // Display after removing the first element
        System.out.println("After remove: " + numbers);

        // Check if the queue is empty
        System.out.println("Is empty? " + numbers.isEmpty());
        // Output: false
    }
}
}
