import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> final_list2 = new ArrayList();
        List<List<Integer>> final_list = new ArrayList();
        final_list.add(new ArrayList());
        List<Integer> array = new ArrayList();
        for(int i = 1; i<=n; i++){
            array.add(i);
        }
        for(int nums : array){
            int j = final_list.size();
            for(int i = 0; i<j; i++){
                List<Integer> array1 = new ArrayList(final_list.get(i));
                array1.add(nums);
                if(array1.size()<=k){
                    final_list.add(array1);
                }
            }
        }
        for(var num : final_list){
            if(num.size() == k){
                final_list2.add(num);
            }
        }
        return final_list2;
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
