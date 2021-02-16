package cracking.coding.interview.sorting;

public class RotatedArraySearch {

    public static void main(String[] args) {

        RotatedArraySearch rotatedArraySearch = new RotatedArraySearch();
//        int[] input = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
//        int[] numToSearch = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14, 28, -1};

        int[] input = {2, 1, 2, 2, 2, 2};
        int[] numToSearch = {2, 3, 4, 1};

        for (int num : numToSearch) {
            int result = rotatedArraySearch.search(input, 0, input.length - 1, num);
            System.out.println("Num is: " + num + " Result is: " + result);
        }


    }

    public int search(int[] arr, int left, int right, int x) {
        if (right < left) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (arr[mid] == x) {
            return mid;
        }

        if (arr[left] < arr[mid]) {
            if (x >= arr[left] && x <= arr[mid - 1]) {
                return search(arr, left, mid - 1, x);
            } else {
                return search(arr, mid + 1, right, x);
            }
        } else if (arr[mid] < arr[right]) {
            if (x >= arr[mid + 1] && x <= arr[right]) {
                return search(arr, mid + 1, right, x);
            } else {
                return search(arr, left, mid - 1, x);
            }

        } else if (arr[left] == arr[mid]) {
            if (arr[mid] != arr[right]) {
                return search(arr, mid + 1, right, x);
            } else {
                int result = search(arr, left, mid - 1, x);
                if (result == -1) {
                    return search(arr, mid + 1, right, x);
                } else {
                    return result;
                }
            }

        }
        return -1;

    }

}
