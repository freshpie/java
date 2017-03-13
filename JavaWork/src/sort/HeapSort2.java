package sort;

import java.util.Arrays;
//max heap 만들기
public class HeapSort2 {

	public static void main(String[] args) {
		Heap2 heap = new Heap2();
		/*
			  10
		  7		  8
		5	3	1	
		 */
		int[] arr = new int[]{10,7,8,5,3,1};
		int[] arr2 = new int[]{1,3,5,8,7,10};
		
		
		int[] arr4 = new int[]{1,4,10,14,7,9,3,2,8,1};
		int[] arr3 = new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] arr5 = new int[]{9, 8, 6, 7, 2, 3, 1, 5, 4, 10};
		
		System.out.println("==============================");
		System.out.println(Arrays.toString(arr5));
		System.out.println(Arrays.toString(heap.maxHeapify(arr5)));
	}

}

class Heap2{
	public int heapDepth(int[] arr) {
		return (int)Math.floor(Math.log(arr.length) / Math.log(2));
	}
	public int[] maxHeapify(int[] arr){
		for(int i=arr.length/2 -1; i >= 0; i--){
			buildHeap(arr, i);
		}
		return arr;
	}
	public int[] buildHeap(int[] arr, int i){
		int nextIndex = i;
		while(!noChild(arr, nextIndex)){
			//마지막 부모 노드 부터 위로 올라가면서 확인
			//마지막 부모 노드 부터 시작하므로 자식 노드가 없는 경우는 제외
			if(2*nextIndex+1 <= arr.length-1 && 2*nextIndex+2 <= arr.length-1){	
				//모든 자식 노드가 있고..
				if(arr[nextIndex] < arr[2*nextIndex+1] || arr[nextIndex] < arr[2*nextIndex+2]){
					//부모가 두 자식 노드 보다 작으면 두 자식 노드 중 더큰값을 부모와 교체 
					if(arr[2*nextIndex+1] > arr[2*nextIndex+2]){
						int temp = arr[nextIndex];
						arr[nextIndex] = arr[2*nextIndex+1];
						arr[2*nextIndex+1] = temp;
						nextIndex = 2*nextIndex+1;	// "left";
					}else{
						int temp = arr[nextIndex];
						arr[nextIndex] = arr[2*nextIndex+2];
						arr[2*nextIndex+2] = temp;
						nextIndex = 2*i+2;	//"right";
					}
				}else{
					break;
				}
			}else if(2*nextIndex+1 <= arr.length-1 && 2*nextIndex+2 > arr.length-1){
				//왼쪽자식노드만 있고..
				if(arr[nextIndex] < arr[2*nextIndex+1]){
					//자식노드의 값이 더 크면 부모와 교체..
					int temp = arr[nextIndex];
					arr[nextIndex] = arr[2*nextIndex+1];
					arr[2*nextIndex+1] = temp;
					nextIndex = 2*nextIndex+1;
				}else{
					break;
				}
				//return null;
			}
		}
		return arr;
	}
	public boolean noChild(int[] arr,int i){
		if(2*i+1 <= arr.length-1 && 2*i+2 <= arr.length-1){
			return false;
		}else if(2*i+1 <= arr.length-1 && 2*i+2 > arr.length-1){
			return false;
		}else{
			return true;
		}
	}
}
