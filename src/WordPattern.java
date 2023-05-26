import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] array = s.split(" "); //here we have an array consisting of all the words in our String s
        if(pattern.length()!=array.length){ //if the number of alphabets in pattern is not equal to the number of words in s, we know that there is no way we are sticking to the pattern of the problem, hence we can safely return false
            return false;
        }
        for(int i = 0; i<array.length; i++){
            if(map.containsKey(pattern.charAt(i))){ //while adding elements if we encounter a char that we have added to the map before, we check if the string at that index in the array is equal to the string associated to the char key in the map, if not, we return false since that violates the demand of this problem
                String str = array[i];
                if(!Objects.equals(str, map.get(pattern.charAt(i)))){
                    return false;
                }
                map.put(pattern.charAt(i),array[i]);
                continue;
            }
            if(map.containsValue(array[i])){
                return false;
            }
            map.put(pattern.charAt(i),array[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
