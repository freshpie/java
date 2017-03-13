package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[]{4,1,5,2,1,1,7,8};
		int[] arr2 = new int[1000];
		
		Random rand=new Random();
		for(int i=0; i<arr2.length;i++){
			arr2[i]=rand.nextInt(10000);
		}
		

		System.out.println(Arrays.toString(arr2));
		System.out.println("================================");
		System.out.println(Arrays.toString(Bubble.sort(arr2)));
	}
}

class Bubble{
	public static int[] sort(int[] arr){
		int i = 0, j = 0, temp = 0, length = arr.length;

		for(i=0;i<length-1;i++){
			for (j = 0; j < length - (i + 1); j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
	}
}