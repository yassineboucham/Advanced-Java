import java.util.ArrayList;
public class ArrayListDemo {

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // Display the ArrayList
        System.out.println("Fruits: " + fruits);

        // Access an element
        System.out.println("First fruit: " + fruits.get(0));

        // Remove an element
        fruits.remove("Banana");

        // Display the updated list
        System.out.println("After removal: " + fruits);

        // Loop through the ArrayList
        System.out.println("All fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
}
