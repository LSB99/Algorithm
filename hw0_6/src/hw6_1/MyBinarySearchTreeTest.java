package hw6_1;
import hw0_6.MyBinarySearchTree;
import java.util.Scanner;
//***************************
//���ϸ�: MyBinarySearchTreeTest.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 21��
//����: ����Ŭ����
//***************************

public class MyBinarySearchTreeTest {

	public static void main(String[] args) {
		System.out.println("hw6_1 : �Ӽ���\n");
		Scanner scanner = new Scanner(System.in);
		
		MyBinarySearchTree tree = new MyBinarySearchTree(); // ����ִ� MyBinarySearchTree ��ü�� ����
		
		while(true) {  // 5(����)�� �Ҷ����� ���ѹݺ�
			
			System.out.print("1:����  2:�˻�  3:����  4:��ü��ȸ  5:���� >> ");
			int n = scanner.nextInt();  // ��ȣ�Է�
			String s;  //���̵� ����
			
			if(n==1) {  // 1�� : ����
				System.out.print("������ ���̵� �Է��ϼ��� : ");
				s = scanner.next();  //���̵� �Է�
				boolean state = tree.add(s);

				if(state) {  
					System.out.println(s+" ���� ����\n");
				}
				
				else {
					System.out.println(s+" ���� ����\n");
				}
			}
			
			else if(n==2) {  // 2�� :�˻�
				System.out.print("�˻��� ���̵� �Է��ϼ��� : ");
				s = scanner.next();  //���̵� �Է�
				boolean state = tree.contains(s);
				
				if(state) {
					System.out.println(s+ " �˻� ����\n");
				}
				
				else {
					System.out.println(s+ " �˻� ����\n");
				}
			}
			
			else if(n==3) {  // 3�� :����
				System.out.print("������ ���̵� �Է��ϼ��� : ");
				s = scanner.next();  //���̵� �Է�
				boolean state = tree.remove(s);
				
				if(state) {
					System.out.println(s+" ���� ����\n");
				}
				
				else {
					System.out.println(s+" ���� ����\n");
				}
			}
			
			else if(n==4) {  // 4�� :��ü��ȸ
				tree.print();
			}

			else if(n==5) {   // 5�� :����
				System.out.println("�����մϴ�.");
				break;
			}
		}
	}
}
