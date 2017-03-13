package search;

import java.util.ArrayList;
import java.util.List;

class Node{
	int color;
	int[] link_up;
	int[] link_down;
	String name;
	String content;
}
public class DepthFirstSearch1 {
	static int[][] adjMatrix; 
	static int[] visit;
	
	public static void main(String[] args) {
		//COLOR	0 white, 1 grey, 2 black
		List<Node> nodeList = new ArrayList<Node>();
		
		Node node1 = new Node();
		node1.color = 0;
		node1.link_up = new int[0];
		node1.link_down = new int[]{2,3};
		node1.name = "1번";
		node1.content = "가나";
		nodeList.add(node1);
		
		Node node2 = new Node();
		node2.color = 0;
		node2.link_up = new int[]{1};
		node2.link_down = new int[]{4,5};
		node2.name = "2번";
		node2.content = "다라";
		nodeList.add(node2);
		
		Node node3 = new Node();
		node3.color = 0;
		node3.link_up = new int[]{1};
		node3.link_down = new int[]{6,7};
		node3.name = "3번";
		node3.content = "바마";
		nodeList.add(node3);
		
		Node node4 = new Node();
		node4.color = 0;
		node4.link_up = new int[]{2};
		node4.link_down = new int[]{8};
		node4.name = "4번";
		node4.content = "사아";
		nodeList.add(node4);
		
		Node node5 = new Node();
		node5.color = 0;
		node5.link_up = new int[]{2};
		node5.link_down = new int[]{8};
		node5.name = "5번";
		node5.content = "자카";
		nodeList.add(node5);
		
		Node node6 = new Node();
		node6.color = 0;
		node6.link_up = new int[]{3};
		node6.link_down = new int[]{8};
		node6.name = "6번";
		node6.content = "심심타파";
		nodeList.add(node6);
		
		Node node7 = new Node();
		node7.color = 0;
		node7.link_up = new int[]{3};
		node7.link_down = new int[]{8};
		node7.name = "7번";
		node7.content = "하하";
		nodeList.add(node7);
		
		Node node8 = new Node();
		node8.color = 0;
		node8.link_up = new int[]{4,5,6,7};
		node8.link_down = new int[0];
		node8.name = "8번";
		node8.content = "사라";
		nodeList.add(node8);
		
		//인접행렬 생성
		adjMatrix = genAdjMatrix(nodeList);
		//인접행렬 출력
		for(int i=0; i < adjMatrix.length; i++){
			for(int j=0; j < adjMatrix[i].length; j++){	
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println("");
		}
		visit = new int[nodeList.size()];
		DFS(nodeList, 0);
	}

	private static int[][] genAdjMatrix(List<Node> nodeList) {
		int nodeListSize = nodeList.size();
		int[][] matrix = new int[nodeListSize][nodeListSize];
		
		for(int i=0; i < nodeListSize; i++){
			for(int j=0; j < nodeListSize; j++){	
				matrix[i][j] = 0;
			}
		}
		
		for(int i=0; i < nodeListSize; i++){
			for(int j=0; j < nodeList.get(i).link_up.length; j++){				
				matrix[i][nodeList.get(i).link_up[j]-1] = 1;
			}
			for(int j=0; j < nodeList.get(i).link_down.length; j++){
				matrix[i][nodeList.get(i).link_down[j]-1] = 1;
			}
		}
		
		return matrix;
	}

	private static void DFS(List<Node> nodeList, int start) {
		visit[start] = 1;
		System.out.println(nodeList.get(start).name +"도착, '"+ nodeList.get(start).content +"'를 발견했다!!");
		for(int i=0; i<nodeList.size();i++){
			if(adjMatrix[start][i] == 1 && visit[i] == 0){
				System.out.println("-->" + nodeList.get(start).name + "에서 " + nodeList.get(i).name +"(으)로 이동");
				DFS(nodeList, i);
			}
		}
	}
}
