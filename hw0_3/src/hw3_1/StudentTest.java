package hw3_1;
import java.util.Scanner;
//***************************
//���ϸ�: hw3_1
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 3�� 31��
//����: �л��� ��Ÿ���� Ŭ������ �����ϰ� �̿��ϴ� �ڹ� ���α׷��� �ۼ��Ѵ�.
//***************************

class Student{  	// �л����� Ŭ���� 
	private String name = ""; // ����
	private int id = 0;      // �й�
	private double grade = 0;  // ����
	
	public void setname(String name) {  // ������ �����ϴ� �޼ҵ�
		this.name = name;
	}
	
	public void setid(int id) {    // �й��� �����ϴ� �޼ҵ�
		this.id = id;
	}
	
	public void setgrade(double grade) {  // ������ �����ϴ� �޼ҵ�
		this.grade = grade;
	}
	
	public String getname() {  // ������ �����ϴ� �޼ҵ�
		return this.name; 
	}
	
	public int getid() {   // �й��� �����ϴ� �޼ҵ�
		return this.id;
	}
	
	public double getgrade() {  // ������ �����ϴ� �޼ҵ�
		return this.grade;
	}
}


public class StudentTest {   // StudentTest Ŭ����
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);  // scanner ��ü ����
		
		System.out.println("hw3_1 : �Ӽ��� \n");  // �����ڵ�� �̸� ���
		System.out.print("�л��� �Է�: ");     // ���� ���
		
		int n = scanner.nextInt();   // �л� ��(n)�� �Է¹޴´�.
		
		Student[] student = new Student[n];  // ũ�Ⱑ n��  student �迭�� �����.
		
		System.out.println("\n"+n+"���� �л� ������ �Է��ϼ���: ");  // ���� ���
		
		String name = "";  // ������ �Է¹��� ����
		int id = 0;    // �й��� �Է¹��� ����
		double grade = 0;   // ������ �Է¹��� ���� 
		
		double sum = 0;   // �л��� ���� ���� ���� 
		
		for(int i=0;i<n;i++) {   // �л������� �Է¹޴� �ݺ���
			name = scanner.next();  // ������ �Է��Ѵ�.
			id = scanner.nextInt();  // �й��� �Է��Ѵ�.
			grade = scanner.nextDouble();  // ������ �Է��Ѵ�.
			
			student[i] = new Student();  // student �迭 �� ���ҿ� Student ��ü ����
			student[i].setname(name);    //  ������ �����Ѵ�.
			student[i].setid(id);        // �й��� �����Ѵ�.
			student[i].setgrade(grade);  // ������ �����Ѵ�.
			
			sum+=grade;  // ������ ���Ѵ�.
		}
		
		System.out.println("\n���� ��� = "+ sum/n);  // ������հ� ���
		
		double max = student[0].getgrade();  // �ְ� ������ ��Ÿ���� ���� 
		int top = 0;   // �ְ� ������ ���� �л��� ������ ������ ����
		 
		for(int i=1;i<n;i++) {   // �ְ����� ���� �л��� ã�� ���� �ݺ���
			
			if(max<student[i].getgrade()) {  // ���� ���� �������� �� ���� �����̸�
				max = student[i].getgrade();  // �� ���� ������ �ٲ۴�.
				top = i;   // �ְ� ������ ���� �л��� ������ �����Ѵ�.
			}
		}
		
		System.out.println("\n���� �л� ���� = "+ student[top].getname());  // �ְ��� �л��� ���� ���
	}
}
