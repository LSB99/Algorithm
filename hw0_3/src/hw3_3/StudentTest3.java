package hw3_3;
import hw0_3.Student;  // Student Ŭ���� import
import java.util.Scanner;
//***************************
//���ϸ�: Student3.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 3��
//����: ���� ����(bubble sort) �˰����� �̿��Ͽ� �л��� ���� ������������ �����ϴ� �ڹ� ���α׷��� �ۼ��Ͻÿ�.
//***************************

public class StudentTest3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);  // scanner ��ü ����
		
		System.out.println("hw3_3 : �Ӽ��� \n");  // �����ڵ� �̸� ���
		System.out.print("�л��� �Է�: ");  // �л��� �Է� ���� ���
		
		int n = scanner.nextInt();   // �л� ��(n)�� �Է¹޴´�.
		
		Student[] student = new Student[n];  // ũ�Ⱑ n�� student �迭�� �����.

		System.out.println("\n"+n+"���� �л� ������ �Է��ϼ���: "); // ���� ���
		
		String name = "";  // ������ �Է¹��� ����
		int id = 0;        // �й��� �Է¹��� ����
		double grade = 0;   // ������ �Է¹��� ���� 
		
		for(int i=0;i<n;i++) {    // �л������� �Է¹޴� �ݺ���
			name = scanner.next();  // ������ �Է��Ѵ�.
			id = scanner.nextInt();  // �й��� �Է��Ѵ�.
			grade = scanner.nextDouble();  // ������ �Է��Ѵ�.
			
			student[i] = new Student(name, id, grade);  // �����ڸ� ���ؼ� ���� , �й� , ���� ����
		}
		
		
		Student temp = new Student();  // �ӽ÷� �л������� ������ Student ��ü ����
		
		boolean sorted;   // ��ȯ���θ� Ȯ���ϴ� ����
		
		for(int i=n-1;i>=1;i--) {  // ���� ����
			sorted = true;   // ��ȯ�� �Ͼ�� �������¸�  true�� �����Ѵ�.
			
			for(int j=0;j<i;j++) {   		// �񱳰� ���� ���� ������ ���� �񱳸��Ѵ�.
				double grade1 = student[j].getGrade();   // j��° �л� ���� ����
				double grade2 = student[j+1].getGrade();  // �ٷ� ���� j+1��° �л� ���� ����
				
				if(grade2>grade1) {  // ���� �ٷδ��� �л��� ������  �ٷ� �տ� �ִ� �л��� �������� ũ��
					temp = student[j+1];   // temp�� �ٷ� ���� �л��� ������ �����Ѵ�.
					student[j+1] = student[j];  // �ٷ� ���� �л��� ��ġ�� �ٷ� �տ� �ִ� �л������� �����Ѵ�.
					student[j] = temp;   // �ٷ� �տ� �ִ� �л��� ��ġ��  �ٷ� ������ �ִ� �л������� �����Ͽ� ���� ��ȯ�Ѵ�.
					sorted = false;   // ��ȯ�� �Ͼ���Ƿ� false��  ����
				}
			}
			
			if(sorted == true)  // ���� ��ȯ�� �Ͼ�� ������ ������ �� �Ǿ����Ƿ�
				break;   // �ݺ����� Ż���Ѵ�.
		}
		
		System.out.println("\n���� �������� ���� ��� = ");  //�������� ���İ�� 
		
		for(int i=0;i<n;i++) {   // �л� �迭 ���̸�ŭ �ݺ��Ѵ�.
			System.out.print(student[i].getName()+" ");  //�л� �̸� ���
			System.out.print(student[i].getid()+" ");   // �л� �й� ���
			System.out.println(student[i].getGrade()); //  �л� ���� ���
		}
		
	}
}
