package SelfDevelopment;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class UseEntrySet {
    public static void main(String[] args) {
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(34,"윤창호");
        scores.put(74,"윤종호");
        scores.put(54,"윤지경");
        scores.put(94,"윤지욱");
        System.out.println(scores);

        NavigableMap<Integer,String> descendingMap = scores.descendingMap();
        Set<Map.Entry<Integer,String>> descendingEntrySet = descendingMap.entrySet();
        for(Map.Entry<Integer,String> entry:descendingEntrySet){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }


    }
}
