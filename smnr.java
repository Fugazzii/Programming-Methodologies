import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class smnr extends ConsoleProgram {

    public void run() {
        BufferedReader file = openFile("./smnr.java");
        try {
            println(file.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedReader openFile(String fileName) {
        BufferedReader rd = null;
        while(rd == null) {
            try {
                rd = new BufferedReader(new FileReader(fileName));
            } catch(IOException err) {
                println(err);
                break;
            }
        }
        return rd;
    }

}
