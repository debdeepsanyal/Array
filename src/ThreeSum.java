import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        HashSet<List<Integer>>f_list = new HashSet<>();
        for(int i = 0; i<nums.length-1; i++){
            if(i == 0 || nums[i]!=nums[i-1]){
                twoSum(nums, i + 1, nums[i], list, f_list);
            }
        }
        List<List<Integer>> final_list = new ArrayList<>(f_list);
        return final_list;
    }
    static void twoSum(int[]nums, int index, int number, List<Integer> list, HashSet<List<Integer>>f_list){
        HashMap<Integer,Integer> list1 = new HashMap<>();
        for(int i = index; i<nums.length; i++){
            if(list1.containsKey(nums[i])){
                list.add(number);
                list.add(nums[i]);
                list.add(list1.get(nums[i]));
                f_list.add(new ArrayList<>(list));//we use a hashset here to skip the if(!list.contains(num)) part
                list.removeAll(list);
            }
            list1.put((-1*number)-nums[i], nums[i]); //in this hashMap, we associate the countersum of the number with the number itself, so that when we confront the countersum later in the list, we can simply tap into it and get the number.
        }
    }



    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

}
//this was relatively easy to understand and implement, we sort the array keeping the current item as target,
//we take the rest of the array as a subarray and perform TwoSum on it. the difficulty of this problem was in optimization and using the appropriate data structures to work with.