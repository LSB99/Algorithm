package hw10;
//***************************
//파일명: DirectedGraph.java
//작성자: 임수빈
//작성일: 2020년 6월 5일
//프로그램 설명: 방향그래프 인접리스트  클래스
//***************************

public class DirectedGraph {

	private Node[] list;    // 인접리스트 배열을 가리킬 변수(list)
	private int numberOfVertices;  //  정점수
	
	// 리스트의 노드 구조를 정의한 클래스
	private class Node{   
		
		int vertex;  //  정점번호 필드(vertex)
		Node link;   //  다음 노드를 가리키는 필드(link)
		
		public Node(int vertex){  // Node 클래스 생성자
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
	}
	
	 // 정점수 n을 매개변수로 받아 정점 n개, 간선은 없는 초기 그래프를 생성
	public DirectedGraph(int n) { 
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
			
			Node node = list[v1];
			
			while(node.getLink()!=null) {  //그다음 노드가 비어있지 않다면
				node=node.getLink();   // 그다음 링크로 설정
			}
			
			 // 그 다음 노드가 비어 있으면
			node.setLink(new Node(v2));   //  v2를 삽입 
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
				
}
