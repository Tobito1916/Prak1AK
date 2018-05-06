public class DecipherUtil {
    public static void main(String[]args){

        String input = Read.readin();

        //Original char[] letterFrequency = {'E', 'N', 'I', 'S', 'R', 'A', 'T', 'D', 'H', 'U', 'L', 'C', 'G', 'M', 'O', 'B', 'W', 'F', 'K', 'Z', 'P', 'V', 'J', 'Y', 'X', 'Q'};
        char[] letterFrequency = {'E', 'N', 'S', 'R', 'I', 'A', 'D', 'T', 'H', 'U', 'L', 'G', 'O', 'C', 'M', 'K', 'F', 'B', 'W', 'Z', 'P', 'V', 'J', 'Y', 'X', 'Q'};

        System.out.println(decipherSubstitution(input, letterFrequency));

    }

    public static String decipherSubstitution (String cipherText, char[] letterFrequency){

        int[] countLetters = new int[26];
        char[] letterOrder = new char[26];
        char[] cipherTextArray = cipherText.toCharArray();

        // Buchstaben zählen

        for(int i=0; i<26; i++) countLetters[i] = 0;
        for(int i=0; i<26; i++) letterOrder[i] = (char)('A' + i);   // Alphabet sortiert speichern
        for(char c : cipherTextArray) if(c<=90 && c>=65) {
            countLetters[c-65]++;  // Buchstabenhäufigkeit zählen
        }

        // Buchstaben sortieren

        int[] sorted = sortWithLetters(countLetters, letterOrder);  //Buchstabenhäufigkeit parallel mit Alphabet sortieren

        // Buchstaben ersetzen

        for(int i = 0; i<cipherTextArray.length; i++){
            if ( cipherTextArray[i] <= 90 && cipherTextArray[i] >= 65) {
                for(int y = sorted.length-1; y>=0; y--){
                    if(cipherTextArray[i] == letterOrder[y]){
                        cipherTextArray[i] = letterFrequency[y];
                        break;
                    }
                }
            }
        }
        String deciphered = "";
        for(char c : cipherTextArray) deciphered += c;
        return deciphered;
    }

    private static int[] sortWithLetters(int[] arr, char[] letters){
        int[] sorted = arr.clone();
        quickSortWithLetters(sorted, 0, sorted.length-1, letters);

        // Array umdrehen zu max->min
        for(int i = 0; i < sorted.length / 2; i++) {
            int tmp;
            tmp = sorted[i];
            sorted[i] = sorted[25-i];
            sorted[25-i] = tmp;
            char tmpC;
            tmpC = letters[i];
            letters[i] = letters[25-i];
            letters[25-i] = tmpC;
        }
        return sorted;
    }

    private static void quickSortWithLetters(int[] arr, int low, int high, char[] letters) {
        if (arr == null || arr.length == 0) return;
        if (low >= high) return;
        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                char tempC = letters[i];
                letters[i] = letters[j];
                letters[j] = tempC;
                i++;
                j--;
            }
        }
        // recursively sort two sub parts
        if (low < j) quickSortWithLetters(arr, low, j, letters);
        if (high > i) quickSortWithLetters(arr, i, high, letters);
    }
}
