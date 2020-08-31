package hw12;
import java.util.HashMap;
//***************************
//파일명: BoyerMooreHorspool.java
//작성자: 임수빈
//작성일: 2020년 6월 17일
//프로그램 설명: Boyer-Moore-Horspool 알고리즘  구현 클래스 
//***************************

public class BoyerMooreHorspool {
	
	HashMap<String, Integer> jump;  //  jump table
	
	private int count = 0;   //  점프 수 변수
	
	private char[] pattern;  //  패턴 배열
	private char[] text;    //  텍스트 배열
	
	public BoyerMooreHorspool(char P[], char A[]) {  //  P[] = 패턴문자열  , A[] = 텍스트 문자열  
		
		pattern = new char[P.length];
		text = new char[A.length];
		jump = new HashMap<String, Integer>();
		
		pattern = P;  // 패턴 문자열 대입
		text = A;    // 텍스트 문자열 대입
		
		computeJump(pattern);  // 패턴 문자열에 대한  점프 테이블을 완성한다.
	}
	
	public void computeJump(char P[]) {  // 점프테이블을 완성하는 함수
		
		int size = P.length;  // size 변수에  패턴문자열 길이를 저장
		
		for(int i=0; i<size;i++) {  //  패턴 문자열의  마지막 원소 전까지 반복한다.
			
			if(i==size-1) {  // 패턴 문자열의 마지막 원소일때
				
				if(!jump.containsKey(String.valueOf(P[size-1]))) {  // 맨마지막 원소가 존재하지 않은 키값이면
					jump.put(String.valueOf(P[size-1]), P.length);  // 맨 마지막 원소는  패턴 배열 길이만큼 점프
				}
			}
			
			else {    // 패턴 문자열의 마지막 원소가 아닐때
				
				if(jump.containsKey(String.valueOf(P[i]))) {  //  이미 존재하는 키값인 경우
					
					int n = jump.get(String.valueOf(P[i]));   // 존재하는 키값을  n에 저장한다.
					
					if(n>P.length-i-1) {   //  이미 존재하는 키값이  더 크다면   작은 값으로 변경한다.
						jump.remove(String.valueOf(P[i]));   
						jump.put(String.valueOf(P[i]), P.length-i-1);
					}
				}
				
				
				else {   //  존재하지 않은  키값인 경우 
					jump.put(String.valueOf(P[i]), P.length-i-1);
				}	
				
			}
		}
		
		jump.put("기타", P.length);  // 기타문자의 점프 번호 저장
	}
	
	public void match() {  // 패턴 문자열과  텍스트 문자열을  매칭하는 함수 
		
		int m = pattern.length;   // 패턴 문자열 길이
		int n = text.length;     //  텍스트 문자열 길이
		int i = 0;    
		
		while(i<=n-m) {
			
			int j = m-1;
			int k = i+m-1;
			
			while(j>=0 && pattern[j]==text[k]) {  // 패턴 문자열과 텍스트 문자열이 일치하는지 확인
				j--;
				k--;
			}
			
			if(j<0) {   // 패턴 문자열과 텍스트 문자열이 일치하면
				
				System.out.print(i+" ");  //  텍스트 문자열의  i 자리에서 매칭이 일어났다고 출력한다.
			}
			
			if(jump.containsKey(String.valueOf(text[i+m-1]))){  // 패턴문자열에 포함되는 문자인 경우
				
				i = i+jump.get(String.valueOf(text[i+m-1]));  // 해당 문자 점프번호로  점프한다.
				count++;  
				
			}
			
			else if(!jump.containsKey(String.valueOf(text[i+m-1]))) {  // 포함되지 않고 기타문자인 경우
				
				i = i+jump.get("기타");  // 기타문자  점프번호로  점프한다.
				count++;   
				
			}
		}
	}
	
	public int jumpcount() {  // 점프 수 리턴
		return count;
	}
}
