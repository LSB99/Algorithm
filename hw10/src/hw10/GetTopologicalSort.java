package hw10;
import java.util.Scanner;
//***************************
//파일명: GetTopologicalSort.java
//작성자: 임수빈
//작성일: 2020년 6월 5일
//프로그램 설명: 위상 정렬결과, DFS 클래스
//***************************

public class GetTopologicalSort {
	private Node[] list;    // 인접리스트 배열을 가리킬 변수(list)
	private int numberOfVertices;  //  정점수(n) 
	
	// 리스트의 노드 구조를 정의한 클래스
	private class Node{   
		
		int vertex;  //  정점번호 필드(vertex)
		Node link;   //  다음 노드를 가리키는 필드(link)
		
		public Node(int vertex){  //Node 클래스 생성자
	        this.setVertex(vertex);  
	        setLink(null);
	    }
		
		public int getVertex() {   //  vertex 값 리턴
	    	return vertex;
	    }
	    public void setVertex(int vertex) {  // vertex 값 설정
	    	this.vertex = vertex;
	    }
	    
	    public Node getLink() {  // 연결 링크 노드리턴
	    	return link;
	    }
	    public void setLink(Node link) {  // 연결 링크 노드 설정
	    	this.link = link;
	    }
	    
	    public Node[] getList() {  // 인접리스트 리턴
	    	return list;
	    }
	}
	
	 // 정점수 n을 매개변수로 받아 정점 n개, 간선은 없는 초기 그래프를 생성
	public GetTopologicalSort(int n) { 
		list = new Node[n];  // n인 Node형 배열을 생성하여  list에 지정
		numberOfVertices = n;  // 정점수(n) 
		
		for(int i=0;i<numberOfVertices;i++) {   // 테이블을 비어있는 공간으로 설정
			list[i] = null;
		}
	}
	
	
	//두개의 정점 v1, v2를  매개변수로 받아 그래프에  간선 <v1, v2>를  추가
	public void addEdge(int v1, int v2) {  
		
		if(list[v1]==null) {  // 비어있으면 
			list[v1] = new Node(v2);  // list[v1]에  v2를 삽입
		}
		  
		else if(list[v1]!=null){  // 비어있지 않으면 
			
			Node x = list[v1];
			
			while(x.getLink()!=null) {  //그다음 노드가 비어있지 않다면
				x=x.getLink();   // 그다음 링크로 설정
			}
			
			 // 그 다음 노드가 비어 있으면
		     x.setLink(new Node(v2));   //  v2를 삽입 
		}
	}
	
	
	// 제대로 구현되었는지 확인하기 위해  그래프의 모든 정점의 인접 리스트를 모두 출력
	public void printAdjacencyList() {
		
		// 반복문을 이용하여 list[0],... list[numberOfVertices-1] 의  모든 정점번호를 출력
		
		for(int i=0; i<numberOfVertices; i++) {
			
			System.out.print("정점 "+i+"에 인접한 정점 = ");
			
			if(list[i]==null) {
				System.out.println();
				continue;
			}
			
			else if(list[i]!=null) {
				Node node = list[i];
				
				while(node!=null) {   // 인접 리스트로 구성된 노드 출력
					System.out.print(node.getVertex()+" ");
					node = node.getLink();
				}
			}
			
			System.out.println();
		}
	}
	

	boolean[] visited;  // DFS 수행 중 방문여부 체크 배열
	int[] R;   // 위상정렬 순서를 담을 배열
		
	public void topologicalSort2() {  //  DFS 이용한 위상정렬
		
		visited = new boolean[numberOfVertices];
		R = new int[numberOfVertices];
	
		//  모든 정점을  방문 안했다고 초기화
		for(int i=0;i<numberOfVertices;i++) {  
			visited[i] = false;
		}
		
		
		for(int i=0;i<numberOfVertices;i++) {
			
			if(visited[i]==false) {  // 해당 정점이 방문을 안했다면 
				DFS(i);   //  DFS 함수 호출
			}
		}
		
		 // 위상정렬 순서 출력
		for(int i=numberOfVertices-1;i>=0;i--) { 
			System.out.print(R[i]+" ");
		}
	}
	
	int index = 0;  // R 배열 인덱스
	
	public void DFS(int vertex) {   // 깊이 우선 탐색
		
		visited[vertex] = true;  //  해당 정점을 방문했다고 표시
	
		Node node = list[vertex];
		
		while(node!=null) {	// 인접한 정점이 있을 경우 

			int v = node.getVertex(); // 그 정점의 필드 대입

			if(visited[v]==false) {  // 해당 정점에  방문한 적이 없으면
				DFS(v);   // DFS 재귀호출
			}
			
			node = node.getLink(); // 해당 정점에 방문한 적이 있으면  연결된 다음 정점으로 넘어간다.	 
		}
		
		R[index] =  vertex;   // 방문한 정점  R배열에 대입
		index++;
	}
}
