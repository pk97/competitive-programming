package daily.challenge.april2024;

import java.util.ArrayList;
import java.util.List;

public class FindLengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] x = s.split(" ");
        return x[x.length-1].length();
    }

    public static void main(String[] args) {
    lengthOfLastWord("sdfdsfds sdfs dfdsg sdfds  ");

    }
}
