package hw7_1;
import hw0_7.MyHashtable;
import java.util.Scanner;
//***************************
//���ϸ�: MyHashtableTest.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 5�� 5��
//����: ����Ŭ����
//***************************

public class MyHashtableTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("hw7_1 : �Ӽ���");
		System.out.print("�ؽ����̺� ũ�� �Է�:");
		
		int size = scanner.nextInt();
		
		MyHashtable studentTable = new MyHashtable(size);  //�ؽ����̺� ��ü ����
		
		int menu = 0;
		do {
			
			System.out.print("\n1:����  2:�˻�  3:����  4:���̺����  5:���� --->");
			menu = scanner.nextInt();
			
			switch(menu) {
			
			case 1:
				System.out.print("������ �й�(������)�� �Է��ϼ���:");
				int id = scanner.nextInt();
				
				if(id<0) {  //�й��� ���������̸�
					System.out.println("���� ���� �й��� �Է��ϼ���");
					continue;
				}
				
				if(studentTable.put(id)) {
					System.out.println(id+" ���Լ���");
				}
				
				else {
					System.out.println(id+" ���Խ���");
				}
				break;
				
			case 2:
				System.out.print("�˻��� �й�(������)�� �Է��ϼ���:");
				id = scanner.nextInt();
				
				if(studentTable.contains(id)) {
					System.out.println(id+" �л��� ã�ҽ��ϴ�.");
				}
				
				else {
					System.out.println(id+" �л��� ã�� �� �����ϴ�.");
				}
				break;
				
			case 3:
				System.out.print("������ �й�(������)�� �Է��ϼ���:");
				id = scanner.nextInt();
				
				if(studentTable.remove(id)) {
					System.out.println(id+" ��������");
				}
				
				else {
					System.out.println(id+" ��������");
				}
				break;
				
			case 4:
				studentTable.print();
				break;
				
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				break;
				
			default:
					System.out.println("�޴� ��ȣ�� �߸��Ǿ����ϴ�. �ٽ� �Է��ϼ���.");
			}
			
		}while(menu!=5);
		
		scanner.close();
	}
}
