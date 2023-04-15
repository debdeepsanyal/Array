import java.util.Arrays;
import java.util.Scanner;

public class descending_sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j,temp;
        System.out.println("Enter the number of elements you want in an array");
        int num = sc.nextInt();
        int[]array = new int[num];
        for(i=0;i<num;i++){
            System.out.printf("Enter element %d",i+1);
            int element = sc.nextInt();
            array[i]=element;
        }
        for(i=0;i<num;i++){
            for(j=i+1;j<num;j++){
                if(array[j]>array[i]){
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));

    }
}
