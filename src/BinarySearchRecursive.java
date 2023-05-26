import java.util.Arrays;
import java.util.Random;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[]array = new int[]{23,31,54,66,69,72,90,101};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int target = 72;
        System.out.println(BinarySearch(array.length - 1, 0, target, array));
    }
    static int BinarySearch(int high, int low, int target, int[]array){
        if(high<low){
            return -1;
        }
        int mid = (high + low)/2;
        if(array[mid] == target){
            return mid;
        }
        if(target<array[mid]){
            return BinarySearch(mid - 1, low,target,array );
        }
        if(target>array[mid]){
            return BinarySearch(high,mid+1,target,array);
        }
        return mid;
    }

}
//whenever you call a recursive function which has a return type(other than void), make sure you return the recursive call.

// like when we are calling //return BinarySearch(mid - 1, low,target,array );// we are adding a return in front of it since it needs to return the value it came up with