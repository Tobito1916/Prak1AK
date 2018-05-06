import java.io.*;
public class Read {
   public static String readin() {
       String text = "";
       try {
           BufferedReader br = new BufferedReader(new FileReader("src/chiffrat.txt"));
           // while loop begins here
           while (br.ready()) text += br.readLine();
       } catch (IOException e) {
           System.out.println("Error");//f
       }
       return text;
   }
}
