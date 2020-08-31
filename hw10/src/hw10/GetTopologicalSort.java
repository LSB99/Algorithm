package hw10;
import java.util.Scanner;
//***************************
//���ϸ�: GetTopologicalSort.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 6�� 5��
//���α׷� ����: ���� ���İ��, DFS Ŭ����
//***************************

public class GetTopologicalSort {
	private Node[] list;    // ��������Ʈ �迭�� ����ų ����(list)
	private int numberOfVertices;  //  ������(n) 
	
	// ����Ʈ�� ��� ������ ������ Ŭ����
	private class Node{   
		
		int vertex;  //  ������ȣ �ʵ�(vertex)
		Node link;   //  ���� ��带 ����Ű�� �ʵ�(link)
		
		public Node(int vertex){  //Node Ŭ���� ������
	        this.setVertex(vertex);  
	        setLink(null);
	    }
		
		public int getVertex() {   //  vertex �� ����
	    	return vertex;
	    }
	    public void setVertex(int vertex) {  // vertex �� ����
	    	this.vertex = vertex;
	    }
	    
	    public Node getLink() {  // ���� ��ũ ��帮��
	    	return link;
	    }
	    public void setLink(Node link) {  // ���� ��ũ ��� ����
	    	this.link = link;
	    }
	    
	    public Node[] getList() {  // ��������Ʈ ����
	    	return list;
	    }
	}
	
	 // ������ n�� �Ű������� �޾� ���� n��, ������ ���� �ʱ� �׷����� ����
	public GetTopologicalSort(int n) { 
		list = new Node[n];  // n�� Node�� �迭�� �����Ͽ�  list�� ����
		numberOfVertices = n;  // ������(n) 
		
		for(int i=0;i<numberOfVertices;i++) {   // ���̺��� ����ִ� �������� ����
			list[i] = null;
		}
	}
	
	
	//�ΰ��� ���� v1, v2��  �Ű������� �޾� �׷�����  ���� <v1, v2>��  �߰�
	public void addEdge(int v1, int v2) {  
		
		if(list[v1]==null) {  // ��������� 
			list[v1] = new Node(v2);  // list[v1]��  v2�� ����
		}
		  
		else if(list[v1]!=null){  // ������� ������ 
			
			Node x = list[v1];
			
			while(x.getLink()!=null) {  //�״��� ��尡 ������� �ʴٸ�
				x=x.getLink();   // �״��� ��ũ�� ����
			}
			
			 // �� ���� ��尡 ��� ������
		     x.setLink(new Node(v2));   //  v2�� ���� 
		}
	}
	
	
	// ����� �����Ǿ����� Ȯ���ϱ� ����  �׷����� ��� ������ ���� ����Ʈ�� ��� ���
	public void printAdjacencyList() {
		
		// �ݺ����� �̿��Ͽ� list[0],... list[numberOfVertices-1] ��  ��� ������ȣ�� ���
		
		for(int i=0; i<numberOfVertices; i++) {
			
			System.out.print("���� "+i+"�� ������ ���� = ");
			
			if(list[i]==null) {
				System.out.println();
				continue;
			}
			
			else if(list[i]!=null) {
				Node node = list[i];
				
				while(node!=null) {   // ���� ����Ʈ�� ������ ��� ���
					System.out.print(node.getVertex()+" ");
					node = node.getLink();
				}
			}
			
			System.out.println();
		}
	}
	

	boolean[] visited;  // DFS ���� �� �湮���� üũ �迭
	int[] R;   // �������� ������ ���� �迭
		
	public void topologicalSort2() {  //  DFS �̿��� ��������
		
		visited = new boolean[numberOfVertices];
		R = new int[numberOfVertices];
	
		//  ��� ������  �湮 ���ߴٰ� �ʱ�ȭ
		for(int i=0;i<numberOfVertices;i++) {  
			visited[i] = false;
		}
		
		
		for(int i=0;i<numberOfVertices;i++) {
			
			if(visited[i]==false) {  // �ش� ������ �湮�� ���ߴٸ� 
				DFS(i);   //  DFS �Լ� ȣ��
			}
		}
		
		 // �������� ���� ���
		for(int i=numberOfVertices-1;i>=0;i--) { 
			System.out.print(R[i]+" ");
		}
	}
	
	int index = 0;  // R �迭 �ε���
	
	public void DFS(int vertex) {   // ���� �켱 Ž��
		
		visited[vertex] = true;  //  �ش� ������ �湮�ߴٰ� ǥ��
	
		Node node = list[vertex];
		
		while(node!=null) {	// ������ ������ ���� ��� 

			int v = node.getVertex(); // �� ������ �ʵ� ����

			if(visited[v]==false) {  // �ش� ������  �湮�� ���� ������
				DFS(v);   // DFS ���ȣ��
			}
			
			node = node.getLink(); // �ش� ������ �湮�� ���� ������  ����� ���� �������� �Ѿ��.	 
		}
		
		R[index] =  vertex;   // �湮�� ����  R�迭�� ����
		index++;
	}
}
