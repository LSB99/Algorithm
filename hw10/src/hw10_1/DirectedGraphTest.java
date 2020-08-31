package hw10_1;
import hw10.DirectedGraph;
import java.util.Scanner;
//***************************
//���ϸ�: DirectedGraphTest.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 6�� 5��
//���α׷� ����: ����׷��� ��������Ʈ main Ŭ����
//***************************

public class DirectedGraphTest {

	public static void main(String[] args) {
		
		System.out.println("hw10_1 : �Ӽ���\n");
		Scanner scanner = new Scanner(System.in);  
		
		System.out.print("���� �� �Է�: ");
		
		int n = scanner.nextInt();  // ���� �� n�� �Է¹���
		
		DirectedGraph graph = new DirectedGraph(n);  // ���� ���� n�� ���� �׷����� ����
		
		System.out.print("���� �� �Է�: ");
		
		int e = scanner.nextInt();// ���� �� e�� �Է¹���
		
		System.out.println("\n"+e+"���� ���� �Է�(�� ������ ���� ��ȣ 2���� whitespace�� �����Ͽ� �Է�):");
		
		
		// e���� ���� �� v1�� v2�� �Է¹޾� �׷����� <v1, v2>�� ����
		for(int i=0;i<e;i++) {
			int edge = i+1;
			System.out.print("����"+edge+" �Է�: ");
			
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			
			if(v1>=n || v2>=n) {
				System.out.println("���� ���� ���� - �߸��� ���� ��ȣ�Դϴ�. <"+v1+","+v2+">\n");
				continue;
			}
			
			else {
				graph.addEdge(v1,v2);  //�׷����� <v1, v2> ����
			}	
		}
		System.out.println();
		graph.printAdjacencyList();  //  �׷��� ������ Ȯ��
	}
}
