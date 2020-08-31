package hw4_6;
import hw0_4.*;
import shape.Shape;
import java.util.Scanner;
//***************************
//파일명: HeapSortTest.java
//작성자: 임수빈
//작성일: 2020년 4월 10일
//내용: [hw4_6] heap sort
//***************************
public class HeapSortTest {  
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  // scanner 객체 생성
		System.out.println("hw4_6 : 임수빈 \n");  // 과제코드 이름 출력
		
		System.out.print("원 갯수 입력:");
		int n1 = scanner.nextInt() ; // 원 갯수 입력
		
		System.out.print("삼각형 갯수 입력:");  
		int n2 = scanner.nextInt() ; // 삼각형 갯수 입력
		
		Shape[] figureArray = new Shape[n1+n2]; // 크기가 n1+n2인 도형 배열을 생성함
				
		System.out.println("\n"+n1+"개의 원 정보(반지름)를 입력하세요:");
		
		for(int i=0;i<n1;i++) { // n1개의 원 정보(반지름)를 입력받아 원 객체를 생성하여 도형 배열에 저장
			double r = scanner.nextDouble(); // 반지름 입력
			Circle c = new Circle();  //원 객체생성
			c.setRadius(r);   // 반지름 설정
			figureArray[i] = c;  // 원객체를 도형 배열에 저장
		}
		
		System.out.println("\n"+n2+"개의 삼각형 정보(밑변과 높이)를 입력하세요:");
		
		for(int i=n1;i<n1+n2;i++) { //n2개의 삼각형 정보(밑변과 높이)를 입력받아 삼각형 객체를 생성하여 도형 배열에 저장
			double width = scanner.nextDouble(); // 밑변 입력
			double height = scanner.nextDouble(); // 높이 입력
			Triangle t = new Triangle(); // 삼각형 객체를 생성
			t.setWidth(width);  // 밑변 설정
			t.setHeight(height);  // 높이 설정
			figureArray[i] = t;  // 삼각형 객체를 도형배열에 저장
		}
		
		HeapSortService.heapSort(figureArray);  // 도형 배열을 힙 정렬
		
		System.out.println("\n"+"힙 정렬 결과 "+figureArray.length+"개의 도형 정보와 면적 ==");
		for(int i=0;i<figureArray.length;i++) {  // 면적 순으로 정렬된 n1+n2개의 도형 정보와 면적을 출력
			System.out.println(figureArray[i].toString()); // 도형 정보와 면적을 출력
		}
	}

}
