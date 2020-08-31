
import java.util.Scanner;

import openaddress.chaining;

public class chainingTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ü�̴�");
		System.out.print("�ؽ����̺� ũ�� �Է�:");
		
		int size = scanner.nextInt();
		
		chaining studentTable = new chaining(size);  //�ؽ����̺� ��ü ����
		
		int menu = 0;
		do {
			
			System.out.print("\n1:����  2:�˻�  3:����  4:���̺����  5:���� --->");
			menu = scanner.nextInt();
			
			switch(menu) {
			
			case 1:
				System.out.print("������ �й�(������), ����(������)�� �Է��ϼ���:");
				int id = scanner.nextInt();
				int grade = scanner.nextInt();
				
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
				
				if(grade>=0) {
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
