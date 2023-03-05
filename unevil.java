import acm.program.*;

public class unevil extends ConsoleProgram {
    public void run() {
        String evil = "iliayybijo";
        println(unEvilText(evil));
    }

    public String unEvilText(String str) {
        while(isEvil(str)) {
            str = unEvilOnce(str);
        }
        return str;
    }

    public String unEvilOnce(String str) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                result.append(str.substring(0, i));
                result.append(str.substring(i + 2));
            }
        }
        return result.toString();
    }

    public boolean isEvil(String str) {
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

}
