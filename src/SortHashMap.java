import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class SortHashMap {
    public static Map sortByValue(Map unsortedMap) {
        Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 10);
        map.put("b", 30);
        map.put("c", 50);
        map.put("d", 40);
        map.put("e", 20);
        System.out.println(map);

        Map sortedMap = sortByValue(map);
        System.out.println(sortedMap);
    }
}
