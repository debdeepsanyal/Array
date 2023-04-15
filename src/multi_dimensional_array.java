import java.util.Arrays;
import java.util.Scanner;

public class multi_dimensional_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j;
        System.out.println("Enter the number of columns ");
        int columns = sc.nextInt();
        int[][]array = new int[4][columns];//initialised an array with 4 rows and inputted number of columns
        for(i=0;i<4;i++){//setting the values in the array
            for(j=0;j<columns;j++){
                array[i][j]=(i+1)*10 + j;
            }
        }
        System.out.println(Arrays.deepToString(array));
        array[1]=new int[]{20,30,40,50};//here, we are changing the second element of the array to a new value. but we cannot do the same
        System.out.println(Arrays.deepToString(array));//without the array creation part (new int []), that is array[1] = {10,20,30,40} is invalid

        Object[] objArray = new Object[3];//here we are creating an array which will store Objects(an array is also an Object). its nothing different from int or String datatype arrays
        objArray[0]=new String[]{"Neel","Rahul","Anusua"};//the first element of the array(which is storing object) is an array of Strings

        objArray[1] = new String[][]{{"1","2","3"},{"4","5","6","7"},{"8","9"}};//the 2nd element is a 2d array consisting of numbers

        objArray[2]= new String[][][]{{{"1","1"},{"2","2"}},{{"3.00","4.00"},{"5.00","6.00"}},{{"a","b"},{"c","d"}}};//the last element is a 3d array

        System.out.println(Arrays.deepToString(objArray));
    }
}
