import java.util.TreeMap;

/*
1. What is a TreeMap?

A TreeMap is a class in Java that stores data as key-value pairs like HashMap and LinkedHashMap, but it automatically sorts the keys.

By default, the keys are stored in ascending (natural) order.

2. TreeMap Architecture

A TreeMap does not use buckets or hashing.
It is implemented using a Red-Black Tree (a self-balancing Binary Search Tree).

Tree Structure Example

If we add:

map.put(3, "Ali");
map.put(1, "Sara");
map.put(2, "Yassine");

The TreeMap organizes the keys in a tree:

          (2)
         /   \
       (1)   (3)

When we display the map:

{1=Sara, 2=Yassine, 3=Ali}

The keys are automatically sorted.

3. TreeMap Node Structure

Each node stores:

+--------------------------------------+
| key | value | left | right | parent |
+--------------------------------------+
key → the unique identifier.
value → the data associated with the key.
left → reference to a smaller key.
right → reference to a larger key.
parent → reference to the parent node.
(Internally, Red-Black Tree nodes also store a color: red or black.)
*/
public class TreeMapDemo {
public class Main {
    public static void main(String[] args) {

        // Create a TreeMap
        TreeMap<Integer, String> students = new TreeMap<>();

        // put() adds key-value pairs
        students.put(3, "Ali");
        students.put(1, "Sara");
        students.put(2, "Yassine");

        // TreeMap automatically sorts by key
        System.out.println(students);
        // Output: {1=Sara, 2=Yassine, 3=Ali}

        // get() returns the value of a key
        System.out.println("Key 2: " + students.get(2));

        // Remove a key-value pair
        students.remove(1);

        // Display after removal
        System.out.println("After remove: " + students);

        // Check if a key exists
        System.out.println("Contains key 3? " + students.containsKey(3));
    }
}
}
