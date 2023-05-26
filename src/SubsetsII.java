import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> final_list = new ArrayList<>();
        generate(0, nums, new ArrayList<>(), final_list);
        return final_list;
    }
    static void generate(int index, int[]nums, List<Integer>list, List<List<Integer>> final_list){
        if(!final_list.contains(list)){
            final_list.add(new ArrayList(list));
        }
        for(int i = index; i<nums.length; i++){
            list.add(nums[i]);
            generate(i+1,nums,list,final_list);
            list.remove(list.size()-1);
        }
    }
}

//try the searching part with a hashSet once