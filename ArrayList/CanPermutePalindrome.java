import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * @author liuzechen
 * @date 2022/03/24
 **/
public class CanPermutePalindrome {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("tactcoa"));
    }

    public static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
        }
        return set.size() < 2;
    }
}
