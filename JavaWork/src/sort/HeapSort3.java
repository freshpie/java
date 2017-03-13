package sort;

import java.util.Arrays;
//max heap을 가지고 정렬하기
public class HeapSort3 {

	public static void main(String[] args) {
		Heap3 heap = new Heap3();

		int[] arr = new int[]{10,7,8,5,3,1};
		int[] arr2 = new int[]{1,3,5,8,7,10};
		
		
		int[] arr4 = new int[]{1,4,10,14,7,9,3,2,8,1};
		int[] arr3 = new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] arr5 = new int[]{9, 8, 6, 7, 2, 3, 1, 5, 4, 10};
		
		System.out.println("==============================");
		System.out.println(Arrays.toString(arr5));
		System.out.println("-------------------------------");
		System.out.println(Arrays.toString(heap.heapSort(arr5)));
	}
}
class Heap3{
	public int heapDepth(int[] arr) {
		return (int)Math.floor(Math.log(arr.length) / Math.log(2));
	}
	public int[] heapSort(int[] arr){
		int temp =0;
		int listLength = arr.length;
		for(int i=listLength -1; i > 0; i--){
			System.out.println("input : " + Arrays.toString(arr));
			arr = bulidHeap(arr, listLength);
			System.out.println("max heap : " + Arrays.toString(arr));
			temp = arr[0];
			arr[0] = arr[listLength-1];
			arr[listLength-1] = temp;
			listLength--;
			System.out.println("exchange : " + Arrays.toString(arr));
			System.out.println("");
		}
		
		return arr;
	}
	public int[] bulidHeap(int[] arr, int listLength){
		for(int i=listLength/2 -1; i >= 0; i--){
			maxHeap(arr, i, listLength);
		}
		return arr;
	}
	public int[] maxHeap(int[] arr, int i, int listLength){
		int nextIndex = i;
		while(!noChild(arr, nextIndex, listLength)){
			//마지막 부모 노드 부터 위로 올라가면서 확인
			//마지막 부모 노드 부터 시작하므로 자식 노드가 없는 경우는 제외
			if(2*nextIndex+1 <= listLength-1 && 2*nextIndex+2 <= listLength-1){	
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
			}else if(2*nextIndex+1 <= listLength-1 && 2*nextIndex+2 > listLength-1){
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
	public boolean noChild(int[] arr,int i, int listLength){
		if(2*i+1 <= listLength-1 && 2*i+2 <= listLength-1){
			return false;
		}else if(2*i+1 <= listLength-1 && 2*i+2 > listLength-1){
			return false;
		}else{
			return true;
		}
	}
}
