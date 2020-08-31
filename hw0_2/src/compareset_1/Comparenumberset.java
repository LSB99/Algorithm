package compareset_1;

import java.util.Scanner;

public class Comparenumberset {
	public static void main(String[] args) {  // main 함수
		
		Scanner scanner = new Scanner(System.in);  // scanner 객체 생성
		
		System.out.println("hw0_2 : 임수빈");  // 문구 출력
		System.out.println("양의 정수 집합을 비교하는 프로그램입니다.\n");  // 문구 출력
		
		int[] a = new int[100];  // 크기가 100인  양의 정수 배열 a 생성
		int[] b = new int[100];  // 크기가 100인  양의 정수 배열 b 생성
		
		int acount = 0;  // 배열 a에 입력된 개수를 세기 위한 변수
		int bcount = 0;  // 배열 b에 입력된 개수를 세기 위한 변수 
		
		System.out.print("첫번째 집합을 입력하세요. 집합 입력을 마치려면 양이 아닌 \n정수를 입력하세요 : "); //안내문 출력
		
		for(int i=0;i<a.length;i++) {  // 첫번째 집합 입력
			a[i] = scanner.nextInt();  // 정수 입력
			acount++;   // 입력된 개수만큼 1씩 증가
			if(a[i]<0) { // 만약 양의 정수가 아닌 값이면
				break;  // 반복문 탈출
			}
		}
		
		System.out.println();  // 개행
		
		System.out.print("두번째 집합을 입력하세요. 집합 입력을 마치려면 양이 아닌 \n정수를 입력하세요 : "); // 안내문 출력
		
		for(int i=0;i<b.length;i++) {  // 두번째 집합 입력
			b[i] = scanner.nextInt();			
			bcount++;  // 입력된 개수만큼 1씩 증가
			if(b[i]<0) {  // 만약 양의 정수가 아닌 값이면
				break;   // 반복문 탈출
			}
		}

		int asame=0;  // a배열을 기준으로 비교하면서 같은 원소 개수를 저장하는 변수
		int bsame=0;  // b배열을 기준으로 비교하면서 같은 원소 개수를 저장하는 변수

		if(acount==bcount) {  // a배열의 원소 개수와 b배열의 원소개수가 같으면
			for(int i=0;i<acount;i++) {   // a배열 기준으로 원소 비교
				for(int j=0;j<bcount;j++) {  // b배열 원소와 비교
					if(a[i]==b[j]) {   // a배열 원소와 b배열 원소가 같으면
						asame++;   // 1더하기
						break;    // 반복문 탈출
					}
				}
			}
			
			for(int i=0;i<bcount;i++) { 	// b배열 기준으로 원소 비교
				for(int j=0;j<acount;j++) {   // a배열 원소와 비교
					if(b[i]==a[j]) {  // b배열 원소와 a배열 원소가 같으면
						bsame++;	 // 1더하기
						break;		// 반복문 탈출
					}
				}
			}
		}
		
		if(asame==bsame && asame == acount)  // a배열과 b배열의 원소가 서로 같고  총 원소의 개수와도 같으면
			System.out.println("\n두 집합은 같습니다.");  // 같습니다 문자열 출력
		
		else   // 아니면
			System.out.println("\n두 집합은 서로 다릅니다.");  // 다릅니다 문자 출력
	}

}
