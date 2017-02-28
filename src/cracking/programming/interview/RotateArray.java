package cracking.programming.interview;

public class RotateArray {

	
	public static void main(String [] args){
		
		int [] arr = {0,1,2,3,4};
		System.out.println("array is rotated = " + getRotationvalue(arr,0,arr.length-1) + " times");
		
		int[] arr1 = {4,0,1,2,3};
		System.out.println("array 1 is rotated = " + getRotationvalue(arr1,0,arr1.length-1) + " times");
		
		int[] arr2 = {3,4,0,1,2};
		System.out.println("array 2 is rotated = " + getRotationvalue(arr2,0,arr2.length-1) + " times");
		
		int[] arr3 = {2,3,4,0,1};
		System.out.println("array 3 is rotated = " + getRotationvalue(arr3,0,arr3.length-1) + " times");
		
		int[] arr4 = {1,2,3,4,0};
		System.out.println("array 4 is rotated = " + getRotationvalue(arr4,0,arr4.length-1) + " times");
		
		int[] arr5 = {0,1,2,3,4};
		System.out.println("array 5 is rotated = " + getRotationvalue(arr5,0,arr5.length-1) + " times");
		
		
		int[] arr6 = {7,12,13,1,2,3,4};
		System.out.println("array 6 is rotated = " + getRotationvalue(arr6,0,arr6.length-1) + " times");
		
		int[] arr7 = {7,12,0,0,2,3,4};
		System.out.println("array 7 is rotated = " + getRotationvalue(arr7,0,arr7.length-1) + " times");
		
	}
	
	public static int getRotationvalue(int[] arr, int start, int end){
		
		if(start< end){
			int mid = (start + end)/2;
			
			if(arr[start]<=arr[mid] && arr[mid+1] <= arr[end]){
				
				if(arr[mid]<arr[mid+1]){ //normal sorted array
					return 0;
				}
				
				return mid+1; //mid is exactly where the highest element is
					
			}
			else{
				
				if(arr[start]>arr[mid]){
					return getRotationvalue(arr,start,mid);
				}
				else if (arr[mid+1] > arr[end]){
					return getRotationvalue(arr,mid+1,end);					
				}
				
			}
		}
			return 0;
		
	}
}
