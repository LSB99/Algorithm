package hw4_6;
import hw0_4.*;
import shape.Shape;
import java.util.Scanner;
//***************************
//���ϸ�: HeapSortTest.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 10��
//����: [hw4_6] heap sort
//***************************
public class HeapSortTest {  
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  // scanner ��ü ����
		System.out.println("hw4_6 : �Ӽ��� \n");  // �����ڵ� �̸� ���
		
		System.out.print("�� ���� �Է�:");
		int n1 = scanner.nextInt() ; // �� ���� �Է�
		
		System.out.print("�ﰢ�� ���� �Է�:");  
		int n2 = scanner.nextInt() ; // �ﰢ�� ���� �Է�
		
		Shape[] figureArray = new Shape[n1+n2]; // ũ�Ⱑ n1+n2�� ���� �迭�� ������
				
		System.out.println("\n"+n1+"���� �� ����(������)�� �Է��ϼ���:");
		
		for(int i=0;i<n1;i++) { // n1���� �� ����(������)�� �Է¹޾� �� ��ü�� �����Ͽ� ���� �迭�� ����
			double r = scanner.nextDouble(); // ������ �Է�
			Circle c = new Circle();  //�� ��ü����
			c.setRadius(r);   // ������ ����
			figureArray[i] = c;  // ����ü�� ���� �迭�� ����
		}
		
		System.out.println("\n"+n2+"���� �ﰢ�� ����(�غ��� ����)�� �Է��ϼ���:");
		
		for(int i=n1;i<n1+n2;i++) { //n2���� �ﰢ�� ����(�غ��� ����)�� �Է¹޾� �ﰢ�� ��ü�� �����Ͽ� ���� �迭�� ����
			double width = scanner.nextDouble(); // �غ� �Է�
			double height = scanner.nextDouble(); // ���� �Է�
			Triangle t = new Triangle(); // �ﰢ�� ��ü�� ����
			t.setWidth(width);  // �غ� ����
			t.setHeight(height);  // ���� ����
			figureArray[i] = t;  // �ﰢ�� ��ü�� �����迭�� ����
		}
		
		HeapSortService.heapSort(figureArray);  // ���� �迭�� �� ����
		
		System.out.println("\n"+"�� ���� ��� "+figureArray.length+"���� ���� ������ ���� ==");
		for(int i=0;i<figureArray.length;i++) {  // ���� ������ ���ĵ� n1+n2���� ���� ������ ������ ���
			System.out.println(figureArray[i].toString()); // ���� ������ ������ ���
		}
	}

}
