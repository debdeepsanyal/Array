//import java.util.Arrays;
//
//public class merge_sorted_arrays {
//    public static void main(String[] args) {
//        int[] array1 = new int[]{1,3,4,7};
//        int[] array2 = new int[]{10,15,17,22};
//        System.out.println(Arrays.toString(merge(array1,array2)));
//    }
//    public static int[] merge(int[] a1, int [] a2){
//        int c= 0, k = a1.length + a2.length;
//        int[] a3 = new int[k];
//        for(int i = 0; i<k;i++){
//            if(i>(a1.length-1)){
//                a3[i] = a2[c];
//                c++;
//                continue;
//            }
//            a3[i] = a1[i];
//        }
//        return a3;
//    }
//}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    continue;
                }
                else{
                    if(nums[i] + nums[j] == target){
                        return new int[]{i,j};
                    }
                }
            }
        }
        return nums;
    }
}