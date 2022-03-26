
/**
 * You should first ask your interviewer if the string is an ASCII string or a Unicode string.
 * We'll assume for simplicity the character set is ASCII.
 * If this assumption is not valid, we would need to increase the storage size.
 *
 * @author Zechen Liu
 * @date 2022/03/22
 **/
class IsUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("abc"));
        System.out.println(isUnique("aba"));
    }

    public static boolean isUnique(String astr) {
        int len = astr.length();
        if (len > 128) {
            return false;
        }
        boolean[] sameChars = new boolean[128];
        for (int i = 0; i < len; i++) {
            if (sameChars[astr.charAt(i)]) {
                return false;
            } else {
                sameChars[astr.charAt(i)] = true;
            }
        }
        return true;
    }
}