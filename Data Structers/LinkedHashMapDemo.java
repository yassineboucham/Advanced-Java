import java.util.LinkedHashMap;

/*
    1. What is a LinkedHashMap?

A LinkedHashMap is a class in Java that stores data as key-value pairs like HashMap, but it also maintains the order of insertion.

It combines:

Hash table → for fast searching (get(), put()).
Doubly linked list → to remember the order of elements.
2. LinkedHashMap Architecture
A. Hash Table (Buckets)

The first part is the same as HashMap:

Array of Buckets

Index:   0        1        2        3
         |        |        |        |
       null    [Ali]   [Sara]    [Yassine]

Each bucket stores a Node containing:

hash
key
value
next (for collisions)
B. Doubly Linked List (Insertion Order)

All nodes are also connected using two extra pointers:

Head                                       Tail
 |                                           |
 ↓                                           ↓
[Ali] ⇄ [Sara] ⇄ [Yassine]

Each node contains:

+------------------------------------------------+
| hash | key | value | next | before | after |
+------------------------------------------------+
next → links nodes inside the same bucket (collision handling).
before → points to the previous inserted element.
after → points to the next inserted element.
*/
public class LinkedHashMapDemo {

public class Main {
    public static void main(String[] args) {

        LinkedHashMap<String, Integer> students = new LinkedHashMap<>();

        // Elements are inserted in this order
        students.put("Ali", 20);
        students.put("Sara", 22);
        students.put("Yassine", 21);

        // LinkedHashMap keeps the insertion order
        System.out.println(students);
    }
}
}
