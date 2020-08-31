package hw12_1;
import hw12.BoyerMooreHorspool;
import java.util.Scanner;
//***************************
//파일명: BoyerMooreHorspoolTest.java
//작성자: 임수빈
//작성일: 2020년 6월 17일
//프로그램 설명: Boyer-Moore-Horspool 알고리즘  main 클래스
//***************************

public class BoyerMooreHorspoolTest {
	
	public static void main(String[] args) {
		
		System.out.println("hw12_1 : 임수빈\n");
		Scanner scanner = new Scanner(System.in);  
		
		char[] pattern;  // 패턴 문자열을 받을  문자배열
		char[] text;    // 텍스트 문자열을 받을  문자배열
		
		System.out.print("패턴 입력 : ");
		String p = scanner.next();
		pattern = p.toCharArray();  // 문자열을  문자배열로 치환
		
		System.out.print("텍스트 입력 : ");
		String t = scanner.next();
		text = t.toCharArray();   // 문자열을  문자배열로 치환
		
		
		BoyerMooreHorspool bmh = new BoyerMooreHorspool(pattern,text);  // 객체 생성하고 매개변수로  패턴, 텍스트 값을 넘겨준다.
		
		System.out.print("매칭 위치 = ");
	    bmh.match();   // 매칭 위치 출력
		
		System.out.print("\n점프 수 = ");
		System.out.println(bmh.jumpcount());  //  점프 수 출력
		
	}
}
