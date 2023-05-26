import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> final_list = new ArrayList<>();
        for(int i = 1; i<=n ; i++){
            list.add(i);
        }
        permute(list, final_list, new ArrayList<>());
        list = final_list.get(k-1); //time> in this operation
        String str = "";
        for(int number : list){
            str+=String.valueOf(number);
        }
        System.out.println(str);
        return str;
    }
    static void permute(List<Integer> list, List<List<Integer>> final_list, List<Integer>path){
        if(list.isEmpty()){
            final_list.add(new ArrayList(path));
        }
        for(int i = 0; i<list.size(); i++){
            int num = list.get(i);
            List<Integer> newList = new ArrayList<>(list);
            newList.remove(i);
            path.add(num);
            permute(newList,final_list,path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        getPermutation(9,138270);
    }
}
