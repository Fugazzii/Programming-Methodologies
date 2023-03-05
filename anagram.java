import acm.program.ConsoleProgram;

public class anagram extends ConsoleProgram {
    public void run() {
        println(isAnagram("bijo", "jibo"));
    }

    public boolean isAnagram(String str1, String str2) {
        for(int i = 0; i < str1.length(); i++) {
            if(countChar(str1, str1.charAt(i)) != countChar(str2, str1.charAt(i))) {
                return false;
            }
        }
        return true;
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
