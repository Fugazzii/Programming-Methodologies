import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class spellworld extends ConsoleProgram{
    public void run() {
        println(spellWord("luka xarbedia", "xarbe"));
        println(spellWord("aaa", "a"));
    }

    public boolean spellWord(String str1, String str2) {
        for(int i = 0; i < str2.length(); i++) {
            if(countChar(str1, str2.charAt(i)) < countChar(str2, str2.charAt(i))  ) {
                return false;
            }
        }
        return true;
    }

    public int countChar(String s, char c) {
        int counter = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                counter++;
            }
        }
        return counter;
    }
}
