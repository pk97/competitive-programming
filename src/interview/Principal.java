package interview;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Principal {

    public static void main(String[] args) {
        // a,a
        // Find first non repeating character
        String paragraph = "caaacsafff";
        Map<Character, Integer> count = new TreeMap<>();


        for (int i = 0; i < paragraph.length(); i++) {
            char c =paragraph.charAt(i);
            count.put(c, count.getOrDefault(c, 0)+1);
        }
       count.forEach((k,v) -> {
           if (v == 1)
           {
               System.out.println("First Non repeating character is = "+k);
           }
       });
    }

//    private void f(String s, List<String> list, int i, StringBuilder cuurentString) {
//        if (s.length() == i) {
//            list.add(s);
//        }
//        cuurentString.append(s.charAt(i));
//        f(s,list,i+1, cuurentString);
//        cuurentString.deleteCharAt(cuurentString.length()-1);
//        f()
//    }
}
