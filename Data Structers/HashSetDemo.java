import java.util.HashSet;

/*
1. What is a HashSet?

A HashSet is a collection in Java that stores unique elements.
It does not allow duplicate values and does not maintain insertion order.

It is implemented internally using a HashMap.

2. HashSet Architecture

A HashSet uses a Hash Table with buckets, just like HashMap.

            HashSet

              Array
                |
        +-------+-------+
        |       |       |
     Bucket0 Bucket1 Bucket2
        |       |       |
      null    [Ali] → [Sara]
                  (collision)

Each element is placed into a bucket based on its hash code.

3. How does HashSet store data?

When you write:

HashSet<String> names = new HashSet<>();

names.add("Ali");
names.add("Sara");
names.add("Yassine");

Internally, it works like a HashMap:

HashMap
----------------------
Key       Value
----------------------
Ali    →  PRESENT
Sara   →  PRESENT
Yassine → PRESENT

The element is stored as the key, and a dummy value is stored internally.
*/
public class HashSetDemo {
public class Main {
    public static void main(String[] args) {

        // Create a HashSet
        HashSet<String> students = new HashSet<>();

        // add() inserts elements
        students.add("Ali");
        students.add("Sara");
        students.add("Yassine");

        // Duplicate values are ignored
        students.add("Ali");

        // Display the HashSet
        System.out.println("Students: " + students);
        // Order is not guaranteed

        // Check if an element exists
        System.out.println("Contains Ali? " 
                + students.contains("Ali"));

        // Remove an element
        students.remove("Sara");

        // Display after removal
        System.out.println("After removal: " + students);

        // Number of elements
        System.out.println("Size: " + students.size());

        // Check if the HashSet is empty
        System.out.println("Is empty? " + students.isEmpty());
    }
}
}
