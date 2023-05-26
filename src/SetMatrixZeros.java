import java.util.Arrays;

public class SetMatrixZeros {
    public static void setZeroes(int[][] matrix) {
        boolean zero_in_first_row = false, zero_in_first_column = false;
        for(int row = 0; row< matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[0][column] == 0) {
                    zero_in_first_row = true;
                }
                if (matrix[row][0] == 0) {
                    zero_in_first_column = true;
                }
            }
        }
        for(int row = 0; row< matrix.length; row++){
            for(int column = 0; column<matrix[0].length; column++){
                if(matrix[row][column]==0){
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }

        //till here, we are good

        System.out.println(Arrays.deepToString(matrix));

        for(int column = 1; column<matrix[0].length; column++){
            if(matrix[0][column]==0){
                int i = 0;
                while(i<matrix.length){
                    matrix[i][column]=0;
                    i++;
                }
            }
        }
        for(int row = 1; row<matrix.length; row++){
            if(matrix[row][0]==0){
                int i = 0;
                while(i<matrix[0].length){
                    matrix[row][i]=0;
                    i++;
                }
            }
        }
        if(zero_in_first_row){
            for(int column = 0; column<matrix[0].length; column++){
                matrix[0][column]=0;
            }
        }
        if(zero_in_first_column){
            for(int row = 0; row<matrix.length; row++){
                matrix[row][0]=0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
}
//public class Solution {
//    public void setZeroes(int[][] matrix) {
//        boolean fr = false,fc = false;
//        for(int i = 0; i < matrix.length; i++) {
//            for(int j = 0; j < matrix[0].length; j++) {
//                if(matrix[i][j] == 0) {
//                    if(i == 0) fr = true;
//                    if(j == 0) fc = true;
//                    matrix[0][j] = 0;
//                    matrix[i][0] = 0;
//                }
//            }
//        }
//        for(int i = 1; i < matrix.length; i++) {
//            for(int j = 1; j < matrix[0].length; j++) {
//                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
//                    matrix[i][j] = 0;
//                }}
//        }
//        if(fr) {
//            for(int j = 0; j < matrix[0].length; j++) {
//                matrix[0][j] = 0;
//            }
//        }
//        if(fc) {
//            for(int i = 0; i < matrix.length; i++) {
//                matrix[i][0] = 0;
//            }
//        }
//    }}



//okay so lets talk about the approach to this problem. to boil the problem donw we have a matrix and w
