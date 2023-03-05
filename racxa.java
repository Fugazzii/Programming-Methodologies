import acm.program.ConsoleProgram;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class racxa extends ConsoleProgram {
    public void run() {
        println(getWord(new StringTokenizer("oe bichoo chemi kai")));
    }

    private String getWord(StringTokenizer text) {
        String longest = "";
        while(text.hasMoreTokens()) {
            String w = text.nextToken();
            if(w.length() > longest.length() && isUniqueString(w)) {
                longest = w;
            }
        }
        return longest;
    }

    private boolean isUniqueString(String str) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(
                    !result.toString().contains(str.charAt(i) + "")
                    || str.charAt(i) == ' '
            ) {
                result.append(str.charAt(i));
            }
        }
        return result.toString().equals(str);
    }
}
