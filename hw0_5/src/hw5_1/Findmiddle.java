package hw5_1;
import hw0_5.Selectservice;
import java.util.Scanner;
//***************************
//���ϸ�: Findmiddle.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 14��
//����: ����ڰ� �Է��� ������ �߿��� ���� �˰����� �̿��Ͽ� �߾Ӱ��� �������� ã�� ���α׷��� �ۼ��Ͻÿ�.
//***************************
public class Findmiddle {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("hw5_1 : �Ӽ��� \n");
		
		System.out.print("�������� �Է�: ");
		int n = scanner.nextInt();  // ���� ����(n) �Է�
		
		int[] number = new int[n]; // ũ�� n�� ���� �迭 ����
		
		System.out.print(n+"���� ���� �Է�: ");
		
		for(int i=0;i<n;i++) {  // n���� ������ �Է�
			number[i] = scanner.nextInt();  
		}
		
		int mi = 0; //�߾Ӱ� �ε���
		
		if(n%2!=0) {  // ���� ������ Ȧ���϶�
			mi = (n/2) + 1; // (n/2)+1 ��° ���� ���� �߾Ӱ����� �Ѵ�.
		}
		else if(n%2==0) {  // ���� ������ ¦���϶�
			mi = n/2;  // (n/2)��° �������� �߾Ӱ����� �Ѵ�.
		}
		
		System.out.println("�߾Ӱ� = " + Selectservice.select(number, 0, n-1, mi));  // �߾Ӱ� ���
	}
}

