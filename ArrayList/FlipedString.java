/**
 * Check if s2 is a rotation of s1 (e.g.,"waterbottle" is a rotation of"erbottlewat"). 
 * Can you use only one call to the method that checks if one word is a substring of another?
 * @author Zechen Liu
 * @date 2022/03/25
 **/
public class FlipedString {
    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle","erbottlewat"));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s1 + s1;
        return s.contains(s2);
    }
}
