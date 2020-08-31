package hw6_1;
import hw0_6.MyBinarySearchTree;
import java.util.Scanner;
//***************************
//파일명: MyBinarySearchTreeTest.java
//작성자: 임수빈
//작성일: 2020년 4월 21일
//내용: 메인클래스
//***************************

public class MyBinarySearchTreeTest {

	public static void main(String[] args) {
		System.out.println("hw6_1 : 임수빈\n");
		Scanner scanner = new Scanner(System.in);
		
		MyBinarySearchTree tree = new MyBinarySearchTree(); // 비어있는 MyBinarySearchTree 객체를 생성
		
		while(true) {  // 5(종료)를 할때까지 무한반복
			
			System.out.print("1:삽입  2:검색  3:삭제  4:전체조회  5:종료 >> ");
			int n = scanner.nextInt();  // 번호입력
			String s;  //아이디 변수
			
			if(n==1) {  // 1번 : 삽입
				System.out.print("삽입할 아이디를 입력하세요 : ");
				s = scanner.next();  //아이디 입력
				boolean state = tree.add(s);

				if(state) {  
					System.out.println(s+" 삽입 성공\n");
				}
				
				else {
					System.out.println(s+" 삽입 실패\n");
				}
			}
			
			else if(n==2) {  // 2번 :검사
				System.out.print("검색할 아이디를 입력하세요 : ");
				s = scanner.next();  //아이디 입력
				boolean state = tree.contains(s);
				
				if(state) {
					System.out.println(s+ " 검색 성공\n");
				}
				
				else {
					System.out.println(s+ " 검색 실패\n");
				}
			}
			
			else if(n==3) {  // 3번 :삭제
				System.out.print("삭제할 아이디를 입력하세요 : ");
				s = scanner.next();  //아이디 입력
				boolean state = tree.remove(s);
				
				if(state) {
					System.out.println(s+" 삭제 성공\n");
				}
				
				else {
					System.out.println(s+" 삭제 실패\n");
				}
			}
			
			else if(n==4) {  // 4번 :전체조회
				tree.print();
			}

			else if(n==5) {   // 5번 :종료
				System.out.println("종료합니다.");
				break;
			}
		}
	}
}
