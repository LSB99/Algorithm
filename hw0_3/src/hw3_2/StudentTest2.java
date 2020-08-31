package hw3_2;
import hw0_3.Student;  // Student Ŭ���� import
import java.util.Scanner;
//***************************
//���ϸ�: StudentTest2.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 2��
//����: ���� ����(selection sort) �˰����� �̿��Ͽ� �л��� ���� ������������ �����ϴ� �ڹ� ���α׷��� �ۼ��Ͻÿ�.
//***************************

public class StudentTest2 {		// StudentTest2 Ŭ����
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);  // scanner ��ü ����
		
		System.out.println("hw3_2 : �Ӽ��� \n");  // �����ڵ� �̸� ���
		System.out.print("�л��� �Է�: ");  // �л��� �Է� ���� ���
		
		int n = scanner.nextInt();   // �л� ��(n)�� �Է¹޴´�.
		
		Student[] student = new Student[n];  // ũ�Ⱑ n�� �л� �迭�� �����.
		
		System.out.println("\n"+n+"���� �л� ������ �Է��ϼ���: ");   // ���� ���
		
		String name = "";  // ������ �Է¹��� ����
		int id = 0;    // �й��� �Է¹��� ����
		double grade = 0;   // ������ �Է¹��� ���� 
		
		for(int i=0;i<n;i++) {    // �л������� �Է¹޴� �ݺ���
			name = scanner.next();  // ������ �Է��Ѵ�.
			id = scanner.nextInt();  // �й��� �Է��Ѵ�.
			grade = scanner.nextDouble();  // ������ �Է��Ѵ�.
			
			student[i] = new Student(name, id, grade);  // �����ڸ� ���ؼ� ���� , �й� , ���� ����
		}
		
		Student temp = new Student();  // �ӽ÷� �л������� ������ Student ��ü ����
		int max = 0;   // �� ���� ������ ���� �л��� ���� ���庯��
		
		for(int i=n-1;i>=1;i--) {  // �������� , ���� �迭�� ������ �ε������� �����Ѵ�.
			max = i;  						 // ���� ������ �迭���� �ε��� i��  max�� �����Ѵ�.
			for(int j=i-1;j>=0;j--) {      // �񱳰� ���� ������ ���Ҹ� �����ϰ�  �� �� ������ ������ ã�� �ݺ���
				String s1 = student[max].getName();  // ���� �� �� ������ �л������� �����Ѵ�.
				String s2 = student[j].getName();   // ���� ���Ϸ��� �л������� �����Ѵ�.

				if(s2.compareTo(s1) > 0) {  // ���� ���� �л������� ���� �� �޼��� ������ �� �ڿ� ������
					max = j;  // ���� ���� �л��� ������  max�� �����Ѵ�.
				}
			}
			temp = student[max];  // �� �� ���� �� ������ ���� �� ������ �л� ������ �����Ѵ�.
			student[max] = student[i];  // max�� �ִ� ��ġ��  ���� �迭�� ������ ��ġ i��° �ִ� �л������� �����Ѵ�.
			student[i] = temp;     // �׸��� �� ������ ��ġ i��°�� ������ ���� �� ������ �л� ������ �����Ѵ�.
		} 
		
		System.out.println("\n���� �������� ���� ��� = ");   // �������� ���� ��� ���� ���
		
		for(int i=0;i<n;i++) {   // �л� �迭 ���̸�ŭ �ݺ��Ѵ�.
			System.out.print(student[i].getName()+" ");  // ���� ���
			System.out.print(student[i].getid()+" ");   // �й� ���
			System.out.println(student[i].getGrade());  // ���� ���
		}
		
	}

}
