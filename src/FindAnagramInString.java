import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramInString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length()>s.length()){
            return list;
        }
        HashMap<Character, Integer> Pcount = new HashMap<>();
        HashMap<Character, Integer> Scount = new HashMap<>();
        //now we are going to add the charcters in our string p in the Pcount and the number of times they appear
        for(int i = 0; i<p.length(); i++){
            Pcount.put(p.charAt(i),Pcount.getOrDefault(p.charAt(i),0)+1); //we are inputting the character and for the number, if we already have the character in the map then we are simply going to increment the value associated with it by 1, else we are going to make it 1.
            Scount.put(s.charAt(i),Scount.getOrDefault(s.charAt(i),0)+1);
        }
        System.out.println(Pcount);
        System.out.println(Scount);
        if(Pcount.equals(Scount)){ //we just checked for the first p.length() alphabets in s, and if their maps are equal, which would mean that they are anagrams, we add index 0 to our list
            list.add(0);
        }
        int l = 0;
        for(int r = p.length(); r<s.length(); r++){
            Scount.put(s.charAt(r),Scount.getOrDefault(s.charAt(r),0)+1);
            Scount.put(s.charAt(l),Scount.getOrDefault(s.charAt(l),0)-1); //decrementing the count of the first character from the last substring, and if the count is 0 ,we will simply remove it from the map
            if(Scount.get(s.charAt(l))==0){
                Scount.remove(s.charAt(l));
            }
            System.out.println(Scount);
            l++;
            if(Pcount.equals(Scount)){
                list.add(l);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("bacdbaecabd","abc"));
    }
}

//we can perform a sliding window of length of String p on String s, and use it to refer to the Anagram hashmap to solve the problem. if we do find a match, we add the first index of the window

































































































//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class FindAnagramsInString {
//    public static List<Integer> findAnagrams(String s, String p) {
//        int length=0;
//        List<Integer> list = new ArrayList<>();
//        char[]array_s = p.toCharArray();
//        Arrays.sort(array_s);
//        if(s.length()%p.length()!=0){
//            length = (s.length() - 1) - (s.length()%p.length());
//        }
//        System.out.println(length);
//        String sorted_s = new String(array_s);
//        //System.out.println(sorted_s);
//        for(int i = 0; i<=s.length();i++){
//            String hold = s.substring(i,i+p.length());
//            char[]array_p = hold.toCharArray();
//            Arrays.sort(array_p);
//            String sort_hold = new String(array_p);
//            System.out.println(sort_hold);
//            if(sort_hold.equals(sorted_s)){
//                list.add(i);
//            }
//            if(i+p.length()>s.length()-1){
//                break;
//            }
//        }
//        //System.out.println((length+1)-(p.length()-1));
////        for(int i = (length+1)-(p.length()-1); i<s.length();i++){
////            String hold = s.substring(i,i+p.length());
////            char[]array_p = hold.toCharArray();
////            Arrays.sort(array_p);
////            String sort_hold = new String(array_p);
////            if(sort_hold.equals(sorted_s)){
////                list.add(i);
////            }
////            if(i+p.length()>s.length()-1){
////                break;
////            }
////        }
//        return list;
//    }
//
//    public static void main(String[] args) {
//
//}
