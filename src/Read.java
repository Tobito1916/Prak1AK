import java.io.*;
public class Read {
    String readin() throws IOException {
        String thisLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader("chiffrat.txt"));
            while ((thisLine = br.readLine()) != null) { // while loop begins here
                System.out.println(thisLine);
            }
            return "none";
        }finally {
            return "";
        }
    }
}
