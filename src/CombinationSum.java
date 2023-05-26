import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> final_list = new ArrayList<>();
        Subsets(0,final_list,new ArrayList<>(), candidates,target);
        return final_list;
    }
    static void Subsets(int index,List<List<Integer>> f_list, List<Integer>list, int[]candidates, int target){
        System.out.println(target);
        if(target==0){
            f_list.add(new ArrayList<>(list));
        }
        //f_list.add(new ArrayList<>(list));
        System.out.println(f_list);
        if(target<0){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            Subsets(i,f_list,list,candidates,target-candidates[i]);
            //target+=list.size()-1;
            list.remove(list.size()-1);
//            Subsets(i+1,f_list,list,candidates,target);
//            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}
