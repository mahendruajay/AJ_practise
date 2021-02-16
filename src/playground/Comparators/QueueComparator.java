package playground.Comparators;

import java.util.Comparator;

public class QueueComparator implements Comparator<String> {

    public int compare(String string1, String string2) {
        return string2.compareTo(string1);
    }
}
