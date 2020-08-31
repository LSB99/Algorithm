package hw8_1;
import hw0_8.DynamicPath;
import java.util.Scanner;
//***************************
//���ϸ�: DynamicPathTest.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 5�� 19��
//����:  ��İ�� ���� �������α׷��� ����Ŭ����
//***************************

public class DynamicPathTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("hw8_1 : �Ӽ���");
		System.out.print("���� ũ�� �Է� : ");
		
		int n = scanner.nextInt();  // ���� ũ�� �Է�
		int[][] m = new int[n][n];  // nxn ũ�� ���  m ����

		System.out.println("\n"+n+" x "+n+" ũ���� ��� ���� �Է� :");
		
		for(int i=0;i<n;i++) {   // nxn ũ�� ��� ���� �Է�
			for(int j=0;j<n;j++) {
				m[i][j] = scanner.nextInt();
			}
		}
		
		DynamicPath dn = new DynamicPath(n); // DynamicPath Ŭ���� ��ü ����
		dn.put(m,n);  // DynamicPath Ŭ������ ��� m�� �����Ѵ�.
		 
		System.out.println("\n�ִ� ���� = "+dn.matrixPath(n));   // �ִ� ���� ���
		System.out.print("�ִ� ���� ��� = ");    
		dn.maxscorepath(n);  // �ִ� ���� ��� ���
		
		System.out.println();
	}
}
