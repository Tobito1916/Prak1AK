import java.io.*;
public class Read {
   static String readin() throws IOException {
       String text = "";
       try {
           BufferedReader br = new BufferedReader(new FileReader("src/chiffrat.txt"));
           while (br.ready()) { // while loop begins here
               text = text + br.read();

           }

       } catch (IOException e) {
           System.out.println("Error");
       }
       return text;
   }

public static void main(String args[]) throws IOException {
       System.out.println(readin());
}
}
