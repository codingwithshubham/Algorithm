package binarysearchapplications;

import java.util.Collections;

public class CielAndFloor {

	public static void main(String[] args) {
		int[]  arr = {1,5,7,9,34,67,98,968};
		
		int num = 10;
		
		int low = 0;
		int high = arr.length-1;
		
		int ceil = -1;
		int floor = -1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			
			if(num > arr[mid]) {
				floor = arr[mid];
				low = mid+1;
			}
			else if(num < arr[mid]) {
				ceil = arr[mid];
				high = mid-1;
			}
			else {
				ceil = floor = arr[mid];
				break;
			}
		}
		System.out.println("ceil : "+ceil+" floor :"+floor);			
	}

}


