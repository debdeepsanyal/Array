import java.util.*;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        String[] array = magazine.split("");
        HashMap<List<String>, Boolean> hash = new HashMap<>();
        List<String> list = new ArrayList<>();
        Subset(0,hash, list, array);
        array = ransomNote.split("");
        List<String>list1 = new ArrayList<>(List.of(array));
//        System.out.println(Arrays.toString(array));
//        System.out.println(hash);
//        System.out.println(list1);
        if(hash.get(list1)){
            return true;
        }
        else{
            return false;
        }
    }
     static void Subset(int index, HashMap<List<String>, Boolean> hash, List<String> list, String[]array){
        hash.put(new ArrayList<>(list),true);
        for(int i = index; i<array.length; i++){
            list.add(array[i]);
            Subset(i+1,hash,list,array);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("asa","anusua"));
    }
}
