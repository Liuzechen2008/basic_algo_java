/**
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 *
 * @author Zechen Liu
 * @date 2022/03/23
 **/
public class ReplaceSpaces {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }

    public static String replaceSpaces(String S, int length) {
        char[] chs = S.toCharArray();
        int i = length - 1;
        int j = chs.length - 1;
        while (i >= 0) {
            if (chs[i] == ' ') {
                chs[j--] = '0';
                chs[j--] = '2';
                chs[j--] = '%';
            } else {
                chs[j--] = chs[i];
            }
            i--;
        }
        return String.valueOf(chs).substring(j + 1);
    }
}
