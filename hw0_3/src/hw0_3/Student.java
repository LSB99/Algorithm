package hw0_3;
//***************************
//파일명: Student.java
//작성자: 임수빈
//작성일: 2020.03.30
//내용: [hw3_1] Student 클래스
//***************************

public class Student {
	private String name;  //성명
	private int id;   //학번
	private double grade;  //성적
	
	public Student() {  // 기본 생성자
		
	}
	
	public Student(String name, int id, double grade) {  // 학생정보 대입하는 생성자
		this.name = name;  //성명 대입
		this.id = id;      // 학번 대입
		this.grade = grade;  // 성적 대입
	}
	
	public String getName() {	//이름 리턴
		return this.name;
	}
	
	public int getid() {   // 학번을 리턴하는 메소드
		return this.id;
	}

	
	public double getGrade() {	//점수 리턴
		return this.grade;
	}
}
