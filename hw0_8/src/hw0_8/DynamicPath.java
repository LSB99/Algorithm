package hw0_8;
//***************************
//파일명: DynamicPath.java
//작성자: 임수빈
//작성일: 2020년 5월 19일
//내용: 행렬 경로 문제  동적프로그래밍 알고리즘
//***************************

public class DynamicPath {
	
	private int[][] m;  // 행렬 m
	private int[][] c;  // 배열 c
	private String[] s;  // 최대 점수 경로를 저장할 배열

	public DynamicPath(int n) {  // 생성자
		m = new int[n][n];  // n x n 행렬
		c = new int[n+1][n+1]; // (n+1) x (n+1) 배열 c
	}
	
	public void put(int[][] array, int n) {  // 행렬 원소 복사
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				m[i][j] = array[i][j];
			}
		}
	}
	
	public int matrixPath(int n) {  //(1,1) 부터 (n,n)에 이르는  최고점수
		
		for(int i=0;i<=n;i++) {  // 배열 c  0행을  0으로 초기화
			c[i][0] = 0;
		}
		
		for(int j=1;j<=n;j++) {  // 배열 c  0열을  0으로 초기화
			c[0][j] = 0;
		}
		
		for(int i=1;i<=n;i++) {    // 최고점수를 구하는 반복문
			for(int j=1;j<=n;j++) {
				c[i][j] = m[i-1][j-1]+max(c[i-1][j], c[i][j-1]);
			}
		}
		
		return c[n][n];  // 최고점수를 리턴한다.
	}
	
	public int max(int n1, int n2) {
		
		if(n1>n2) {  // n1이 n2보다 크면
			return n1;
		}
		
		else if(n2>n1) { // n2가 n1보다 크면
			return n2;
		}
		
		else   // 두 수가 같으면
			return n1;
	}
	
	public void maxscorepath(int n) {  // 최대 점수 경로를 역으로 출력한다.
		
		int i=n;  //행을 표시할 변수
		int j=n;  // 열을 표시할 변수
		int index=0; // 최대 점수 경로 배열 s 인덱스
		
		s = new String[n*n];
		s[index] = "("+n+","+n+")"; // 최대 점수 위치 저장
		index++;
		
		while(true) {
			if(i==1 && j-1==1) {  // 시작원소 바로 옆이면
				s[index] = "("+1+","+1+")";  // (1,1) 저장
				break;
			}
			
			if(i-1==1 && j==1) {  // 시작원소 바로 옆이면
				s[index] = "("+1+","+1+")";  // (1,1) 저장
				break;
			}
		
			if(c[i-1][j] > c[i][j-1]) {  // 현재 원소의  바로 위의 원소가  바로 왼쪽 원소보다 크다면
				int n1 = i-1;
				int n2 = j;
			
				s[index] = "("+n1+","+n2+")";
				
				i--;
				index++;
				continue;
			}
			
			else if(c[i][j-1] > c[i-1][j] ) {  // 현재 원소의  바로 왼쪽 원소가  바로 위의 원소보다 크다면
				int n1 = i;
				int n2 = j-1;
				
				s[index] = "("+n1+","+n2+")";
				
				j--;
				index++;
				continue;
			}
			
			else if(c[i][j-1]==c[i-1][j]) {  // 현재 원소의  바로 위의 원소와 왼쪽 원소가 같으면  위의 원소로 올라가도록 설정
				int n1 = i-1;
				int n2 = j;
			
				s[index] = "("+n1+","+n2+")";
				
				i--;
				index++;
				continue;
			}
		}
		
		for(int k=index;k>=0;k--) {  // 최대 점수 경로를 저장한 배열을 출력한다.
			System.out.print(s[k]+" ");
		}
	}
}
