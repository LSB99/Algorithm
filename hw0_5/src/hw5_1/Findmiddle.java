package hw5_1;
import hw0_5.Selectservice;
import java.util.Scanner;
//***************************
//파일명: Findmiddle.java
//작성자: 임수빈
//작성일: 2020년 4월 14일
//내용: 사용자가 입력한 정수값 중에서 선택 알고리즘을 이용하여 중앙값인 정수값을 찾는 프로그램을 작성하시오.
//***************************
public class Findmiddle {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("hw5_1 : 임수빈 \n");
		
		System.out.print("정수갯수 입력: ");
		int n = scanner.nextInt();  // 정수 갯수(n) 입력
		
		int[] number = new int[n]; // 크기 n인 정수 배열 생성
		
		System.out.print(n+"개의 정수 입력: ");
		
		for(int i=0;i<n;i++) {  // n개의 정수값 입력
			number[i] = scanner.nextInt();  
		}
		
		int mi = 0; //중앙값 인덱스
		
		if(n%2!=0) {  // 정수 갯수가 홀수일때
			mi = (n/2) + 1; // (n/2)+1 번째 작은 수를 중앙값으로 한다.
		}
		else if(n%2==0) {  // 정수 갯수가 짝수일때
			mi = n/2;  // (n/2)번째 작은수를 중앙값으로 한다.
		}
		
		System.out.println("중앙값 = " + Selectservice.select(number, 0, n-1, mi));  // 중앙값 출력
	}
}

