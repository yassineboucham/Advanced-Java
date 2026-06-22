import java.util.HashMap;

public class HashMapDemo {
/*
A HashMap is a data structure that stores data in key-value pairs.

Key → a unique identifier.
Value → information associated with the key.

Think of it like a dictionary:

Key       Value
----------------
"Ali"  →   20
"Sara" →   22
"Yassine" → 21

Here:

"Ali" is the key.
20 is the value.

Main HashMap Operations
put(key, value) → Add or update an element.
get(key) → Get the value of a key.
remove(key) → Delete an element by key.
containsKey(key) → Check if a key exists.
containsValue(value) → Check if a value exists.
size() → Get the number of elements.
isEmpty() → Check if the HashMap is empty.
clear() → Remove all elements.

HashMap Node Structure
+---------------------------+
| hash | key | value | next |
+---------------------------+
hash → hash code of the key.
key → unique identifier.
value → associated data.
next → points to the next node in the same bucket (collision handling).
*/


public class Main {
    public static void main(String[] args) {

        // Create a HashMap with:
        // Key type: String
        // Value type: Integer
        HashMap<String, Integer> students = new HashMap<>();

        // put() adds key-value pairs
        students.put("Ali", 20);
        students.put("Sara", 22);
        students.put("Yassine", 21);

        // Display the HashMap
        System.out.println("Students: " + students);

        // get() returns the value associated with a key
        System.out.println("Ali's age: " + students.get("Ali"));

        // Update a value
        students.put("Ali", 23);

        // Check if a key exists
        System.out.println("Contains Sara? " 
                + students.containsKey("Sara"));

        // Remove an element by key
        students.remove("Sara");

        // Display the HashMap after removal
        System.out.println("After removal: " + students);

        // Number of key-value pairs
        System.out.println("Size: " + students.size());

        // Check if the HashMap is empty
        System.out.println("Is empty? " + students.isEmpty());
    }
}

}
