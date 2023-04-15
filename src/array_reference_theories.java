import java.lang.reflect.Array;
import java.util.Arrays;

public class array_reference_theories {
    public static void main(String[] args) {
        int[] array1 = new int[5];//here, array1 is basically a reference to an array stored in the memory
        int[] array2 = array1; //array to is a reference to the reference of the array in the memory, which implies that
                        //array2 is also a reference to the same array in the memory, which implies that array1 and array2 are pointing to the same array
                        //which indicates that array1 and array2 are basically the same variables. any change made to array2 will reflect  in array1 and vice versa
        array2[0]=1;//so when the first element of array2 is changed to 1, array1 reflects the same changes made
        modifyArray(array1);//copies of references are made, not of the actual object stored in the memory
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    private static void modifyArray(int[]myArray){//the reference array1 is copied to myArray, which again points to the same array in the memory
        myArray[1]=2;//thus any changes made to myArray will reflect inn array1 since all these references are pointing to the same array in the memory
    }
}