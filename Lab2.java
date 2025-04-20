
import java.util.ArrayList;
import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input Number of Matrices: ");
        int num = input.nextInt();

        ArrayList<Integer> dim = new ArrayList<>();
        int[][] cols_rows = new int[num + 1][2];
        ArrayList<int[][]> matrices = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            char mtrx_name = (char) ('A' + i);
            System.out.println("\n<Matrix " + mtrx_name + ">");
            System.out.print("-Input Column: ");
            int col = input.nextInt();
            System.out.print("-Input Row: ");
            int row = input.nextInt();

            cols_rows[i][0] = col;
            cols_rows[i][1] = row;

            if (i == 0) {
                dim.add(col);
                dim.add(row);
            }

            int[][] matrix = new int[col][row];//changed
            System.out.println("-Enter Elements:");
            for (int c = 0; c < col; c++) {
                for (int r = 0; r < row; r++) {
                    System.out.print(mtrx_name + "[" + c + "][" + r + "]: ");
                    matrix[c][r] = input.nextInt();
                }
            }
            matrices.add(matrix);
        }
        System.out.println(dim.size());
        dim = Matrix_Chain_Mult.get_preDim(dim, num);
        //System.out.println(">>>>>>>????");
        System.out.println(dim.size());
        int ind = 1;
        for (int i = 2; i < num; i++) {
            cols_rows[i][0] = dim.get(ind);     // col of matrix i
            cols_rows[i][1] = dim.get(ind + 1); // row of matrix i
            ind += 2;
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

            int[][] matrix = matrices.get(i);//chnaged
            for (int c = 0; c < matrix.length; c++) {
                for (int r= 0; r < matrix[c].length; r++) {
                    System.out.print(matrix[c][r] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("<<Matrix Multiplication>>");
        Matrix_Chain_Mult.get_pro(matrices);

        // Optional: print dim[]
        System.out.print("dim[] = ");
        for (int d : dim) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    
}
