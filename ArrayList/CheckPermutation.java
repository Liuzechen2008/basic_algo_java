import java.util.HashMap;
import java.util.Map;

/**
 * @author Zechen Liu
 * @date 2022/03/22
 **/
public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc", "bca"));
        System.out.println(CheckPermutation("abc", "bad"));
    }

    public static boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < len2; i++) {
            char ch = s2.charAt(i);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                if (count > 0) {
                    map.put(ch, count - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
