import java.util.LinkedHashSet;

/*
1. What is a LinkedHashSet?

A LinkedHashSet is a collection that stores unique elements like HashSet, but it keeps the insertion order of elements.

It does not store key-value pairs from the programmer's point of view.
2. Hash Table Part (Buckets)

The hash table is used for fast searching.

Example:

set.add("Ali");
set.add("Sara");
set.add("Yassine");

The elements are placed in buckets using their hash code:

Array of Buckets

Index:  0       1          2          3
        |       |          |          |
      null   [Ali] → [Sara]        [Yassine]
                 (collision)

Each bucket contains nodes. If two elements have the same bucket index, a collision happens, and they are connected using next.

3. Doubly Linked List Part (Keeps Order)

At the same time, all elements are connected in the order they were inserted:

Head                         Tail
 |                             |
 ↓                             ↓
[Ali] ⇄ [Sara] ⇄ [Yassine]

Each node has extra references:

+------------------------------------------------+
| hash | key | next | before | after |
+------------------------------------------------+
hash → hash code of the element.
key → the element stored in the LinkedHashSet.
next → handles collisions in the same bucket.
before → points to the previous inserted element.
after → points to the next inserted element.
4. Internal View

Although you use it like this:

LinkedHashSet<String> set = new LinkedHashSet<>();

set.add("Ali");
set.add("Sara");
set.add("Yassine");

Internally, Java uses a LinkedHashMap:

Key        Value
---------------------
Ali      → PRESENT
Sara     → PRESENT
Yassine  → PRESENT
The element becomes the key.
PRESENT is a hidden dummy object used internally.
*/
public class LinkedHashSetDemo {
public class Main {
    public static void main(String[] args) {

        // Create a LinkedHashSet
        LinkedHashSet<String> students = new LinkedHashSet<>();

        // Add elements
        students.add("Ali");
        students.add("Sara");
        students.add("Yassine");

        // Duplicate values are ignored
        students.add("Ali");

        // Display the LinkedHashSet
        System.out.println(students);
    }
}
}
