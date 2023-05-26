import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> final_list = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Subsets(0,final_list,list,candidates,target);
        return final_list;

    }
    static void Subsets(int index,List<List<Integer>> final_list, List<Integer> list, int[] candidates, int target){
        if(target==0){
            final_list.add(new ArrayList<>(list));
        }
        if(target<0){
            return;
        }
        for(int i = index; i<candidates.length; i++){
            if(i!= index && candidates[i]<=candidates[i-1]){continue;}
            list.add(candidates[i]);
            Subsets(i+1, final_list, list, candidates, target-i);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1},3));
    }
}
