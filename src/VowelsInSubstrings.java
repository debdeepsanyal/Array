import java.util.ArrayList;
import java.util.List;

public class VowelsInSubstrings {
    public static long countVowels(String word) {
        String s = "";
        long count = 0;
        s=s.toLowerCase();
        count = Substrings(0,word,s,count,0);
        return count;
    }
    static long Substrings(int index, String word, String s, long count, int k){
        for(int j = 0; j<s.length(); j++){
            switch (s.charAt(j)) {
                case 'a', 'e', 'i', 'o', 'u' -> {
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(s);
        for(int i = index; i< word.length(); i++){
            s+=String.valueOf(word.charAt(i));
            count = Substrings(i+1,word,s, count,k);
            s = s.substring(0,s.length()-1);
            if(index!=k){
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countVowels("aba"));
    }
}

//we are using backtracking for our practise but we dont really need it here, we can work with loops
