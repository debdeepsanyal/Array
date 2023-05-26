import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        char[]arr1 = s.toCharArray();
        Arrays.sort(arr1);
        String s1 = new String(arr1);
        arr1 = t.toCharArray();
        Arrays.sort(arr1);
        String t1 = new String(arr1);
        return s1.equals(t1);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anusua","nusaau"));
    }
}

//as a rule of thumb, for any anagram problems, simply sort the string
