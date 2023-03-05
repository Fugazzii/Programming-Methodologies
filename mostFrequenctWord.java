import acm.program.ConsoleProgram;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class mostFrequenctWord extends ConsoleProgram {
    public void run() {
        StringTokenizer userString = new StringTokenizer("a b d f d a a a a a d d");
        String[] str = new String[userString.toString().length()];
        int i = 0;
        while(userString.hasMoreTokens()) {
            str[i] = userString.nextToken();
            i++;
        }
        String mafia = mostFreq(str);
        println(mafia);
    }

    public String mostFreq(String[] str) {
        HashMap<String, String> words = new HashMap<String, String>();

        int counter = 1;
        for(int i = 0; i < str.length && str[i] != null; i++) {
            for(int j = i; j < str.length && str[j] != null; j++) {
                if(str[i].equals(str[j])) {
                    counter++;
                }

                if(words.get(str[i]) == null) {
                    words.put(str[i], counter + "");
                }

                if(j == str.length - 1) {
                    counter = 1;
                }
            }
        }

        words.forEach((key, value) -> println(key + " : " + value));


        int max = 0;
        for(String value: words.values()) {
            if(max < Integer.parseInt(value)) {
                max = Integer.parseInt(value);
            }
        }

        for(Map.Entry<String, String> entry: words.entrySet()) {
            if(entry.getValue().equals(max + "")) {
                return entry.getKey();
            }
        }
        return "";
    }
}
