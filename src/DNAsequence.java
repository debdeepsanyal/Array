import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DNAsequence {
    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hash = new HashSet<>();
        List<String> list = new ArrayList<>();
        if(s.length()==10){
            list.add(s);
            System.out.println(list);
            return list;
        }
        for(int i = 0; i<s.length()-9; i++){
            String str = s.substring(i,i+10);
            if(!hash.contains(str)){
                hash.add(str);
                continue;
            }
            if(!list.contains(str)){
                list.add(str);
            }
        }
        System.out.println(hash);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
