package hw8_2;
import java.util.Scanner;
import hw0_8.Stonedynamic;
//***************************
//파일명: StonedynamicTest.java
//작성자: 임수빈
//작성일: 2020년 5월 20일
//내용:  돌 놓기 문제  동적프로그래밍  메인클래스
//***************************

public class StonedynamicTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("hw8_2 : 임수빈\n");
		System.out.println("돌 놓기 문제를 동적프로그래밍을 이용하여 구현합니다. \n");
		
		int row = 3;   // 행렬의 행 변수
	    int col = (int)(Math.random()*(8-5+1)+5);  //  5 ~ 8  중 랜덤넘버를 대입한다. 행렬의 열 변수
	    
		int[][] w = new int[row][col]; // 3 x col 배열
		
		for(int i=0;i<row;i++) {  // w배열에  랜덤 숫자 대입
			for(int j=0;j<col;j++) {
				w[i][j] = (int)(Math.random()*(15-(-15)+1)+(-15)); //  -15 ~ 15 중 랜덤넘버를 대입한다. 
			}
		}
		
		Stonedynamic sd = new Stonedynamic(row,col);  
		sd.put(w,row,col);   // Stonedynamic 클래스의 배열에  w배열 대입
		
		System.out.println(row+"x"+col+" 테이블 출력 : \n");
		
		for(int i=0;i<row;i++) {  // w배열 출력
			for(int j=0;j<col;j++) {
				System.out.print(w[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(); 
		
		System.out.println("\n돌 놓기 문제 최종 값 = " + sd.pebble(row,col));  //  최종값 출력
	}
}
