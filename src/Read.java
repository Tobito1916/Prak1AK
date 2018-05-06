import java.io.*;
public class Read {
   public static String readin() {
       String text = "";
       try {
           BufferedReader br = new BufferedReader(new FileReader("src/chiffrat.txt"));
           while (br.ready()) { // while loop begins here
               text += br.readLine();

           }

       } catch (IOException e) {
           System.out.println("Error");//f
       }
       return text;
   }


}
