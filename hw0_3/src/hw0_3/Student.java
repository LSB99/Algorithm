package hw0_3;
//***************************
//���ϸ�: Student.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020.03.30
//����: [hw3_1] Student Ŭ����
//***************************

public class Student {
	private String name;  //����
	private int id;   //�й�
	private double grade;  //����
	
	public Student() {  // �⺻ ������
		
	}
	
	public Student(String name, int id, double grade) {  // �л����� �����ϴ� ������
		this.name = name;  //���� ����
		this.id = id;      // �й� ����
		this.grade = grade;  // ���� ����
	}
	
	public String getName() {	//�̸� ����
		return this.name;
	}
	
	public int getid() {   // �й��� �����ϴ� �޼ҵ�
		return this.id;
	}

	
	public double getGrade() {	//���� ����
		return this.grade;
	}
}
