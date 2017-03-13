package sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = new int[]{4,1,5,2,1,1,7,8};
		System.out.println(Arrays.toString(arr));
		
		for(int i=1;i<arr.length;i++){
			int key = arr[i];
			for(int j=i-1; j >= 0; j--){
				if(arr[j] > key){
					arr[j+1] = arr[j];
					arr[j] = key;					
				}else{
					break;
				}
			}
			
			System.out.println(Arrays.toString(arr));
		}
		
		//System.out.println(Arrays.toString(arr));

	}

}
