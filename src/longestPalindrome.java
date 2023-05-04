import java.util.Objects;

public class longestPalindrome {
    public static String longestPalindrome(String s){
        int i = 0;
        if(s.length()==1){
            return s;
        }
        String[] s1 = s.split("");
        int c = 0,k=0;
        String s2 = "";
        while (i<s1.length){
            int j=i+1;
            k=0;
            c=0;
            while(j<s1.length){
                if(Objects.equals(s1[i], s1[j])){
                    k++;
                    if(j>c){
                        c=j;
                    }
                    j++;
                    continue;
                }
                j++;
            }
            if(k==0){
                i++;
            }
            else{
                int i1 = i, c1=c, t=0;
                for(int b = 0; b<(c-i)/2;b++){
                    if(Objects.equals(s1[i1 + 1], s1[c1 - 1])){
                        i1++;
                        c1--;
                        t++;
                    }
                    else{
                        break;
                    }
                }
                if(t==(c-i)/2){
                    for(int b =i;b<=c;b++){
                        s2+=s1[b];
                    }
                    break;
                }
                else{
                    i++;
                    continue;
                }
            }
        }
//        if(s2.equals("")){
//            s2+=s1[0];
//        }
        return s2;
    }

    public static void main(String[] args) {
        String s  = "aacabdkacaa";
        System.out.println(longestPalindrome(s));
    }


}
