package uplevel.sorting;

/*

Group the numbers

You are given an integer array arr of size n.
Group and rearrange them (in-place) into evens and odds in such a way that group
of all even integers appears on the left side and group of all odd integers appears on the right side.


Example

Input: [1, 2, 3, 4]
Output: [4, 2, 1, 3]

Order does not matter. Other valid solutions are:

[2, 4, 1, 3]
[2, 4, 3, 1]
[4, 2, 3, 1]

Constraints:

    1 <= n <= 10^5
    arr contains only positive integers.
    arr may contain duplicate numbers.
    Solution with linear time complexity and constant auxiliary space is expected.

 */

public class GroupNumbers {

    public static void main(String args[]){
        int[] arr = {1,2,3,4};
        int[] res = solve(arr);
    }

    /*
     * Complete the function below.
     */
    static int[] solve(int[] arr) {

        int i = 0;
        int j = arr.length-1;
        while (i<j)
        {
            if (arr[i]%2 !=0 && arr[j]%2 == 0)
            {
                swap(arr,i,j);
                i++;
                j--;
            }
            if (arr[i]%2 == 0)
            {
                i++;
            }
            if (arr[j]%2 != 0)
            {
                j--;
            }
        }

        for(int val: arr)
        {
            System.out.println(val);
        }

        return arr;

    }

    static void swap(int[] arr, int first_index, int second_index)
    {
        int temp = arr[first_index];
        arr[first_index] = arr[second_index];
        arr[second_index] = temp;
    }
}
