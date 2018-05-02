public class Decipher {

    // Absolute Häufigkeit der Buchstaben im Input-Text (Großbuchstaben A-Z)

    public int[] absoluteFrequency (String input) {
        int[] count = new int[26];
        char[] inputArray = input.toCharArray();

        for ( int i = 0; i < count.length; i++ ){
            count[i] = 0;
        }

        for (char c : inputArray ) {
            if ( c <= 90 && c >= 65) count[c-65] ++;
        }

        return count;
    }

    // Relative Häufigkeit der Buchstaben im Input-Text (Großbuchstaben A-Z)

    public double[] relativeFrequency (String input) {
        int total = 0;  //Gesamtanzahl der Buchstaben
        double[] count = new double[26];
        char[] inputArray = input.toCharArray();

        for ( char c : inputArray ){
            if ( c <= 90 && c >= 65) total++;
        }

        for ( int i = 0; i < count.length; i++ ){
            count[i] = 0;
        }

        for (char c : inputArray ) {
            if ( c <= 90 && c >= 65) count[c-65] ++;
        }

        System.out.println(total);

        for ( int i = 0; i < count.length; i++ ){
            if (total != 0) count[i] /= total;
        }

        return count;
    }

    /* Test

    public static void main ( String[] args){
        Decipher d = new Decipher();

        double[] count = d.relativeFrequency("ABCDEFGHIJ KLMNOP QRSTUV XY, ZZZZZ.");

        for ( double x : count ) {
            System.out.println(x);
        }

    }

    */
}
