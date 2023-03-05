import acm.program.ConsoleProgram;

import java.util.*;

public class mamashviloba extends ConsoleProgram {
    public void run() {
        boolean isIt = inheritance("OB", "OBO");
        println(isIt);

        println("ilia".substring(0,1));
    }

    // C(0-0) CG(0-1) CGA(0-2) CGAT(0-str.length()) | G(1-1) GA(1-2) GAT(1-str.length()) | A(2-2) AT(2,str.length())
    public boolean inheritance(String str1, String str2) {
        String max = "";
        for(int i = 0; i < str1.length(); i++) {
            for(int j = i + 1; j < str1.length() + 1; j++) {
                String pirveli = str1.substring(i,j);
                if(str2.contains(pirveli) && pirveli.length() > max.length()) {
                    max = pirveli;
                }
            }
        }
        println(max);
        return max.length() > str2.length() / 2;
    }
}
