package daily.challenge.april2024;

public class isomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sToTMapping = new char[128];
        char[] tToSMapping = new char[128];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (sToTMapping[charS] == 0 && tToSMapping[charT] == 0) {
                sToTMapping[charS] = charT;
                tToSMapping[charT] = charS;
            } else if (sToTMapping[charS] != charT || tToSMapping[charT] != charS) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo","baa"));
    }
}
