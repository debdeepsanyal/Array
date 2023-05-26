import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        int k = -1;
        String r = "";
        List<String> list = new LinkedList<>(List.of());
        for(int i = 0; i<path.length(); i++){
            list.add(String.valueOf(path.charAt(i)));
        }
        for(int i = list.size() - 1; i>=0; i--){
            if(Objects.equals(list.get(0), "/")){
                list.remove(0);
                continue;
            }
            if(Objects.equals(list.get(i), ".") && Objects.equals(list.get(i - 1), ".")){
                k = i;
                for(String s : list){
                    r+=s;
                }
                break;
            }
            if(Objects.equals(list.get(list.size() - 1), ".")||Objects.equals(list.get(list.size() - 1), "/")){
                list.remove(list.size()-1);
                continue;
            }
            if(Objects.equals(list.get(i), "/") && Objects.equals(list.get(i - 1), "/")){
                list.remove(i);
            }
            if(Objects.equals(list.get(i), ".") && !Objects.equals(list.get(i - 1), ".")){
                list.remove(i);
                list.remove(i-1);
            }
        }
        String res = "";
        if(k!=-1){
            res = r.substring(k+1, list.size());
            if(res.equals("")){
                res="/";
            }
            if(res.charAt(0)!='/' ){
                res = "/"+res;
            }
        }
        else{
            for(String s : list){
                res+=s;
            }
            if(res.charAt(0)!='/'){
                res = "/"+res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }
}
