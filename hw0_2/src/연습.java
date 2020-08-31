import java.util.Scanner;

class Student{  // �л����� Ŭ���� 
	private String name = ""; // ����
	private int id = 0;  // �й�
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

public class ���� {
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);  // scanner ��ü ����
		
		System.out.println("hw3_2_1 : �Ӽ��� \n");  // �����ڵ� �̸� ���
		System.out.print("�л��� �Է�: ");  // �л��� �Է� ���� ���
		
		int n = scanner.nextInt();   // �л� ��(n)�� �Է¹޴´�.
		
		Student[] array = new Student[n];  // ũ�Ⱑ n�� �л� �迭�� �����.
		
		System.out.println("\n"+n+"���� �л� ������ �Է��ϼ���: ");   // ���� ���
		
		String name = "";  // ������ �Է¹��� ����
		int id = 0;    // �й��� �Է¹��� ����
		double grade = 0;   // ������ �Է¹��� ���� 
		
		for(int i=0;i<n;i++) {    // �л������� �Է¹޴� �ݺ���
			name = scanner.next();  // ������ �Է��Ѵ�.
			id = scanner.nextInt();  // �й��� �Է��Ѵ�.
			grade = scanner.nextDouble();  // ������ �Է��Ѵ�.
			
			array[i] = new Student();  // array �迭 �� ���ҿ� Student ��ü ����
			array[i].setname(name);    //  ������ �����Ѵ�.
			array[i].setid(id);   // �й��� �����Ѵ�.
			array[i].setgrade(grade);  // ������ �����Ѵ�.
		}
		
		Student temp = new Student();  // �ӽ÷� �л������� ������ Student ��ü ����
		int max = 0;   // �� ���� ������ ���� �л��� ���� ���庯��
		
		for(int i=array.length-1;i>0;i--) {  // �������� , ���� �迭�� ������ �ε������� �����Ѵ�.
			max = i;  						 // ���� ������ �迭���� �ε��� i��  max�� �����Ѵ�.
			for(int j=0;j<=i-1;j++) {      // �񱳰� ���� ������ ���Ҹ� �����ϰ�  �� �� ������ ������ ã�� �ݺ���
				String s1 = array[max].getname();  // ���� �� �� ������ �л������� �����Ѵ�.
				String s2 = array[j].getname();   // ���� ���Ϸ��� �л������� �����Ѵ�.

				if(s2.compareTo(s1) > 0) {  // ���� ���� �л������� ���� �� �޼��� ������ �� �ڿ� ������
					max = j;  // ���� ���� �л��� ������  max�� �����Ѵ�.
				}
			}
			temp = array[max];  // �� �� ���� �� ������ ���� �� ������ �л� ������ �����Ѵ�.
			array[max] = array[i];  // max�� �ִ� ��ġ��  ���� �迭�� ������ ��ġ i��° �ִ� �л������� �����Ѵ�.
			array[i] = temp;     // �׸��� �� ������ ��ġ i��°�� ������ ���� �� ������ �л� ������ �����Ѵ�.
		} 
		
		System.out.println("\n���� �������� ���� ��� = ");   // �������� ���� ��� ���� ���
		
		for(int i=0;i<array.length;i++) {   // �л� �迭 ���̸�ŭ �ݺ��Ѵ�.
			System.out.print(array[i].getname()+" ");  // ���� ���
			System.out.print(array[i].getid()+" ");   // �й� ���
			System.out.println(array[i].getgrade());  // ���� ���
		}
		
	}


}
