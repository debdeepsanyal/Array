import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class longestPalindrome {
    public static String longestPalindrome(String s){
        int start = 0, end = 0;
        for(int i =0; i<s.length(); i++){
            int len1 = find(s,i,i); //this is for palindromes of odd length, like abcba. so we can expand from c as the centre, and keep checking
            int len2 = find(s,i,i+1);//this is for palindromes of even length. now these kind of palindromes dont have a centre, so we need to deal with neighbouring strings as combined centres
            int len = Math.max(len1,len2);
            if((end - start) < len){ //this is a simple calculation to set the indices from the length we just acquired with the max function and the current index of the loop
                start = i-((len-1)/2);
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }
    static int find(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return (j-i)-1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbcccbbbcaaccbababcbcabca"));
    }
}


// we apply the method of expand from centre. the concept is that we loop through the string, and for every variable to check to its right and left to check if it is a palindrome.

























//    public static String longestPalindrome(String s){         //this is the brute force approach for this code. it works but is not the most efficient one.
//        String s1 = "";
//        String s2 = "";
//        List<String> list = new ArrayList<>();
//        check(s,s1,s2,0,s.length(),list);
//        System.out.println(list);
//        for(String str : list){
//            s1=s1.length()>str.length()?s1:str;
//        }
//        return s1;
//    }
//    static void check(String s, String s1, String s2, int index, int length, List<String>list){
//        if(index==s.length()){
//            return;
//        }
//        for(index=0; index<length; index++){
//            if(isPal(s,index,length-1)){
//                s2=s.substring(index,length);
//                s1=s1.length()>s2.length()?s1:s2;
//                if(!list.contains(s1)){
//                    list.add(s1);
//                }
//                return;
//            }
//            check(s,s1,s2,index,length-1,list);
//        }
//    }
//    static boolean isPal(String s, int start, int end){
//        if(s.charAt(start)==s.charAt(end)){
//            if(start==end || start + 1 == end){
//                return true;
//            }
//            return isPal(s,start+1,end-1);
//        }
//        return false;
//    }
