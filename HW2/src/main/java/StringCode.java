public class StringCode {
    public static String blowup(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length()-1; ++i) {
            int num = -1;
            if(Character.isDigit(s.charAt(i)) == true) {
                num = Character.getNumericValue(s.charAt(i));
            } else {
                ans.append(s.charAt(i));
            }
            if(num != -1) {
                for(int j = 0; j < num; ++j) {
                    ans.append(s.charAt(i+1));
                }
            }
        }
        if(s.length() > 0 && Character.isDigit(s.charAt(s.length()-1)) == false) {
            ans.append(s.charAt(s.length()-1));
        }
        return ans.toString();
    }

    public static int maxRun(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int len = 1;
        int ans = 1;
        for(int i = 0; i < s.length()-1; ++i) {
            if(s.charAt(i) != s.charAt(i+1)) {
                ans = Math.max(ans, len);
                len = 1;
            } else {
                len += 1;
            }
        }
        return Math.max(ans, len);
    }

    public static boolean stringIntersect(String s1, String s2, int len) {
        for(int i = 0; i < s1.length() - len + 1 && i < s2.length() - len + 1; ++i) {
            if(s2.contains(s1.substring(i, i + len))) {
                return true;
            }
        }
        return false;
    }
}
