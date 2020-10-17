package binarysearchapplications;

public class FrequencyOfElement {

	public static void main(String[] args) {
		int[]  arr = { 3,3,3,3,4,12,12};
		
		int num = 12;
		
		int low = 0;
		int high = arr.length-1;
		
		int lowIndex = -1; int highIndex = -1;
		
		//forlowerBound
		while(low<=high) {
			
			int mid = (low+high)/2;
			
			if(num == arr[mid]) {
				lowIndex = mid;
				high = mid-1;
			}
			else if(num < arr[mid])
				high = mid-1;
			else
				low = mid+1;
		}
		
		low = 0;
		high = arr.length-1;
		
		//forhigher bound
		while(low<=high) {
			
			int mid = (low+high)/2;
			
			if(num == arr[mid]) {
				highIndex = mid;
				low = mid+1;
			}
			else if(num < arr[mid])
				high = mid-1;
			else
				low = mid+1;
		}
		
		if(lowIndex == -1)
			System.out.println(0);
		else
			System.out.println(highIndex-lowIndex+1);

	}

}
