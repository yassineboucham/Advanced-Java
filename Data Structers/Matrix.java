/*
📌 Definition

A 2D array stores data in rows and columns.

Example:

1  2  3
4  5  6
7  8  9

This is a 3x3 matrix (3 rows, 3 columns).

📌 Declaration in Java
int[][] matrix = new int[3][3];

Or directly:

int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
📌 Accessing Elements

You use row index + column index:

System.out.println(matrix[0][0]); // 1
System.out.println(matrix[1][2]); // 6
📌 Loop Through a 2D Array
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
📌 Real-Life Example

Think of:

🧑‍🎓 Students (rows)
📊 Subjects (columns)
Math	Physics	English
15	12	14
10	18	16
*/
public class Matrix {
    public class Main {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2},
            {3, 4}
        };

        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
}
