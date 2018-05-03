import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Decipher {

    // Relative Häufigkeit der Buchstaben im Input-Text (Großbuchstaben A-Z)

    public HashMap<Character, Double> relativeFrequency (String input) {
        int total = 1;  //Gesamtanzahl der Buchstaben
        char[] inputArray = input.toCharArray();
        double[] count = new double[26];
        HashMap<Character, Double> countMap = new HashMap<>();

        for ( char c : inputArray ) if ( c <= 90 && c >= 65) total++;
        for (char c : inputArray ) if ( c <= 90 && c >= 65) count[c-65] ++;
        for ( int i = 0; i < 26; i++ ) countMap.put((char)(i + 'A'), (count[i] / total));

        return countMap;
    }


    public Map sortedFrequency (HashMap<Character, Double> frequency) {
        return SortHashMap.sortByValue(frequency);
    }

    public String replaceLetters (String input, char[] oldLetters, char[] newLetters){
        char[] inputArray = input.toCharArray();


        for(int i = 0; i<inputArray.length; i++){

            if ( inputArray[i] <= 90 && inputArray[i] >= 65) {
                for(int y = 0; y<oldLetters.length; y++){
                    if(inputArray[i] == oldLetters[y]){
                        //System.out.println("Tausche an der Stelle "+i+" Buchstabe "+oldLetters[y]+" mit "+ newLetters[y]);
                        inputArray[i] = newLetters[y];
                        break;
                    }
                }
            }
        }
        String deciphered = "";

        for(char c : inputArray) deciphered += c;

        return deciphered;
    }

    public static void main ( String[] args) throws IOException {

        //double [] letterFrequency = {6.51, 1.89, 3.06, 5.08, 17.4, 1.66, 3.01, 4.76, 7.55, 0.27, 1.21, 3.44, 2.53, 9.78, 2.51, 0.79, 0.02, 7, 7.27, 6.15, 4.35, 0.67, 1.89, 0.03, }

       //orginal char[] letterFrequency = {'E', 'N', 'I', 'S', 'R', 'A', 'T', 'D', 'H', 'U', 'L', 'C', 'G', 'M', 'O', 'B', 'W', 'F', 'K', 'Z', 'P', 'V', 'J', 'Y', 'X', 'Q'};
        char[] letterFrequency = {'E', 'N', 'S', 'R', 'I', 'A', 'D', 'T', 'H', 'U', 'L', 'G', 'O', 'C', 'M', 'B', 'F', 'W', 'K', 'Z', 'P', 'V', 'J', 'Y', 'X', 'Q'};

        Decipher d = new Decipher();
        Read in = new Read();
        String input = in.readin();
        HashMap<Character, Double> hmap = d.relativeFrequency(input);

        System.out.println(hmap);
        Map sortedHMap = d.sortedFrequency(hmap);
        System.out.println(sortedHMap);

        Set<Character> keys = sortedHMap.keySet();
        Character[] keyArray = keys.toArray(new Character[keys.size()]);

        char[] array = new char[keyArray.length];
        for(int i = 0; i< array.length; i++) array[i] = keyArray[i].charValue();

        System.out.println(input);

        for(char c : array) System.out.print(c + ", ");
        System.out.println("");

        for(char c : letterFrequency) System.out.print(c + ", ");
        System.out.println("");


        System.out.println(d.replaceLetters(input, array, letterFrequency));
    }


}
