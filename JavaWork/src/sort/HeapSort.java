package sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		Heap heap = new Heap();
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
		
		
		//System.out.println(heap.isMaxHeap(arr));
		//System.out.println(heap.isMaxHeap(arr2));
		//System.out.println(heap.isMaxHeap(arr3));
		//System.out.println(heap.isMaxHeap(arr4));
		//System.out.println(heap.isMaxHeap(arr5));
		//System.out.println(heap.isMinHeap(arr2));
	
		System.out.println("==============================");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(heap.maxHeapify(arr)));
		System.out.println("-------------------------------");
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(heap.maxHeapify(arr2)));
		System.out.println("-------------------------------");
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(heap.maxHeapify(arr3)));
		System.out.println("-------------------------------");
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(heap.maxHeapify(arr4)));
		System.out.println("-------------------------------");
		System.out.println(Arrays.toString(arr5));
		System.out.println(Arrays.toString(heap.maxHeapify(arr5)));
	}

}

class Heap{
	public int heapDepth(int[] arr) {
		return (int)Math.floor(Math.log(arr.length) / Math.log(2));
	}
	public int[] maxHeapify(int[] arr){
		while(!isMaxHeap(arr)){
			for(int i=0; i < heapDepth(arr)*2 +1; i++){
				if(2*i+1 <= arr.length-1 && 2*i+2 <= arr.length-1){	//모든 자식 노드가 있음..
					//System.out.println("arr["+i+"]: " + arr[i]+" | arr["+ ((2*i)+1) +"]: " + arr[2*i+1]+" | arr["+ ((2*i)+2) +"]: " + arr[2*i+2]);
					if(arr[i] < arr[2*i+1] || arr[i] < arr[2*i+2]){
						//조건에 부적합...여기서 최대 힙조건이 깨어지게 되므로 정렬을 시도한다.
						//정렬법은 자신의 좌우 자식 포함 3개 노드에서 최대값 ..이미 조건이 깨졌기 때문에 좌우중 더 큰 노드를 선택한다.
						if(arr[2*i+1] > arr[2*i+2]){
							int temp = arr[i];
							arr[i] = arr[2*i+1];
							arr[2*i+1] = temp;
						}else{
							int temp = arr[i];
							arr[i] = arr[2*i+2];
							arr[2*i+2] = temp;
						}
					}
				}else if(2*i+1 <= arr.length-1 && 2*i+2 > arr.length-1){//왼쪽자식노드만 있음.
					//System.out.println("arr["+i +"]: " + arr[i]+" | arr["+ ((2*i)+1) +"]: " + arr[2*i+1]);
					if(arr[i] < arr[2*i+1]){	//자식노드의 값이 더 크면 최대 힙이 아님.
						int temp = arr[i];
						arr[i] = arr[2*i+1];
						arr[2*i+1] = temp;
					}
				}else{	//자식노드가 없음.
					System.out.println("arr["+i +"] have no chile node");
				}
			}
		}
		return arr;
	}
	public boolean isMaxHeap(int[] arr){
		for(int i=0; i< heapDepth(arr)*2 +1; i++){
			if(2*i+1 <= arr.length-1 && 2*i+2 <= arr.length-1){	//모든 자식 노드가 있음..
				System.out.println("arr["+i+"]: " + arr[i]+" | arr["+ ((2*i)+1) +"]: " + arr[2*i+1]+" | arr["+ ((2*i)+2) +"]: " + arr[2*i+2]);
				if(arr[i] < arr[2*i+1] || arr[i] < arr[2*i+2]){
					return false;
				}
			}else if(2*i+1 <= arr.length-1 && 2*i+2 > arr.length-1){//왼쪽자식노드만 있음.
				System.out.println("arr["+i +"]: " + arr[i]+" | arr["+ ((2*i)+1) +"]: " + arr[2*i+1]);
				if(arr[i] < arr[2*i+1]){	//자식노드의 값이 더 크면 최대 힙이 아님.
					return false;
				}
			}else{	//자식노드가 없음.
				System.out.println("arr["+i +"] have no chile node");
			}
		}		
		return true;
	}
	public boolean isMinHeap(int[] arr){
		for(int i=0; i< arr.length; i++){
			if(2*i+1 < arr.length){
			//if(2*i+1 < arr.length && 2*i+2 < arr.length){
				if(arr[i] > arr[2*i+1] || arr[i] > arr[2*i+2]){
					return false;
				}
			}else{
				break;
			}
		}
		return true;
	} 
}
