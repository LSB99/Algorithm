package hw0_8;

public class PutStone {

	private int[][] w;  //  
	private int[][] peb; 
	
	public PutStone(int row, int col) {  // 생성자
		w = new int[row][col];  // 3 x 5  테이블
		peb = new int[row+1][col]; // 4 x 5 배열
	}

	public void put(int[][] array, int row, int col) {  // w테이블 원소 대입  row = 행의 크기  ,  column = 열의 크기
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				w[i][j] = array[i][j];
			}
		}
	}
		
	public int pebble(int row, int column) {  // row = 행의 크기  ,  column = 열의 크기
		
		int col = column-1;  //  열  인덱스 변수,  col = 마지막 열 인덱스
		
		for(int p=0;p<=row;p++) {  // c배열의 첫번째 열은   w배열의 첫번째 열을 그대로 대입한다.
			
			if(p==row) {   //  마지막 행이면
				peb[p][0] = w[0][0]+w[row-1][0];
				break;
			}
			
			peb[p][0] = w[p][0];
		}
		
		for(int i=1;i<=col;i++) {  //  c배열의 1열부터 대입한다.
			
			for(int p=0;p<=row;p++) {  //  p=0 : 패턴1 , p=1 : 패턴2 , p=2 : 패턴3 ,  p=3 :패턴4
				
				if(p==row) {  // peb 배열의  패턴 4 설정 
					peb[p][i] = w[0][i]+w[p-1][i] + max(i-1, p); 
					break;
				}
				
				peb[p][i] = w[p][i] + max(i-1, p);  //  max(바로 전 열의 인덱스, 패턴 번호)
			}
		}
		
		
		System.out.println("\npeb 배열 출력 : \n"); 
		
		for(int i=0;i<=row;i++) {    
			for(int j=0;j<=col;j++) {
				System.out.print(peb[i][j]+" ");  // peb 배열 출력
			}
			System.out.println();
		}
		
		
		int max = peb[0][col];  
		
		for(int i=1;i<=row;i++) {  // 돌 놓기 문제 최종값을 계산
			
			if(max<peb[i][col]) {  // 마지막 열 숫자끼리만 비교  col=마지막 열 인덱스
				max = peb[i][col];
			}
		}
	
		return max;
	}
	
	public int max(int col, int pattern) {  // 매개변수  col = 현재 배열 원소 열의  바로 전 열의 인덱스,  pattern = 패턴번호
		// 현재 배열 원소의 패턴과  서로 양립할 수 있는 패턴을 찾고 최대값을 리턴
	   //  pattern=0 : 패턴1 , pattern=1 : 패턴2 , pattern=2 : 패턴3 ,   pattern=3 :패턴4
		
		
		if(pattern==0) {  // 패턴이 1인 경우  패턴 2와 패턴 3중 최대값 리턴
			
			if(peb[1][col] >= peb[2][col]) {    // 패턴 2의 값이  패턴 3의 값보다 크거나 같으면
				return peb[1][col];
			}
			
			else if(peb[2][col] >= peb[1][col]) {  // 패턴 3의 값이  패턴 2의 값보다 크거나 같으면
				return peb[2][col];
			}
		}
		
		
		else if(pattern==1) {  // 패턴이 2인 경우   패턴 1, 패턴3, 패턴 4중  최대값 리턴
			
			if(peb[0][col] >= peb[2][col] && peb[0][col]>=peb[3][col]) {  // 패턴 1의 값이  패턴 3과   패턴 4보다 크거나  같은 경우
				return peb[0][col];
			}
			
			else if(peb[2][col] >= peb[0][col] &&  peb[2][col]>=peb[3][col]) {  //  패턴 3의 값이   패턴 1과   패턴 4보다 크거나  같은 경우
				return peb[2][col];
			}
			
			else if(peb[3][col] >= peb[0][col] &&  peb[3][col]>=peb[2][col]) {   //  패턴 4의 값이   패턴 1과  패턴 3보다 크거나  같은 경우
				return peb[3][col];
			}
		}
		
		
		else if(pattern==2) {  // 패턴이 3인 경우   패턴 1, 패턴 2 중 최대값 리턴
			
			if(peb[0][col] >= peb[1][col]) {  // 패턴 1의 값이  패턴 2의 값보다 크거나 같으면
				return peb[0][col];
			}
			
			else if(peb[1][col] >= peb[0][col]) {  // 패턴 2의 값이  패턴 1의 값보다 크거나 같으면
				return peb[1][col];
			}
		}
		
		
		else if(pattern==3) {  // 패턴이 4인 경우  패턴 2 값을 리턴	
			return peb[1][col];
		}	
		
		return -1;
	}
}
