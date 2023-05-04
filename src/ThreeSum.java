import java.util.*;
import java.util.List;
public class ThreeSum {
    public static List<List<Integer>> final_list= new ArrayList<>();
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i< nums.length-2;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                twoSum(i+1,-1 * (nums[i]),nums);
            }
        }
        return final_list;
    }
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0,0}));
    }
    public static void twoSum(int start,int target,int[]num){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = start; i< num.length;i++){
            if(list.contains(num[i])){
                List<Integer> list2 = new ArrayList<>();
                list2.add(-target);
                list2.add(num[i]);
                list2.add(num[(list.indexOf(num[i]))+start]);
                if(final_list.contains(list2)){
                    continue;
                }
                final_list.add(list2);
            }
            else{
                list.add(target-num[i]);
            }
        }
    }




}
//    boolean t = true;
//    int a, b, c,k=1;
//    List<List<Integer>> final_list = new LinkedList<>();
//    a = 0;
//        while(t){
//        if(a< nums.length-2){
//            ArrayList<Integer>list = new ArrayList<>();
//            List<Integer> lis2 = new ArrayList<>();
//            for(b=0;b< nums.length; b++){
//                if(nums[b]==nums[a]){
//                    list.add(null);
//                    continue;
//                }
//                if(list.contains(nums[b])){
//                    c = (list.indexOf(nums[b]));
//                    System.out.println(a + "\t" + b + "\t" + c);
//                    lis2.add(nums[a]);
//                    lis2.add(nums[b]);
//                    lis2.add(nums[c]);
//                    if(final_list.contains(lis2)){
//                        break;
//                    }
//                    final_list.add(lis2);
//                    a++;
//                    k++;
//                    break;
//                }
//                list.add(-nums[a]-nums[b]);
//                if(b== nums.length-1){
//                    a++;
//                }
//            }
//            System.out.println(a);
//        }
//        else {
//            break;
//        }
//    }
//        return final_list;
//}
