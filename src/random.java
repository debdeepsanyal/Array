import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class random {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(s, 0, part, res);
        return res;
    }

    private static void dfs(String s, int i, List<String> part, List<List<String>> res) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPali(s, i, j)) {
                part.add(s.substring(i, j + 1));
                dfs(s, j + 1, part, res);
                part.remove(part.size() - 1);
            }
        }
    }

    private static boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
