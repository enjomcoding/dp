
import java.util.ArrayList;
//todo: matrix chain multiplication
public class Matrix_Chain_Mult {

    // Matrix multiplication helper
    public static ArrayList<int[][]> multiply(int[][] A, int[][] B, int num, ArrayList<int[][]> matrices) {
        int[][] res_mtrx = new int[A.length][B[0].length];
        for (int h = 0; h < num; h++) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    res_mtrx[i][j] = 0; // Initialize the result matrix to zero
                }
            }
            matrices.add(res_mtrx); // Add the result matrix to the list of matrices
        }
        return matrices;
    }

    // This method computes and prints the optimal parenthesization and the minimum multiplication cost
    protected static void get_pro(ArrayList<Integer> dim) {
        int num = dim.size() - 1;  // number of matrices
        int[][] m = new int[num][num];
        int[][] s = new int[num][num];

        // Initialize the m matrix (min multiplication costs)
        for (int i = 0; i < num; i++) {
            m[i][i] = 0; // Cost is 0 for one matrix
        }

        // Dynamic programming to compute the minimum cost and optimal parenthesization
        for (int L = 2; L <= num; L++) { // L = chain length
            for (int i = 0; i <= num - L; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + dim.get(i) * dim.get(k + 1) * dim.get(j + 1);
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        // Output the results
        System.out.println("Minimum number of multiplications: " + m[0][num - 1]);
        System.out.print("Optimal Parenthesization: ");
        printParenthesis(s, 0, num - 1);
        System.out.println();
    }

// This helper function prints the optimal parenthesization from the `s` matrix
    private static void printParenthesis(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print((char) ('A' + i));  // Correctly print the matrix name (A, B, C...)
        } else {
            System.out.print("(");
            printParenthesis(s, i, s[i][j]);  // Recursively print the left side
            printParenthesis(s, s[i][j] + 1, j);  // Recursively print the right side
            System.out.print(")");
        }
    }

// This method computes dimensions for matrices C to N (if needed)
    protected static ArrayList<Integer> get_preDim(ArrayList<Integer> dim, int num) {
        // Ensure that the dimension list has at least 2 elements (A and B)
        for (int i = dim.size(); i < num + 1; i++) {
            // Add the column of the previous matrix
            dim.add(dim.get(0));  // Add previous matrix column as the new matrix row
            //dim.add(100); 
        }
        return dim;
    }

}
