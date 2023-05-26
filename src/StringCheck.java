import java.util.ArrayList;
import java.util.List;

public class StringCheck {
    public static List<String> check (String s){
        String[]array = s.split("");
        List<String> list = new ArrayList<>();
        List<List<String>> final_list = new ArrayList<>();

        String str = "";
        Subsets(0,str,list,array);
        System.out.println(list);
        //System.out.println(final_list);
        return null;

    }
    static void Subsets(int index, String str, List<String>list, String[]array){
        if(isPal(str,0,str.length()-1)){
            list.add(str);
            //list.add(str);
        }
        //list.add(str);
        for(int i = index; i<array.length; i++){
            str+=array[i];
            Subsets(i+1,str,list,array);
            str=str.substring(0,str.length()-1);
        }
    }
    static boolean isPal(String s, int start, int end){
        if(start>end){
            return false;
        }
        if(s.charAt(start)==s.charAt(end)){
            if(start==end || start+1==end){ //the first condition is for strings have odd number of alphabets in it and the second is for strings having even number of characters
                return true;
            }
            return isPal(s,start+1,end-1);
        }
        return false;
    }

    public static void main(String[] args) {
        check("aab");
        System.out.println(isPal("abca",0,3));
    }
}
