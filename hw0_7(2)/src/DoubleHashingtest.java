import java.util.Scanner;

import openaddress.DoubleHashing;

public class DoubleHashingtest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Double Hashing 더블 해싱");
		System.out.print("해시테이블 크기 입력:");
		
		int size = scanner.nextInt();
		
		DoubleHashing studentTable = new DoubleHashing(size);  //해시테이블 객체 생성
		
		int menu = 0;
		do {
			
			System.out.print("\n1:삽입  2:검색  3:삭제  4:테이블출력  5:종료 --->");
			menu = scanner.nextInt();
			
			switch(menu) {
			
			case 1:
				System.out.print("삽입할 학번(정수값)을 입력하세요:");
				int id = scanner.nextInt();
				
				if(studentTable.put(id)) {
					System.out.println(id+" 삽입성공");
				}
				
				else {
					System.out.println(id+" 삽입실패");
				}
				break;
				
			case 2:
				System.out.print("검색할 학번(정수값)을 입력하세요:");
				id = scanner.nextInt();
				
				if(studentTable.contains(id)) {
					System.out.println(id+" 학생을 찾았습니다.");
				}
				
				else {
					System.out.println(id+" 학생을 찾을 수 없습니다.");
				}
				break;
				
			case 3:
				System.out.print("삭제할 학번(정수값)을 입력하세요:");
				id = scanner.nextInt();
				
				if(studentTable.remove(id)) {
					System.out.println(id+" 삭제성공");
				}
				
				else {
					System.out.println(id+" 삭제실패");
				}
				break;
				
			case 4:
				studentTable.print();
				break;
				
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
				
			default:
					System.out.println("메뉴 번호가 잘못되었습니다. 다시 입력하세요.");
			}
			
		}while(menu!=5);
		
		scanner.close();
	}
}
