package hw0_4;
import shape.Shape;
//***************************
//파일명: Circle.java
//작성자: 임수빈
//작성일: 2020년 4월 8일
//내용: 원 클래스 - 도형 인터페이스를 구현(implements)
//***************************
public class Circle implements Shape{  // 원 클래스 - 도형 인터페이스를 구현(implements)
	
	private double radius; // 반지름(실수형)
	
	public double getRadius() {  // 원의 반지름 리턴하는 메소드
		return this.radius; 
	}
	
	public void setRadius(double radius) {  // 원의 반지름을 설정하는 메소드
		this.radius = radius;
	}
	
	public String toString() {  // toString() 오버라이드
		return "원 반지름="+this.getRadius()+" 면적="+this.getArea();
	}
	
	public double getArea() {  //면적을 구하는 메소드
		return radius * radius *Math.PI;
	}
}
