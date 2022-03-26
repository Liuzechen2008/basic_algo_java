/**
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 *
 * @author Zechen Liu
 * @date 2022/03/24
 **/
public class OneEditAway {
    public static void main(String[] args) {
        System.out.println(oneEditAway("teacher","bleacher"));
    }

    public static boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        int diff = len1 - len2;
        if (diff < 0) {
            return oneEditAway(second, first);
        }
        if (diff > 1) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        boolean diffFlag = false;
        while (index1 < len1 && index2 < len2) {
            if (first.charAt(index1) != second.charAt(index2)) {
                if (diffFlag) {
                    return false;
                }
                diffFlag = true;
                if (diff == 1) {
                    index2--;//need to compare again
                }
            }
            index1++;
            index2++;
        }
        return true;
    }
}
