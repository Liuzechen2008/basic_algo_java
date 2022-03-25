/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a - z).
 *
 * @author liuzechen
 * @date 2022/03/25
 **/
public class CompressString {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abbccd"));
    }

    public static String compressString(String S) {
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < len) {
            char ch = S.charAt(index++);
            sb.append(ch);
            int cnt = 1;
            while(index < len){
                if(S.charAt(index) == ch){
                    cnt++;
                    index++;
                } else{
                    break;
                }
            }
            sb.append(cnt);
        }
        return sb.toString().length() < len ? sb.toString() : S;
    }

}
