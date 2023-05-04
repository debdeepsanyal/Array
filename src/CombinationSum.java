import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> final_list = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int i = candidates.length-1; i>= 0; i--){
            findPair(i-1,candidates[i],candidates,target);
        }
        System.out.println(final_list);
        return final_list;

    }
    public static void findPair(int index,int start, int[]candidates,int target){
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0; i< candidates.length; i++){ //the elements in array following start are added in the hash
            if(hash.contains(candidates[i])){
            }
            else {
                hash.add(candidates[i]);
            }
        }
        System.out.println(hash);
        int k = target/start;
        for(int i = k; i>=1; i--){
            System.out.println(i);
            ArrayList<Integer> list = new ArrayList<>();
            int check = start*i;
            if(check == target){
                for(int l = 1 ; l<=k;l++){
                    list.add(start);
                }
                if(!final_list.contains(list)){
                    final_list.add(list);
                }
                continue;
            }
            if(hash.contains(target-check)){ //when i = 1 and check = 2, we need 6, and 3 and 3 does make 6. how to combine this 3 and 3
                list.add(target-check);
                for(int j = 1; j<=i;j++){
                    list.add(start);
                }
                if(!final_list.contains(list)){
                    final_list.add(list);
                }
            }
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,5},8);
    }
}
