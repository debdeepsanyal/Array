import java.util.ArrayList;
import java.util.List;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(new Integer[]{5,6,7,8,13,1,2,3}));
        //System.out.println(rotatedIndex(list,5,0,list.size(),findMaxIndex(list,5,0)+1,new Integer[]{5,6,7,8,13,1,2,3},2));
        System.out.println(BinarySearch(list.size(),findMaxIndex(list,5,0)+1,new Integer[]{5,6,7,8,13,1,2,3},2));
    }
    static int findMaxIndex(List<Integer> list, int max, int index){
        if(index == list.size()){
            return list.indexOf(max);
        }
        if(list.get(index)>max){
            max = list.get(index);
        }
        return findMaxIndex(list,max,index+1);
    }
    static int BinarySearch(int high, int low, Integer[] array, int target){
        if(low>high){
            return -1;
        }
        int mid = (high+low)/2;
        if(array[mid]==target){return mid;}
        if(array[mid]>target){
            return BinarySearch(mid - 1, low, array, target);
        }
        else{
            return BinarySearch(high, mid+1, array, target);
        }
    }
//    static int rotatedIndex(List<Integer> list, int max, int index,int high, int low, Integer[] array, int target){
//        return findMaxIndex(list,max,index) + 1 + BinarySearch(high, low, array, target);
//    }
}
