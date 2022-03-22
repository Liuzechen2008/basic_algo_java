

class IsUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("abc"));
        System.out.println(isUnique("aba"));
    }
    public static boolean isUnique(String astr) {
        int len = astr.length();
        if(len > 128){ return false;}
        boolean[] sameChars = new boolean[128];
        for(int i = 0; i < len;i++){
            if(sameChars[astr.charAt(i)]){
                return false;
            } else{
                sameChars[astr.charAt(i)] = true;
            }
        }
        return true;
    }
}