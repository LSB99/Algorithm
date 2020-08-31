package hw0_4;
import shape.Shape;
//***************************
//파일명: Triangle.java
//작성자: 임수빈
//작성일: 2020년 4월 8일
//내용: 삼각형 클래스 - 도형 인터페이스를 구현(implements)
//***************************
public class Triangle implements Shape {  // 삼각형 클래스 - 도형 인터페이스를 구현(implements)

	private double width;  // 밑변 (실수형)
	private double height; // 높이 (실수형)
	
	public double getWidth() {  // 밑변을 리턴하는 메소드
		return this.width;
	}
	
	public double getHeight() {  // 높이를 리턴하는 메소드
		return this.height;
	}
	
	public void setWidth(double width) {  //밑변을 설정하는 메소드
		this.width = width;
	}
	
	public void setHeight(double height) {  // 높이를 설정하는 메소드
		this.height = height;
	}
	
	public String toString() {  // toString() 오버라이드
		return "삼각형 밑변="+this.getWidth()+" 높이="+this.getHeight()+" 면적="+this.getArea();
	}
	
	public double getArea() { //면적을 구하는 메소드
		return width*height/2.0;
	}
}
