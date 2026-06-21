import java.util.LinkedList;
class Student {
    String name;
    int age;

    // Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display student information
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class LinkedListdemo {

public class Main {
    public static void main(String[] args) {
        // Create a LinkedList of Student objects
        LinkedList<Student> students = new LinkedList<>();

        // Add objects to the LinkedList
        students.add(new Student("Ali", 20));
        students.add(new Student("Sara", 21));
        students.add(new Student("Yassine", 22));

        // Display all students
        for (Student s : students) {
            s.display();
        }

        // Remove a student
        students.remove(1);

        System.out.println("After removing:");

        // Display the updated list
        for (Student s : students) {
            s.display();
        }
    }
}
}