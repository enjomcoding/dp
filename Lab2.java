import java.util.ArrayList;
import java.util.Scanner;
//todo: <<Matrix Sizes>>
/*
Matrix A: 2 x 1
Matrix B: 1 x 2
Matrix C: 1 x 2 should be 2 x 2 
Matrix D: 2 x 2
*/
public class Lab2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input Number of Matrices: ");
        int num = input.nextInt();

        ArrayList<Integer> dim = new ArrayList<>();
        int[][] cols_rows = new int[num][2];
        ArrayList<int[][]> matrices = new ArrayList<>();

        // Input Matrix A and B
        for (int i = 0; i < 2; i++) {
            char mtrx_name = (char) ('A' + i);
            System.out.println("\n<Matrix " + mtrx_name + ">");
            System.out.print("-Input Column: ");
            int col = input.nextInt();
            System.out.print("-Input Row: ");
            int row = input.nextInt();

            cols_rows[i][0] = col;  // col
            cols_rows[i][1] = row;  // row

            // Build dim[] based on COLUMN then ROW input
            if (i == 0) {
                dim.add(col);  // A's col
                dim.add(row);  // A's row = B's col
            }else{
                dim.add(row);  // B's row
            }

            // Create matrix [row][col] even though user inputs col first
            int[][] matrix = new int[col][row];
            System.out.println("-Enter Elements:");
            for (int c = 0; c < col; c++) {
                for (int r = 0; r < row; r++) {
                    System.out.print(mtrx_name + "[" + c + "][" + r + "]: ");
                    matrix[c][r] = input.nextInt();  // Row first, Column second
                }
            }
            matrices.add(matrix);
        }

        // Compute remaining dimensions (C to N)
        dim = Matrix_Chain_Mult.get_preDim(dim, num);
        System.out.println("ewfrwt" + dim.size());

        int index = 2;
        for (int i = 2; i < num; i++) {
            cols_rows[i][0] = dim.get(index);     // col
            cols_rows[i][1] = dim.get(index + 1); // row
            index++;
        }

        System.out.println("\n<<Matrix Sizes>>");
        for (int i = 0; i < num; i++) {
            System.out.println("Matrix " + (char) ('A' + i) + ": "
                    + cols_rows[i][0] + " x " + cols_rows[i][1]);
        }

        System.out.println("\n<<Matrices>>");
        
        for (int i = 0; i < matrices.size(); i++) {
            char matrixName = (char) ('A' + i);
            System.out.println("Matrix " + matrixName + ":");

            int[][] matrix = matrices.get(i);
            for (int c = 0; c < matrix.length; c++) {
                for (int r = 0; r < matrix[0].length; r++) {
                    System.out.print(matrix[c][r] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("<<Matrix Multiplication>>");
        Matrix_Chain_Mult.get_pro(dim);
        
        // Print dim[] array
        System.out.print("dim[] = ");
        for (int d : dim) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}
