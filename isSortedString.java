import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class isSortedString extends ConsoleProgram{
    public void run() {
//        println(isSortedStr("a bcAAA!"));
//        println(isSortedStr("ABCDz,a"));
        println(filterString("i have A pEN."));
    }

    // This is other problem
    public String filterString(String str) {
        StringBuilder result = new StringBuilder((str.charAt(0) + "").toUpperCase());
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                result.append(" ").append((str.charAt(i + 1) + "").toUpperCase());
                i++;
            } else {
                result.append((str.charAt(i) + "").toLowerCase());
            }
        }
        return result.toString();
    }

    public boolean isSortedStr(String str) {
        str = onlyLowerCases(str);
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) > str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public String onlyLowerCases(String str) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
