package example;

import java.util.Scanner;

public class example {
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

		for(int i=0;i<acount;i++) {  // 배열 a를 오름차순으로 정렬하는 반복문
			for(int j=0;j<acount;j++) {  // a[i]를 기준으로 j를 하나씩 늘려가며 비교를 한다. 
				if(a[i]<a[j]) {  // a[j]원소가 더 크면
					int tmp = a[j];  // 임시 tmp 변수에 a[j] 원소를 저장한다.
					a[j] = a[i];  // j번 위치에 a[i] 원소 값을 대입하고
					a[i] = tmp; // i번 위치에 a[j]원소를 저장한 tmp 변수 값을 대입한다.
				}
			}
		}
		
		
		for(int i=0;i<bcount;i++) {  // 배열 b를 오름차순으로 정렬
			for(int j=0;j<bcount;j++) { // b[i]를 기준으로 j를 하나씩 늘려가며 비교를 한다. 
				if(b[i]<b[j]) {   // b[j]원소가 더 크면
					int tmp = b[j]; // 임시 tmp 변수에 b[j] 원소를 저장한다.
					b[j] = b[i];  // j번 위치에 b[i] 원소 값을 대입하고
					b[i] = tmp;  // i번 위치에 b[j]원소를 저장한 tmp 변수 값을 대입한다.
				}
			}
		}
		
	
		boolean c = true;   // 두 집합이 동일한지 알기 위해 사용되는 변수
		
		for(int i=0;i<acount;i++) {  // 반복문 
			if(a[i]==b[i])  // 만약 배열 a의 원소와 배열 b의 원소가 같다면
				continue;  // 계속 반복
			
			else if(a[i]!=b[i]) {  // 배열 a의 원소와 배열 b의 원소가 다르면 
				c=false;   // 변수 c에 false 대입
				break;  // 반복문 탈출
			}
		}
		
		if(c==true)  // 변수 c가 true이면
			System.out.println("\n두 집합은 같습니다.");  // 같습니다 문자열 출력
		
		else if(c==false)  // 변수 c가 false이면 
			System.out.println("\n두 집합은 서로 다릅니다.");  // 다릅니다 문자 출력
	}
}
