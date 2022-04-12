/**
 * Write a method to find the location of a given string.
 * Return -1 if s is not in words.
 *
 * @author Zechen Liu
 * @date 2022/04/12
 **/
public class FindString {
    public static void main(String[] args) {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(findString(words, "ball"));
        System.out.println(findString(words, "ta"));
    }

    private static int findString(String[] words, String s) {
        int len = words.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (words[mid].isEmpty()) {
                if (words[r].compareTo(s) == 0) {
                    return r;
                } else {
                    r--;
                }
                continue;
            }

            if (words[mid].compareTo(s) == 0) {
                return mid;
            }

            if (words[mid].compareTo(s) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
