package compareset_1;

import java.util.Scanner;

public class Comparenumberset {
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

		int asame=0;  // a�迭�� �������� ���ϸ鼭 ���� ���� ������ �����ϴ� ����
		int bsame=0;  // b�迭�� �������� ���ϸ鼭 ���� ���� ������ �����ϴ� ����

		if(acount==bcount) {  // a�迭�� ���� ������ b�迭�� ���Ұ����� ������
			for(int i=0;i<acount;i++) {   // a�迭 �������� ���� ��
				for(int j=0;j<bcount;j++) {  // b�迭 ���ҿ� ��
					if(a[i]==b[j]) {   // a�迭 ���ҿ� b�迭 ���Ұ� ������
						asame++;   // 1���ϱ�
						break;    // �ݺ��� Ż��
					}
				}
			}
			
			for(int i=0;i<bcount;i++) { 	// b�迭 �������� ���� ��
				for(int j=0;j<acount;j++) {   // a�迭 ���ҿ� ��
					if(b[i]==a[j]) {  // b�迭 ���ҿ� a�迭 ���Ұ� ������
						bsame++;	 // 1���ϱ�
						break;		// �ݺ��� Ż��
					}
				}
			}
		}
		
		if(asame==bsame && asame == acount)  // a�迭�� b�迭�� ���Ұ� ���� ����  �� ������ �����͵� ������
			System.out.println("\n�� ������ �����ϴ�.");  // �����ϴ� ���ڿ� ���
		
		else   // �ƴϸ�
			System.out.println("\n�� ������ ���� �ٸ��ϴ�.");  // �ٸ��ϴ� ���� ���
	}

}
