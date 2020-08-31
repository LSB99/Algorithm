package hw3_1;
import java.util.Scanner;
//***************************
//파일명: hw3_1
//작성자: 임수빈
//작성일: 2020년 3월 31일
//내용: 학생을 나타내는 클래스를 정의하고 이용하는 자바 프로그램을 작성한다.
//***************************

class Student{  	// 학생정보 클래스 
	private String name = ""; // 성명
	private int id = 0;      // 학번
	private double grade = 0;  // 성적
	
	public void setname(String name) {  // 성명을 설정하는 메소드
		this.name = name;
	}
	
	public void setid(int id) {    // 학번을 설정하는 메소드
		this.id = id;
	}
	
	public void setgrade(double grade) {  // 성적을 설정하는 메소드
		this.grade = grade;
	}
	
	public String getname() {  // 성명을 리턴하는 메소드
		return this.name; 
	}
	
	public int getid() {   // 학번을 리턴하는 메소드
		return this.id;
	}
	
	public double getgrade() {  // 성적을 리턴하는 메소드
		return this.grade;
	}
}


public class StudentTest {   // StudentTest 클래스
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);  // scanner 객체 생성
		
		System.out.println("hw3_1 : 임수빈 \n");  // 과제코드와 이름 출력
		System.out.print("학생수 입력: ");     // 문구 출력
		
		int n = scanner.nextInt();   // 학생 수(n)를 입력받는다.
		
		Student[] student = new Student[n];  // 크기가 n인  student 배열을 만든다.
		
		System.out.println("\n"+n+"명의 학생 정보를 입력하세요: ");  // 문구 출력
		
		String name = "";  // 성명을 입력받을 변수
		int id = 0;    // 학번을 입력받을 변수
		double grade = 0;   // 성적을 입력받을 변수 
		
		double sum = 0;   // 학생들 성적 총합 변수 
		
		for(int i=0;i<n;i++) {   // 학생정보를 입력받는 반복문
			name = scanner.next();  // 성명을 입력한다.
			id = scanner.nextInt();  // 학번을 입력한다.
			grade = scanner.nextDouble();  // 성적을 입력한다.
			
			student[i] = new Student();  // student 배열 각 원소에 Student 객체 생성
			student[i].setname(name);    //  성명을 대입한다.
			student[i].setid(id);        // 학번을 대입한다.
			student[i].setgrade(grade);  // 성적을 대입한다.
			
			sum+=grade;  // 성적을 더한다.
		}
		
		System.out.println("\n성적 평균 = "+ sum/n);  // 성적평균값 출력
		
		double max = student[0].getgrade();  // 최고 성적을 나타내는 변수 
		int top = 0;   // 최고 성적을 받은 학생의 순서를 저장할 변수
		 
		for(int i=1;i<n;i++) {   // 최고점을 받은 학생을 찾기 위한 반복문
			
			if(max<student[i].getgrade()) {  // 만약 현재 점수보다 더 높은 점수이면
				max = student[i].getgrade();  // 더 높은 점수로 바꾼다.
				top = i;   // 최고 성적을 받은 학생의 순서를 저장한다.
			}
		}
		
		System.out.println("\n수석 학생 성명 = "+ student[top].getname());  // 최고점 학생의 성명 출력
	}
}
