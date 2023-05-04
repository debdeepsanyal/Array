import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int k = digits.length-1;
        if(digits[k]!=9){ //if the last digit isnt 9, there is no issue and we can simply add 1 to the length -1 th index of the array
            digits[k]+=1;
            System.out.println(Arrays.toString(digits));
            return digits;
        }
        while (k>=0){ //if the last digit is 9, we are checking if the digits previous to the last are also 9, and we are having the index of the last 9 in the number (actually index -1)
            if(digits[k] == 9){
                k--;
                continue;
            }
            break;
        }
        System.out.println(k);
        if(k>=0){ //this if checks if the first number isnt 9 (1899)
            for(int i = k; i< digits.length; i++){
                if(i==k){ //we increment the number where the first 9 occurs and change all the following digits to 0(we change the 8 to 9, and the following numbers to be 0)
                    digits[i]++;
                    continue;
                }
                digits[i] = 0;
            }
            System.out.println(Arrays.toString(digits));
            return digits;
        }
        else{ //if all the numbers are 9, we create a new array with an increased length and we set the first element of the array as 1, and the following numbers to be 0
            int[] arr1 = new int[digits.length+1];
            arr1[0] =1;
            for(int i = 1; i< arr1.length; i++){
                arr1[i] = 0;
            }
            System.out.println(Arrays.toString(arr1));
            return arr1;
        }
    }

    public static void main(String[] args) {
        plusOne(new int[]{9,9,9,9});
    }
}
