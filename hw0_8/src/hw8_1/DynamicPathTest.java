package hw8_1;
import hw0_8.DynamicPath;
import java.util.Scanner;
//***************************
//파일명: DynamicPathTest.java
//작성자: 임수빈
//작성일: 2020년 5월 19일
//내용:  행렬경로 문제 동적프로그래밍 메인클래스
//***************************

public class DynamicPathTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("hw8_1 : 임수빈");
		System.out.print("행의 크기 입력 : ");
		
		int n = scanner.nextInt();  // 행의 크기 입력
		int[][] m = new int[n][n];  // nxn 크기 행렬  m 생성

		System.out.println("\n"+n+" x "+n+" 크기의 행렬 원소 입력 :");
		
		for(int i=0;i<n;i++) {   // nxn 크기 행렬 원소 입력
			for(int j=0;j<n;j++) {
				m[i][j] = scanner.nextInt();
			}
		}
		
		DynamicPath dn = new DynamicPath(n); // DynamicPath 클래스 객체 생성
		dn.put(m,n);  // DynamicPath 클래스의 행렬 m에 복사한다.
		 
		System.out.println("\n최대 점수 = "+dn.matrixPath(n));   // 최대 점수 출력
		System.out.print("최대 점수 경로 = ");    
		dn.maxscorepath(n);  // 최대 점수 경로 출력
		
		System.out.println();
	}
}
