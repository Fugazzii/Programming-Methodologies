import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class nplet extends ConsoleProgram {
    public void run() {
        println(removeNplet("nikaaaaaadadddd", 4));
    }
    public String removeNplet(String text, int n) {
        while(getLastIndex(text, n) != -1) {
            text = removeNpletOnce(text, n);
        }
        return text;
    }
    public String removeNpletOnce(String text, int n) {
        String str = "";
        if(getLastIndex(text, n) == -1) {
            return text;
        } else {
            str += text.substring(0, getLastIndex(text, n) - n + 1);
            str += text.substring(getLastIndex(text, n) + 1);
            return str;
        }
    }

    // gio
    // aXXZa4
    public int getLastIndex(String str, int n) {
        int counter = 1;
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                counter++;
            } else {
                counter = 1;
            }

            if(counter == n) {
                return i + 1;
            }
        }
        return -1;
    }

}