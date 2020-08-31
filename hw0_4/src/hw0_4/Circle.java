package hw0_4;
import shape.Shape;
//***************************
//���ϸ�: Circle.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 8��
//����: �� Ŭ���� - ���� �������̽��� ����(implements)
//***************************
public class Circle implements Shape{  // �� Ŭ���� - ���� �������̽��� ����(implements)
	
	private double radius; // ������(�Ǽ���)
	
	public double getRadius() {  // ���� ������ �����ϴ� �޼ҵ�
		return this.radius; 
	}
	
	public void setRadius(double radius) {  // ���� �������� �����ϴ� �޼ҵ�
		this.radius = radius;
	}
	
	public String toString() {  // toString() �������̵�
		return "�� ������="+this.getRadius()+" ����="+this.getArea();
	}
	
	public double getArea() {  //������ ���ϴ� �޼ҵ�
		return radius * radius *Math.PI;
	}
}
