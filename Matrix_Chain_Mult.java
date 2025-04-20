
import java.util.ArrayList;
//todo: solve mcm matrix d - n

public class Matrix_Chain_Mult {

    protected static ArrayList<Integer> get_preDim(ArrayList<Integer> dim, int num) {
        int dim_len = dim.size();
        for (int i = dim_len; i < num + 1; i++) {
            int col = dim.get(0);
            dim.add(col);
        }
        return dim;
    }

    public static void get_pro(ArrayList<int[][]> matrices) {
        // Step 1: Multiply A × B
        int[][] mtrx_n = multiply(matrices.get(0), matrices.get(1)); // AB

        // Step 2: Multiply the rest: (AB)CDE...
        for (int i = 2; i < matrices.size(); i++) {
            mtrx_n = multiply(mtrx_n, matrices.get(i));
        }

        // Print the result
        System.out.println("Result Matrix:");
        for (int i = 0; i < mtrx_n.length; i++) {
            for (int j = 0; j < mtrx_n[0].length; j++) {
                System.out.print(mtrx_n[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Matrix multiplication helper
    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] res_mtrx = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    res_mtrx[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return res_mtrx;
    }

    protected void get_min_order(ArrayList<Integer> dim, int num){
        //must return the min order of multiplication and the order of multiplication (sample: ((AB)C)D)E))...)
        for (i = 1; i < n; i++)
            m[i][i] = 0;
 
        // L is chain length.
        for (L = 2; L < n; L++) 
        {
            for (i = 1; i < n - L + 1; i++) 
            {
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) 
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j]
                        + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
 
        return m[1][n - 1];
    }

}
