package hw3_3;
import hw0_3.Student;  // Student 클래스 import
import java.util.Scanner;
//***************************
//파일명: Student3.java
//작성자: 임수빈
//작성일: 2020년 4월 3일
//내용: 버블 정렬(bubble sort) 알고리즘을 이용하여 학생을 성적 내림차순으로 정렬하는 자바 프로그램을 작성하시오.
//***************************

public class StudentTest3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);  // scanner 객체 생성
		
		System.out.println("hw3_3 : 임수빈 \n");  // 과제코드 이름 출력
		System.out.print("학생수 입력: ");  // 학생수 입력 문구 출력
		
		int n = scanner.nextInt();   // 학생 수(n)를 입력받는다.
		
		Student[] student = new Student[n];  // 크기가 n인 student 배열을 만든다.

		System.out.println("\n"+n+"명의 학생 정보를 입력하세요: "); // 문구 출력
		
		String name = "";  // 성명을 입력받을 변수
		int id = 0;        // 학번을 입력받을 변수
		double grade = 0;   // 성적을 입력받을 변수 
		
		for(int i=0;i<n;i++) {    // 학생정보를 입력받는 반복문
			name = scanner.next();  // 성명을 입력한다.
			id = scanner.nextInt();  // 학번을 입력한다.
			grade = scanner.nextDouble();  // 성적을 입력한다.
			
			student[i] = new Student(name, id, grade);  // 생성자를 통해서 성명 , 학번 , 성적 대입
		}
		
		
		Student temp = new Student();  // 임시로 학생정보를 저장할 Student 객체 생성
		
		boolean sorted;   // 교환여부를 확인하는 변수
		
		for(int i=n-1;i>=1;i--) {  // 버블 정렬
			sorted = true;   // 교환이 일어나지 않은상태를  true로 설정한다.
			
			for(int j=0;j<i;j++) {   		// 비교가 끝난 원소 전까지 서로 비교를한다.
				double grade1 = student[j].getGrade();   // j번째 학생 성적 대입
				double grade2 = student[j+1].getGrade();  // 바로 다음 j+1번째 학생 성적 대입
				
				if(grade2>grade1) {  // 만약 바로다음 학생의 성적이  바로 앞에 있는 학생의 성적보다 크면
					temp = student[j+1];   // temp에 바로 다음 학생의 정보를 저장한다.
					student[j+1] = student[j];  // 바로 다음 학생의 위치에 바로 앞에 있던 학생정보를 저장한다.
					student[j] = temp;   // 바로 앞에 있던 학생의 위치에  바로 다음에 있던 학생정보를 저장하여 서로 교환한다.
					sorted = false;   // 교환이 일어났으므로 false를  대입
				}
			}
			
			if(sorted == true)  // 만약 교환이 일어나지 않으면 정렬이 다 되었으므로
				break;   // 반복문을 탈출한다.
		}
		
		System.out.println("\n성적 내림차순 정렬 결과 = ");  //내림차순 정렬결과 
		
		for(int i=0;i<n;i++) {   // 학생 배열 길이만큼 반복한다.
			System.out.print(student[i].getName()+" ");  //학생 이름 출력
			System.out.print(student[i].getid()+" ");   // 학생 학번 출력
			System.out.println(student[i].getGrade()); //  학생 성적 출력
		}
		
	}
}
