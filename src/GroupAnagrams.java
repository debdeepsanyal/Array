import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,Integer> map = new HashMap<>();
        List<List<String>> final_list = new ArrayList<>();
        int i =0;
        for(String s : strs){ //add original string to a list, the list to the final list. add the sorted version of the original string to hashMap(containing the sorted string and the index it was found at)
            List<String> list = new ArrayList<>();
            char[] hold = s.toCharArray();
            Arrays.sort(hold);
            String s1 = new String(hold);
            if(map.containsKey(s1)){
                final_list.get(map.get(s1)).add(s);
                continue;
            }
            list.add(s);
            final_list.add(list);
            map.put(s1,i);
            i++;
        }
        return final_list;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}

//okay so here's an explanation to this code. let us first try to understand the basic intuition of the code.
//we can check if two jumbled up strings/numbers are equal if we simply sort them. like suppose we have a number 14372 and 73214, how to check if they are equal?
//just sort them, once you sort them, both of them result in 12347, and then we can check for their equality. that was the basic intuition behind this code.

//anagrams are nothing but jumbled up strings, and in this code we have to pair them up. let us have an insight into the approach that was taken.
//so we loop thorough the array of strings that we have, and we have a list and a hashmap. we sort every string and save the sorted string in a different variable.
//we check if the sorted string is present in the hashmap, if not we simply add the real version of the sorted string to the list, amd the list to the final list.
//we also add it to the map, and when we do we are associating the index of the unique element in the final list with the key value (the sorted string).
//how does this help us? whenever we are finding a duplicate element, we are not moving to the part of the code where we are associating the sorted versions of the strings in the map to the corresponding index values in the final_list.
// on finding a duplicate element in the map, we are simply tapping in to the integer value associated with it which are actually the index values of the list in which the original version of the string is stored in the final list.
//so we obtain the index value and the unscrambled version of that string to that index in the list.

//as an example

//the first string is eat, the sorted versin of eat is aet, and we search if aet is in our hashmap, with the answer as negative, we add aet to our hashmap as key with the value as 0, and we add eat as a list to the final lsit.
// next we have tea, which if sorted is aet again, and this time when we look for aet in the hashmap, we find it, and we add tea to the list which has the index similar to the value pair of aet, i.e. 0,
// thus the final list's first element now looks like [eat,tea], and this is how the rest of the code proceeds
