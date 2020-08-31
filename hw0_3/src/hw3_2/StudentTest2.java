package hw3_2;
import hw0_3.Student;  // Student 클래스 import
import java.util.Scanner;
//***************************
//파일명: StudentTest2.java
//작성자: 임수빈
//작성일: 2020년 4월 2일
//내용: 선택 정렬(selection sort) 알고리즘을 이용하여 학생을 성명 오름차순으로 정렬하는 자바 프로그램을 작성하시오.
//***************************

public class StudentTest2 {		// StudentTest2 클래스
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);  // scanner 객체 생성
		
		System.out.println("hw3_2 : 임수빈 \n");  // 과제코드 이름 출력
		System.out.print("학생수 입력: ");  // 학생수 입력 문구 출력
		
		int n = scanner.nextInt();   // 학생 수(n)를 입력받는다.
		
		Student[] student = new Student[n];  // 크기가 n인 학생 배열을 만든다.
		
		System.out.println("\n"+n+"명의 학생 정보를 입력하세요: ");   // 문구 출력
		
		String name = "";  // 성명을 입력받을 변수
		int id = 0;    // 학번을 입력받을 변수
		double grade = 0;   // 성적을 입력받을 변수 
		
		for(int i=0;i<n;i++) {    // 학생정보를 입력받는 반복문
			name = scanner.next();  // 성명을 입력한다.
			id = scanner.nextInt();  // 학번을 입력한다.
			grade = scanner.nextDouble();  // 성적을 입력한다.
			
			student[i] = new Student(name, id, grade);  // 생성자를 통해서 성명 , 학번 , 성적 대입
		}
		
		Student temp = new Student();  // 임시로 학생정보를 저장할 Student 객체 생성
		int max = 0;   // 뒷 순서 성명을 가진 학생의 순서 저장변수
		
		for(int i=n-1;i>=1;i--) {  // 선택정렬 , 현재 배열의 마지막 인덱스부터 시작한다.
			max = i;  						 // 현재 마지막 배열원소 인덱스 i를  max에 저장한다.
			for(int j=i-1;j>=0;j--) {      // 비교가 끝난 마지막 원소를 제외하고  맨 뒷 순서인 성명을 찾는 반복문
				String s1 = student[max].getName();  // 현재 맨 뒷 순서의 학생성명을 대입한다.
				String s2 = student[j].getName();   // 현재 비교하려는 학생성명을 대입한다.

				if(s2.compareTo(s1) > 0) {  // 현재 비교한 학생성명이 가장 맨 뒷순서 성명보다 더 뒤에 있으면
					max = j;  // 현재 비교한 학생의 순서를  max에 대입한다.
				}
			}
			temp = student[max];  // 비교 한 값들 중 성명이 가장 뒷 순서인 학생 정보를 저장한다.
			student[max] = student[i];  // max가 있던 위치에  현재 배열의 마지막 위치 i번째 있던 학생정보를 대입한다.
			student[i] = temp;     // 그리고 맨 마지막 위치 i번째에 성명이 가장 뒷 순서인 학생 정보를 저장한다.
		} 
		
		System.out.println("\n성명 오름차순 정렬 결과 = ");   // 오름차순 정렬 결과 문구 출력
		
		for(int i=0;i<n;i++) {   // 학생 배열 길이만큼 반복한다.
			System.out.print(student[i].getName()+" ");  // 성명 출력
			System.out.print(student[i].getid()+" ");   // 학번 출력
			System.out.println(student[i].getGrade());  // 성적 출력
		}
		
	}

}
