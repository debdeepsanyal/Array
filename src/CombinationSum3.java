import java.util.ArrayList;
import java.util.List;
public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> final_list = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Subsets(1,final_list,list,k,n);
        return final_list;
    }
     static void Subsets(int index, List<List<Integer>> final_list, List<Integer> list, int k, int n){
        if(n==0){
            if(list.size()==k){
                final_list.add(new ArrayList<>(list));
            }
        }
        for(int i = index; i<=9; i++){
            list.add(i);
            Subsets(i+1, final_list, list,k, n-i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));
    }
}


//now this is a very familiar code which is using the golden Subsets pattern, but there is a slight tweak, we need to add only those subsets to the list which has length k, and the numbers of the list are adding upto 9.
