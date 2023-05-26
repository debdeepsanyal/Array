import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int count1 = 1;
        HashSet<Character> set = new HashSet<>();
        int l =0, r=1, count = 1;
        set.add(s.charAt(l));
        while(r<s.length()){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
                count++;
                count1=Math.max(count,count1);
                System.out.println(set);
                System.out.println(count);
                continue;
            }
            while(true){
                set.remove(s.charAt(l));
                l++;
                count--;
                count1=Math.max(count,count1);
                System.out.println(set);
                System.out.println(count);
                if(!set.contains(s.charAt(r))){
                    break;
                }
            }
        }
        return count1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
//have a hashset, keep adding characters to it and proceed in the string traversal, have a count of the characters being added, once you encounter an element already present in the set, move the left pointer to the right till youve passed the repeating element,
//keep decreasing the count of this removal. check the removal count's max with the adding count's max and store the value to be returned.