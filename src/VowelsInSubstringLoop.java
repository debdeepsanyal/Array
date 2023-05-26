public class VowelsInSubstringLoop {
    public static long countVowels(String word) {
        return check(word, 0);
    }
    static long check(String word, long count){
        for(int i = 0; i<word.length(); i++){
            String s = String.valueOf(word.charAt(i));
            for(int j = i+1; j<word.length()+1; j++){
                System.out.println(s);
                for(int k = 0; k<s.length(); k++){
                    switch(String.valueOf(s.charAt(k))){
                        case "a","e","i","o","u" -> count++;
                    }
                }
                if(j==word.length()){
                    break;
                }
                s +=String.valueOf(word.charAt(j));
                //System.out.println(s);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countVowels("aba"));
    }
}
