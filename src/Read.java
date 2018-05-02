import java.io.*;
public class Read {
    String readin(){
        try (BufferedReader in = new BufferedReader(new FileReader("chiffrat.txt"))) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "none";
    }
}
