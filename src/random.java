import java.util.Arrays;
import java.util.Random;

public class random {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getRandomArray(5)));

    }
    private static int[] getRandomArray(int length){// a method which will return an array of type int[]
        Random random = new Random();// here we are making an instance of the Random class
        int[] array = new int[length];//initialising an array of user inputted length
        for(int i = 0; i<length;i++){
            array[i]=random.nextInt(0,10);//assigning a random variable to the array using thr nextInt function
        }
        return array;
    }
}
