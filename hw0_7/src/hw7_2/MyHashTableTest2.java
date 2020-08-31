package hw7_2;
import java.util.Scanner;
import hw0_7.MyHashTable2;
//***************************
//���ϸ�: MyHashTableTest2.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 5�� 7��
//����: ����Ŭ����
//***************************

public class MyHashTableTest2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("hw7_2 : �Ӽ���");
		System.out.print("�ؽ����̺� ũ�� �Է�:");
		
		int size = scanner.nextInt();
		
		MyHashTable2 studentTable = new MyHashTable2(size);  //�ؽ����̺� ��ü ����
		
		int menu = 0;
		do {
			
			System.out.print("\n1:����  2:�˻�  3:����  4:���̺����  5:���� --->");
			menu = scanner.nextInt();
			
			switch(menu) {
			
			case 1:
				System.out.print("������ �й�(������), ����(������)�� �Է��ϼ���:");
				int id = scanner.nextInt();
				int grade = scanner.nextInt();
				
				if(id<0) {  //�й��� ���������̸�
					System.out.println("���� ���� �й��� �Է��ϼ���");
					continue;
				}
				
				if(studentTable.put(id, grade)) {
					System.out.println(id+" �й� ���Լ���");
				}
				
				else {
					System.out.println(id+" �й� ���Խ���");
				}
				break;
				
			case 2:
				System.out.print("�˻��� �й�(������)�� �Է��ϼ���:");
				id = scanner.nextInt();
				grade = studentTable.get(id);
				
				if(grade!=-1) {
					System.out.println(grade+"�� �Դϴ�.");
				}
				
				else {
					System.out.println(id+" �й� �л��� ã�� �� �����ϴ�.");
				}
				break;
				
			case 3:
				System.out.print("������ �й�(������)�� �Է��ϼ���:");
				id = scanner.nextInt();
				
				if(studentTable.remove(id)) {
					System.out.println(id+" �й� ��������");
				}
				
				else {
					System.out.println(id+" �й� ��������");
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
