/*
1. What is a TreeSet?

A TreeSet is a collection that stores unique elements like HashSet and LinkedHashSet, but it automatically sorts the elements.

❌ No duplicate elements.
✅ Elements are kept in ascending order by default.
❌ No index (you cannot access elements using get(0)).
4. Tree Structure Example

If we add:

set.add(20);
set.add(10);
set.add(30);

The elements are organized like this:

             20
            /  \
          10    30

When we print the TreeSet:

[10, 20, 30]

The tree allows Java to keep the elements sorted.

5. Internal View

Unlike HashSet, TreeSet does not use buckets or hashing.

Internally it behaves like a TreeMap:

Key      Value
----------------
10   →  PRESENT
20   →  PRESENT
30   →  PRESENT
The element becomes the key in the internal TreeMap.
PRESENT is a hidden dummy value used by Java.
6. Main TreeSet Operations
Method	Description
add()	Add an element
remove()	Remove an element
contains()	Check if an element exists
first()	Get the smallest element
last()	Get the largest element
size()	Number of elements
isEmpty()	Check if the set is empty
*/
import java.util.TreeSet;
public class TreeSetDemo {

public class Main {
    public static void main(String[] args) {

        // Create a TreeSet
        TreeSet<Integer> numbers = new TreeSet<>();

        // Add elements (order of insertion does not matter)
        numbers.add(30);
        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // Duplicate, ignored

        // Display the TreeSet
        System.out.println(numbers);
    }
}
}
