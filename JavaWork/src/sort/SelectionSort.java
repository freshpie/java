package sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[]{5,2,4,1,3,6};
		System.out.println(Arrays.toString(arr));
		
		SortClass sortClass = new SortClass();
		int[] resultArr = sortClass.sort(arr, arr.length);
		
		System.out.println(Arrays.toString(resultArr));
		
		System.out.println("=======================================");
		
		int[] arr2 = new int[]{9,2,4,1,1,3,1};
		System.out.println(Arrays.toString(arr2));
		
		for(int i=0; i<arr2.length; i++){
			//최소값 구하기
			int tempMin = arr2[i]; 
			int minIndex = i;
			for(int j=i; j < arr2.length; j++){
				if(arr2[j] < tempMin){
					tempMin = arr2[j];
					minIndex = j;
				}
			}
			int temp = arr2[i];
			arr2[i] = arr2[minIndex];
			arr2[minIndex] = temp;
		}
		System.out.println(Arrays.toString(arr2));
	}
}

class SortClass{
	public int[] sort(int[] arr, int length){
		if(length != 0){
			int tempMin = arr[arr.length - length];	//시작 인덱스 값을 저장 
			int minIndex = arr.length - length;
			//최소값 구하기(값과 인덱스)
			for(int i=arr.length - length; i < arr.length; i++){
				if(arr[i] < tempMin){
					tempMin = arr[i];
					minIndex = i;
				}
			}
			//배열의 맨 앞자리와 교환
			int temp = arr[arr.length - length];
			arr[arr.length - length] = arr[minIndex];
			arr[minIndex] = temp;
			sort(arr, length -1);
		}
		return arr;
	}
}
