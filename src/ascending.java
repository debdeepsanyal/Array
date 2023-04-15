import java.util.Arrays;
import java.util.Scanner;

public class ascending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num,i;
        System.out.println("How many elements do you want in the array ");
        num = sc.nextInt();
        int array[] = new int[num];
        int array2[] = new int[num-1];
        for(i=0;i<num;i++){
            System.out.println("Enter element " + i);
            int element = sc.nextInt();
            array[i]=element;
        }
        for(i=0;i<num-1;i++){
            array2[i]=Math.abs(array[i]-array[i+1]);
        }
        int c = 0;
        for(i=0;i<num-2;i++){

            if(array2[i]<array2[i+1]){
                c++;
            }
        }
        if(c==num-2){
            System.out.println("satisfied");
        }
        else {
            System.out.println("not satisfied");
        }
        for(i=0;i<num;i++){
            System.out.println(array[i]);//this is the traditional for loop method to print out the elements in an array
        }
        for(int element : array){//this is the enhanced for loop. useful while printing out the elements of an array
            System.out.println(element); // or if all we need to do is to process the elements of the array from start to the end
        }

        System.out.println(Arrays.toString(array));//yet another method to print arrays. this one uses the toString function of the java Arrays package



    }
}
