import java.util.Arrays;
import java.util.Scanner;
public class reverse_string { //treat any String questions like an array question
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str,str1="";
        System.out.println("Enter a string to reverse ");
        str = sc.nextLine();
        String[] arr = str.split(""); //to reverse the string we are first going to turn it into an array comprising the characters of the string
        int k = str.length()-1;
        for(int i = k; i>=0; i--){
            str1+=arr[i]; //adding the last element of the array in the first position of the empty string
        }
        System.out.printf("The reversed String is %s ", str1);



    }
}
