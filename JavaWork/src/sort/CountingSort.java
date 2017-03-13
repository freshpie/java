package sort;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		Counting counting = new Counting();
		int[] arr1 = new int[]{10,7,8,5,3,1};
		int[] arr2 = new int[]{1,3,5,8,7,10};
		int[] arr3 = new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] arr4 = new int[]{1,4,10,14,7,9,3,2,8,1};
		int[] arr5 = new int[]{9, 8, 6, 7, 2, 3, 1, 5, 4, 10};
		int[] arr6 = new int[]{2,5,3,0,2,3,0,3};
	
		System.out.println("==============================");
		//counting.genCountingArr(arr6);
		counting.countingSort(arr4);
		
	}

}

class Counting{
	public int[] genCountingArr(int[] arr){
		System.out.println(Arrays.toString(arr));
		int min = arr[0], max = arr[0];
		for(int num : arr){
			if(num < min){
				min = num;
			}
			if(num > max){
				max = num;
			}
		}
		
		int[] countingArr = new int[max+1];
		for(int i=0; i<countingArr.length;i++){
			countingArr[i]=0;
		}
		int accCnt = 0;
		for(int i=0; i<countingArr.length;i++){
			for(int j=0; j<arr.length;j++){
				if(i == arr[j]){
					accCnt++;
				}
				countingArr[i] = accCnt;
			}
		}
		System.out.println(Arrays.toString(countingArr));
		
		return countingArr;
	}

	public int[] countingSort(int[] arr) {
		int[] countingArr = genCountingArr(arr);
		int[] resultArr = new int[arr.length];
		for(int i=arr.length-1; i >= 0; i--){
			resultArr[countingArr[arr[i]]-1] = arr[i];//arr[i]가 위치할 자리
			countingArr[arr[i]] = countingArr[arr[i]]-1;
		}
		System.out.println(Arrays.toString(resultArr));
		
		return resultArr;
	}
}
