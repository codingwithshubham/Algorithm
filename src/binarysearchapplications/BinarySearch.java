package binarysearchapplications;
import java.util.*;

public class BinarySearch {

	public static void main(String[] args) {
		int[]  arr = {1,5,7,9,34,67,98,968};
		
		int num = 968;  //num to search 
		
		System.out.println(recursiveBinarySearch(arr, 0, arr.length-1, num));
		
		System.out.println(binarySearch(arr, 0, arr.length-1, num));
	}
	
	static int recursiveBinarySearch(int[] arr, int low, int high, int element) {
		
		int mid = (low+high)/2;
		
		if(low>high)
			return -1;
		
		if(arr[mid] == element)
			return mid;
		else if(element > arr[mid])
			return recursiveBinarySearch(arr, mid+1, high, element);
		else
			return recursiveBinarySearch(arr, low, mid-1, element);
	}
	
	
	static int binarySearch(int[] arr, int low, int high, int element) {
		
		while(low <= high) {
			
			int mid = (low + high)/2;
			
			if(element < arr[mid])
				high = mid-1;
			else if(element > arr[mid])
				low = mid+1;
			else
				return mid;		
		}
		
			return -1;
	}
	

}
