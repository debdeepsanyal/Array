import java.util.ArrayList;
import java.util.List;
public class LinearSearchRecursion {
    public static void main(String[] args) {
        int[]array = new int[]{1,5,4,6,12,14,93,4};
        System.out.println(findMultipleIndex(array,0,4, new ArrayList<>()));
    }
    static boolean check(int[]array, int index, int target){
        if(index == array.length){
            return false;
        }
        if(array[index]==target){
            return true;
        }
        return check(array,index+1,target);
    }
    static int findIndex(int[]array, int index, int target){
        if(index == array.length){
            return -1;
        }
        if(check(array, array.length - 1 - index, target)){
            return array.length-1 - index;
        }
        return findIndex(array,index+1,target);
    }
    static List<Integer> findMultipleIndex(int[]array, int index, int target, List<Integer>list) {
        if(index == array.length){
            return list;
        }
        if(array[index]==target){
            list.add(index);
        }
        return findMultipleIndex(array,index+1,target,list);
    }
    }

