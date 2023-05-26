import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        dfs(0, s, part, res);

        return res;
    }

    private static void dfs(int i, String s, List<String> part, List<List<String>> res) {
        //System.out.println(part);
        if (i == s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPali(s, i, j)) {
                                                                                        //System.out.println(res + " r");
                part.add(s.substring(i, j + 1));
                dfs(j + 1, s, part, res);
                part.remove(part.size() - 1);
            }
        }
    }

     static boolean isPali(String s, int index, int i){
        if(s.charAt(index)==s.charAt(i)){
            if(index==i || index+1==i){
                return true;
            }
            return isPali(s, index+1, i-1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(partition("aabaaca"));
    }
}
//the approach to solve this problem is the brute force approach using backtracking.
//let us look at how the code is really working.
//the overview is, we traverse through the string from thr beginning to the end since we know that every alphabet is in itself a palindrome.
//we keep traversing and adding individual alphabets to our list. once we reach the end, we delete the last two alphabets and make substrings from the 3rd last alphabet to the end.
//once a substring is a palindrome, we add it, we stop forming substrings and we add individual characters to the list again.

//for the example aabaaca, we traverse through the length of the string, adding individual characters to the list. so it goes like a a b a a c a.
//once we reach the end, we remove the last c and a from the list, so at that stage the list looks like a a b a a, and then you start forming substrings
//from the a at index 4, you check if ac is a substring, and if aca is a substring. well aca is infact a substring so now the list looks like a a b a aca. now again we have reached the end, and we eliminate the last two elements.
// so we are back at a a b. now we start forming substrings from b, we check for ba, baa,baac, and baaca, and since neither of thema re any good, we eliminate b, list looking like a a.
//we form substrings from the 2nd a, and it goes like ab, aba - now wait. aba is a substring and we add it to the list. now since we found a substring we stop forming further substrings and we add the individual elements which follows aba, to the list.
//so its like a, aba, a, c, a. now we remove a and c and continue forming substrings from the index 4 a, like we did. so its like a, aba, aca. now we have reached the end of the string, and we remove the last two elements, aba and aca.
// we revert back to the 1st a, and we form substrings from there, and the same method is repeated.
