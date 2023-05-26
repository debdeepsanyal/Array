import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ShiftingLetters {
    public static String shiftingLetters(String s, int[] shifts) {
        char[] array = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char c : array){
            list.add(c);
        }
        for(int i = 0; i< shifts.length; i++){
            int sums = 0;
            for(int j = i; j< shifts.length; j++){
                sums+=shifts[j];
            }
            while((list.get(i)+sums) > 122){
                sums-=26;
            }
            System.out.println(sums);
            list.set(i, (char) (list.get(i)+sums));
        }
        String str = "";
        for(int i = 0; i<list.size(); i++){
            str+=list.get(i);
        }
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) {
        System.out.println(shiftingLetters("b",new int[]{26}));
    }
}
