package openaddress;

public class Quadratic {
	private int[] table;  // 해시테이블
	private int m;   //해시테이블 크기
	private static final int EMPTY = -1;  // 비어있는 자리임을 나타내는 값
	private static final int DELETED = -2; // 삭제된 자리임을 나타내는 값
	
	//크기가 size인 해시테이블 생성
	public Quadratic(int size) {  
		table = new int[size];
		m = size;   //배열크기 
		
		for(int i=0;i<size;i++) {   // 배열을 비어있는 공간으로 설정
			table[i] = EMPTY;
		}
	}
	
	// 해시테이블에 key값을 삽입하고 삽입 성공 여부를 리턴
	public boolean put(int key) {  
		
		int i=0;   // i번째 변수
		int j=0;  //해시값 저장변수 
		
		do {
			j = hash(i,key);  // 해시값 저장
			
			if(table[j]==EMPTY || table[j]==DELETED) {  //해시값 주소위치가 비어있으면 저장한다.
				table[j] = key;  // 키값 저장
				return true;
			}
			
			else 
				i++;  //1씩 점프
			
		}while(i!=m);  // 해시테이블 크기만큼 비어있는 공간을 찾지 못하면 삽입 실패
		
		return false;  
	}
	
	// 해시 테이블에 key값을 검색하여 인덱스를 리턴, 검색 실패시 -1리턴
	private int search(int key) {
		
		int i=0;   // i번째 변수
		int j=0;  //해시값 저장변수
		
		do {
			j = hash(i,key);  // 해시값 저장
			
			if(table[j]==key) {   // key값을 찾으면  
				return j;    //인덱스 리턴
			} 
			
			else 
				i++;
			
		}while(table[j]!=EMPTY || i!=m);  // 해시 테이블 공간이 비어있거나  테이블 크기만큼 될때까지 찾지 못하면 검색 실패
		
		return -1;
	}
	
	//해시테이블에서 key값을 검색하고 검색 성공 여부를 리턴
	public boolean contains(int key) {  
		int index = search(key);  // 검색하여 리턴된 인덱스 저장
		return (index>=0);    // 음수면 false 아니면 true
	}
	
	
	//해시테이블에서 key값을 삭제하고 삭제 성공 여부를 리턴
	public boolean remove(int key) {  

		int i=0;   // i번째 변수
		int j=0;  //해시값 저장변수   
		
		do {
			j = hash(i,key);  // 해시값 저장
			
			if(table[j]==key) {    //해시값 주소위치 원소가 key 값이면
				table[j] = DELETED;  // 삭제하고 DELETED 상수값을 저장한다.
				return true;
			}
			
			else 
				i++;
			
		}while(i!=m);  // 해시 테이블 크기만큼 key값을 찾지 못하면 삭제 실패
		
		return false;
	}
	
	
	//해시테이블의 구현을 확인하기 위해 해시 테이블의 구조를 모두 출력
	public void print() {  
		
		System.out.println("해시테이블 내용:");
		
		for(int i=0;i<m;i++) {
			if(table[i]==EMPTY)  //비어있는 자리 
				System.out.println("["+i+"]");
			
			else if(table[i]==DELETED)  //삭제한 자리
				System.out.println("["+i+"] DELETED");
			
			else
				System.out.println("["+i+"] "+table[i]);
		}
	}
	
	//division method 해시 함수 h(x) = x mod m
	private int hash(int x) {
		int hx = x % m;  
		return hx;
	}
	
	//linear probing i번째 해시 함수 hi(x) = (h(x) + i) mod m
	private int hash(int i, int x) {
		int hix = (hash(x)+i*i) % m;
		return hix;
	}
}
