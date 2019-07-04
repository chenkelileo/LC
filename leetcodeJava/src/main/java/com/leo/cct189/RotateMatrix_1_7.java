/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * Hints:#51, #100
 */
package com.leo.cct189;

//Assume: turn right 90 degrees

//Since N*N -> in place
public class RotateMatrix_1_7 {

    public static void rotateMatrix(int[][] mat) {
        if (mat == null || mat.length < 2 || mat[0].length < 2 ||
                mat.length != mat[0].length)
            return;
        int n = mat.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) { // think deep this last

                int offset = i - first;
                int temp = mat[first][i];

                //left -> top

                mat[first][i] = mat[last - offset][first];

                //bottom -> left

                mat[last - offset][first] = mat[last][last - offset];

                //right -> bottom

                mat[last][last - offset] = mat[i][last];

                mat[i][last] = temp;

            }
        }

    }
    //t:O(n^2)
    //s:O(1)

    public static void rotateMatrix2(int[][] mat) {
        if (mat == null || mat.length < 2 || mat[0].length < 2 ||
                mat.length != mat[0].length)
            return;
        int n = mat.length;
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][n - 1 - j] = mat[j][i];
                //temp[i][n - 1 - j] = mat[0][i];
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(temp[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               mat[i][j] = temp[i][j];
            }
        }
    }
    //t:O(n^2)
    //s:O(n^2)

    public static void main(String[] args) {
        int[][] mat = new int[5][5]; // 4 row 3 column
        int num = 9;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = ++num;
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

//        System.out.println("---------------------------");
//
//        rotateMatrix(mat);
//
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat.length; j++) {
//                System.out.print(mat[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println("---------------------------");

        rotateMatrix2(mat);


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        //keep in mind
//        for(int i = 0; i < a[0].length; i++){
//            System.out.print(a[0][i] + " ");
//        }


//        int[][] mat = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//        for(int i = 0; i < mat.length;i++){
//            System.out.print(mat[0][i]+" ");
//        }
//
//        System.out.println(mat.length);
//        System.out.println(mat[2][1]);// 6
    }
}
