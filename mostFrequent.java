import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class mostFrequent extends ConsoleProgram {
    public void run() {
        println(mostFrequentChar("a1a1a1a1111"));
    }

    public char mostFrequentChar(String s) {
        int max = 0;
        char mostFrequent = s.charAt(0);
        for(int i = 0; i < s.length(); i++) {
            if(max < countChar(s, s.charAt(i))) {
                max = countChar(s, s.charAt(i));
                mostFrequent = s.charAt(i);
            }
        }
        return mostFrequent;
    }

    public int countChar(String str, char c) {
        int counter = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                counter++;
            }
        }
        return counter;
    }
}
