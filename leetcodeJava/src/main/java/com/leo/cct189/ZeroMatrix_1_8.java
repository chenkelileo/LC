/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */

package com.leo.cct189;

import com.sun.org.apache.xpath.internal.operations.Bool;

//check if the position is zero, then make its row and column all zero
//find zero first

//t:O(n^2)
//s:O(M+N) O(n)

public class ZeroMatrix_1_8 {

    public static void zeroMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return;
        int rowLen = mat.length;
        int colLen = mat[0].length;

        boolean[] rowContainsZero = new boolean[rowLen];
        boolean[] colContainsZero = new boolean[colLen];


        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (mat[i][j] == 0) {
                    rowContainsZero[i] = true;
                    colContainsZero[j] = true;
                }
            }
        }

        for (int i = 0; i < rowLen; i++) {
            if (rowContainsZero[i]) {
                for (int k = 0; k < colLen; k++) {
                    mat[i][k] = 0;
                }
            }
        }

        for (int j = 0; j < colLen; j++) {
            if (colContainsZero[j]) {
                for (int k = 0; k < rowLen; k++) {
                    mat[k][j] = 0;
                }
            }
        }
    }

    static void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;

                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }

        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (col[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    static void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }


    // in-place method: use first row and first col as storage

    public static void setZeros2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;


        //check if first row contains zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        //check if first col contains zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        /*
        1
        0  0 0  0
        0 0 0 0 0
        set rows all zeros
         */
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setRowZeros(matrix, i);
            }
        }
        /*
        1 0 0

          0 0
          0 0
          0 0
        set colums all zeros
         */
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                setColZeros(matrix, j);
            }
        }
        /*
        1 0
        1 1
         */
        if (isFirstColZero)
            setColZeros(matrix, 0);

        if (isFirstRowZero)
            setRowZeros(matrix, 0);
    }

    public static void setRowZeros(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }

    }

    public static void setColZeros(int[][] matrix, int col) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        setZeros2(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }
}
