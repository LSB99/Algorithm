package example;

import java.util.Scanner;

public class example {
public static void main(String[] args) {  // main �Լ�
		
		Scanner scanner = new Scanner(System.in);  // scanner ��ü ����
		
		System.out.println("hw0_2 : �Ӽ���");  // ���� ���
		System.out.println("���� ���� ������ ���ϴ� ���α׷��Դϴ�.\n");  // ���� ���
		
		int[] a = new int[100];  // ũ�Ⱑ 100��  ���� ���� �迭 a ����
		int[] b = new int[100];  // ũ�Ⱑ 100��  ���� ���� �迭 b ����
		
		int acount = 0;  // �迭 a�� �Էµ� ������ ���� ���� ����
		int bcount = 0;  // �迭 b�� �Էµ� ������ ���� ���� ���� 
		
		System.out.print("ù��° ������ �Է��ϼ���. ���� �Է��� ��ġ���� ���� �ƴ� \n������ �Է��ϼ��� : "); //�ȳ��� ���
		
		for(int i=0;i<a.length;i++) {  // ù��° ���� �Է�
			a[i] = scanner.nextInt();  // ���� �Է�
			acount++;   // �Էµ� ������ŭ 1�� ����
			if(a[i]<0) { // ���� ���� ������ �ƴ� ���̸�
				break;  // �ݺ��� Ż��
			}
		}
		
		System.out.println();  // ����
		
		System.out.print("�ι�° ������ �Է��ϼ���. ���� �Է��� ��ġ���� ���� �ƴ� \n������ �Է��ϼ��� : "); // �ȳ��� ���
		
		for(int i=0;i<b.length;i++) {  // �ι�° ���� �Է�
			b[i] = scanner.nextInt();			
			bcount++;  // �Էµ� ������ŭ 1�� ����
			if(b[i]<0) {  // ���� ���� ������ �ƴ� ���̸�
				break;   // �ݺ��� Ż��
			}
		}

		for(int i=0;i<acount;i++) {  // �迭 a�� ������������ �����ϴ� �ݺ���
			for(int j=0;j<acount;j++) {  // a[i]�� �������� j�� �ϳ��� �÷����� �񱳸� �Ѵ�. 
				if(a[i]<a[j]) {  // a[j]���Ұ� �� ũ��
					int tmp = a[j];  // �ӽ� tmp ������ a[j] ���Ҹ� �����Ѵ�.
					a[j] = a[i];  // j�� ��ġ�� a[i] ���� ���� �����ϰ�
					a[i] = tmp; // i�� ��ġ�� a[j]���Ҹ� ������ tmp ���� ���� �����Ѵ�.
				}
			}
		}
		
		
		for(int i=0;i<bcount;i++) {  // �迭 b�� ������������ ����
			for(int j=0;j<bcount;j++) { // b[i]�� �������� j�� �ϳ��� �÷����� �񱳸� �Ѵ�. 
				if(b[i]<b[j]) {   // b[j]���Ұ� �� ũ��
					int tmp = b[j]; // �ӽ� tmp ������ b[j] ���Ҹ� �����Ѵ�.
					b[j] = b[i];  // j�� ��ġ�� b[i] ���� ���� �����ϰ�
					b[i] = tmp;  // i�� ��ġ�� b[j]���Ҹ� ������ tmp ���� ���� �����Ѵ�.
				}
			}
		}
		
	
		boolean c = true;   // �� ������ �������� �˱� ���� ���Ǵ� ����
		
		for(int i=0;i<acount;i++) {  // �ݺ��� 
			if(a[i]==b[i])  // ���� �迭 a�� ���ҿ� �迭 b�� ���Ұ� ���ٸ�
				continue;  // ��� �ݺ�
			
			else if(a[i]!=b[i]) {  // �迭 a�� ���ҿ� �迭 b�� ���Ұ� �ٸ��� 
				c=false;   // ���� c�� false ����
				break;  // �ݺ��� Ż��
			}
		}
		
		if(c==true)  // ���� c�� true�̸�
			System.out.println("\n�� ������ �����ϴ�.");  // �����ϴ� ���ڿ� ���
		
		else if(c==false)  // ���� c�� false�̸� 
			System.out.println("\n�� ������ ���� �ٸ��ϴ�.");  // �ٸ��ϴ� ���� ���
	}
}
