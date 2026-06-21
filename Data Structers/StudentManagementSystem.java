import java.util.ArrayList;
import java.util.Scanner;

class StudentManagementSystem {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n===== Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Search Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Update Student");
                System.out.println("6. Calculate Average Grade");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();

                switch (choice) {

                // ADD STUDENT
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Grade: ");
                    double grade = sc.nextDouble();

                    students.add(new Student(id, name, age, grade));
                    System.out.println("Student added successfully!");
                    break;

                // DISPLAY STUDENTS
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                // SEARCH STUDENT
                case 3:
                    sc.nextLine();
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.getName().equalsIgnoreCase(searchName)) {
                            System.out.println("Student found:");
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                // DELETE STUDENT
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();

                    boolean removed = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId() == deleteId) {
                            students.remove(i);
                            removed = true;
                            System.out.println("Student deleted successfully!");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Student not found.");
                    }
                    break;

                // UPDATE STUDENT
                case 5:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (Student s : students) {
                        if (s.getId() == updateId) {
                            sc.nextLine();

                            System.out.print("Enter new name: ");
                            s.setName(sc.nextLine());

                            System.out.print("Enter new age: ");
                            s.setAge(sc.nextInt());

                            System.out.print("Enter new grade: ");
                            s.setGrade(sc.nextDouble());

                            updated = true;
                            System.out.println("Student updated successfully!");
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student not found.");
                    }
                    break;

                // AVERAGE GRADE
                case 6:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        double sum = 0;

                        for (Student s : students) {
                            sum += s.getGrade();
                        }

                        double avg = sum / students.size();
                        System.out.println("Average Grade = " + avg);
                    }
                    break;

                // EXIT
                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option!");
                }
            }
        } finally {
            sc.close();
        }
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private double grade;

    public Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}
