package hw10;
//***************************
//���ϸ�: DirectedGraph.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 6�� 5��
//���α׷� ����: ����׷��� ��������Ʈ  Ŭ����
//***************************

public class DirectedGraph {

	private Node[] list;    // ��������Ʈ �迭�� ����ų ����(list)
	private int numberOfVertices;  //  ������
	
	// ����Ʈ�� ��� ������ ������ Ŭ����
	private class Node{   
		
		int vertex;  //  ������ȣ �ʵ�(vertex)
		Node link;   //  ���� ��带 ����Ű�� �ʵ�(link)
		
		public Node(int vertex){  // Node Ŭ���� ������
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
	}
	
	 // ������ n�� �Ű������� �޾� ���� n��, ������ ���� �ʱ� �׷����� ����
	public DirectedGraph(int n) { 
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
			
			Node node = list[v1];
			
			while(node.getLink()!=null) {  //�״��� ��尡 ������� �ʴٸ�
				node=node.getLink();   // �״��� ��ũ�� ����
			}
			
			 // �� ���� ��尡 ��� ������
			node.setLink(new Node(v2));   //  v2�� ���� 
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
				
}
