import java.util.*;

public class stringSubSet {
    public static boolean subsets(String str, String str2) {
        String[] str1 = str.split("");
        List<List<String>>final_list = new ArrayList<>();
        final_list.add(new ArrayList<>()); //the first step, we are adding an empty subset to our list which serves as the base to following subsets
        for(String num : str1){ //we are looping through all the items in the array nums
            int n = final_list.size();
            for(int i = 0; i<n;i++){
                List<String> temp = new ArrayList<>(final_list.get(i));
                temp.add(num);
                final_list.add(temp);
            }
        }
        String[]array = str2.split("");
        List<String> string = new ArrayList<>(List.of(array));
        for (List<String> strings : final_list) {
            if (Objects.equals(strings, string)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(subsets("anusua","su"));
    }
}
