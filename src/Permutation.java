import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> final_list = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        backtrack(final_list,list, new ArrayList<>());
        return final_list;
    }
    static void backtrack(List<List<Integer>> final_list, List<Integer> list, List<Integer> path){
        if(list.isEmpty()){
            final_list.add(new ArrayList<>(path));
        }
        for(int i = 0; i< list.size(); i++){
            int num = list.get(i);
            List<Integer> newList = new ArrayList<>(list);
            newList.remove(i);
            path.add(num);
            backtrack(final_list, newList, path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,1,2}));
    }
}
