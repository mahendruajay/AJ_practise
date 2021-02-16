package cracking.coding.interview.recursion_dynamic;

import java.util.Comparator;

public class BoxBaseAreaComparator implements Comparator<Box> {


    @Override
    public int compare(Box box1, Box box2) {
        Integer box1BaseArea = box1.getLength() * box1.getWidth();
        Integer box2BaseArea = box2.getLength() * box2.getWidth();

        return box2BaseArea.compareTo(box1BaseArea);
    }
}
