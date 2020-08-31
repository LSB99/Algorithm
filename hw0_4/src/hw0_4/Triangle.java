package hw0_4;
import shape.Shape;
//***************************
//���ϸ�: Triangle.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 8��
//����: �ﰢ�� Ŭ���� - ���� �������̽��� ����(implements)
//***************************
public class Triangle implements Shape {  // �ﰢ�� Ŭ���� - ���� �������̽��� ����(implements)

	private double width;  // �غ� (�Ǽ���)
	private double height; // ���� (�Ǽ���)
	
	public double getWidth() {  // �غ��� �����ϴ� �޼ҵ�
		return this.width;
	}
	
	public double getHeight() {  // ���̸� �����ϴ� �޼ҵ�
		return this.height;
	}
	
	public void setWidth(double width) {  //�غ��� �����ϴ� �޼ҵ�
		this.width = width;
	}
	
	public void setHeight(double height) {  // ���̸� �����ϴ� �޼ҵ�
		this.height = height;
	}
	
	public String toString() {  // toString() �������̵�
		return "�ﰢ�� �غ�="+this.getWidth()+" ����="+this.getHeight()+" ����="+this.getArea();
	}
	
	public double getArea() { //������ ���ϴ� �޼ҵ�
		return width*height/2.0;
	}
}
