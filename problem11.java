import acm.program.ConsoleProgram;

public class problem11 extends ConsoleProgram {
    public void run() {
        long x = 7;
        String xBinary = toBinary(x);
        String reversedBinary = reverseBits(xBinary);
        long xDecimal = toDecimal(reversedBinary);

        println(x);
        println(xBinary);
        println(reversedBinary);
        println(xDecimal);
    }

    public String toBinary(long binaryNum) {
        StringBuilder result = new StringBuilder();
        while(binaryNum != 0) {
            result.append(binaryNum % 2);
            binaryNum /= 2;
        }
        while((result + "").length() != 32) {
            result.append("0");
        }
        return reverseString(result.toString());
    }
    public String reverseString(String str) {
        StringBuilder res = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }
    public String reverseBits(String str) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                s.append('1');
            } else {
                s.append('0');
            }
        }
        return s.toString();
    }
    public long toDecimal(String str) {
        long result = 0;
        for(int i = 0; i < str.length(); i++) {
            result += str.charAt(i) * Math.pow(2, (str.length() - i - 1));
        }
        return result;
    }
}
