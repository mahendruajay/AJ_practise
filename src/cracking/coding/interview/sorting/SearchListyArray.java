package cracking.coding.interview.sorting;

public class SearchListyArray {

    public static void main(String[] args) {

        SearchListyArray searchListyArray = new SearchListyArray();
        int[] input = {3, 4, 5, 8, 9, 10, 13, 15, 17, 18, 20, 21};
        Listy listy = new Listy(input);

        int[] searchNum = {3, 4, 5, 8, 9, 10, 13, 15, 17, 18};

//        for (int num : searchNum) {
//            int result = searchListyArray.search(listy, num);
//            System.out.println("Num is: " + num + " Result is :" + result);
//        }

        long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
        byte[] bitfield = new byte[(int) (numberOfInts / 8)];


        int result = searchListyArray.search(listy, 3);
        System.out.println("Num is: " + 18 + " Result is :" + result);


    }

    public int search(Listy listy, int x) {
        int index = 1;
        while (listy.elementAt(index) != -1 && listy.elementAt(index) < x) {
            index *= 2;
        }
        return binarySearch(listy, index / 2, index, x);
    }


    public int binarySearch(Listy listy, int start, int end, int x) {

        while (start <= end) {
            int mid = (start + end) / 2;
            int elementAtMiddle = listy.elementAt(mid);
            if (elementAtMiddle == x) {
                return mid;
            }
            if (x < elementAtMiddle || elementAtMiddle == -1) {
                end = mid - 1;
            } else if (x > elementAtMiddle) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
