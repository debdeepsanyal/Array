import java.util.Arrays;
import java.util.HashMap;

public class MonotonicArray {
    public static boolean isMonotonic(int[] nums) {
        if(nums.length<3){ //if only two elements are present in the array, they are either in decreasing order or in increasing order, either way they are monotonic
            return true;
        }
        int k = 1;
        while(k< nums.length && nums[0]==nums[k]){ //this simply checks for a case if the array contains repetitive elements, it stops when a new element is encountered
            k++;
        }
        if(k== nums.length){ //if all the elements in the array are equal, ofcourse the array is monotonic
            return true;
        }
        if(nums[k]<nums[0]){//if the array contains heterogeneous elements, we check at the point where the element is different from the last one
            for(int i =1; i<nums.length; i++){//if the element is smaller from the previous one, we simply check if all preceding elements are smaller from the last element
                if(nums[i]>nums[i-1]){ //if an element is bigger than the last one, array is not monotonous
                    return false;
                }
            }
            return true;//else, we know that the array is decreasing monotonous
        }
        for(int i =1; i<nums.length; i++){//this loop here checks for increasing monotonous
            if(nums[i]<nums[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{6,5,4,4}));
    }
}































//    int[] array = new int[nums.length];
//        for(int i = 0; i< nums.length; i++){
//        array[i] = nums[i];
//        }
//        Arrays.sort(array);
//        if(Arrays.equals(nums, array)){
//        return true;
//        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(array));
//        int k = array.length-1;
//        for(int i = 0; i<array.length/2; i++){
//        int temp;
//        temp = array[i];
//        array[i]=array[k];
//        array[k]=temp;
//        k--;
//        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(array));
//        return Arrays.equals(nums, array);
