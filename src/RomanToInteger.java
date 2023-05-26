import java.util.HashMap;
import java.util.Objects;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int sum = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        s=s.toUpperCase();
        String[] str = s.split("");
        boolean t = true;
        int i =0;
        while (t){
            if(Objects.equals(str[i], "I") && i+1 != str.length){
                if(Objects.equals(str[i + 1], "V")){
                    sum+=4;
                    i+=2;
                    if(i==s.length()){
                        break;
                    }
                    continue;
                }
                if(Objects.equals(str[i + 1], "X")){
                    sum+=9;
                    i+=2;
                    if(i==s.length()){
                        break;
                    }
                    continue;
                }
            }
            else if(Objects.equals(str[i], "X")&& i+1 != str.length){
                if(Objects.equals(str[i + 1], "L")){
                    sum+=40;
                    i+=2;
                    if(i==s.length()){
                        break;
                    }
                    continue;
                }
                if(Objects.equals(str[i + 1], "C")){
                    sum+=90;
                    i+=2;
                    if(i==s.length()){
                        break;
                    }
                    continue;
                }
            }
            else if(Objects.equals(str[i], "C")&& i+1 != str.length){
                if(Objects.equals(str[i + 1], "D")){
                    sum+=400;
                    i+=2;
                    if(i==s.length()){
                        break;
                    }
                    continue;
                }
                if(Objects.equals(str[i + 1], "M")){
                    sum+=900;
                    i+=2;
                    if(i==s.length()){
                        break;
                    }
                    continue;
                }
            }
            if(i==0 || map.get(str[i]) <= map.get(str[i-1])){
                sum+=map.get(str[i]);
                i++;
                if(i==s.length()){
                    break;
                }
            }
            else{
                System.out.println("Not a valid roman integer");
                return 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("miv"));
    }
}
