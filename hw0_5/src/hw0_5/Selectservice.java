package hw0_5;
//***************************
//파일명: Selectservice.java
//작성자: 임수빈
//작성일: 2020년 4월 14일
//내용: 선택알고리즘
//***************************

public class Selectservice{

	public static int select(int a[],int begin,int end,int i) {  // select 알고리즘
		
		if(begin==end)  //원소가 하나이면
			return a[begin];  
		
		int q = partition(a,begin,end);  //partition 알고리즘
		 
		int k = q-begin+1;  // 배열 a에서  k번째로 작은원소
		
		if(i<k)  //찾고자하는 i번째가  k번째 보다 작으면
			return select(a,begin,q-1,i); 
		
		else if(i==k) //i번째와 k번째가 같으면
			return a[q];  //i번째로 작은 원소 리턴
		
		else  //찾고자하는 i번째가  k번째 보다 크면
			return select(a,q+1,end,i-k);
	}
	
	public static int partition(int a[],int begin,int end) {  //partition 알고리즘
		int pivot = end;  // pivot은 맨 마지막 인덱스 기준값 인덱스
		int i=begin-1;  // i는 배열첫번째 인덱스-1
		int j = begin;  // j는 배열 첫번째 인덱스
		int tmp;  // 임시 저장변수

		while (j < end) {  // 반복문
            if (a[j] < a[pivot]) {  //만약 j번째 값이 기준값보다 작으면
                tmp = a[j];   // 임시저장
                a[j] = a[i + 1];  // i+1번째와 j번째 원소를 교환하여
                a[i + 1] = tmp;  // 기준값보다 작은 원소를 1구역으로 보낸다.
                i++;  // i 증가
            }
            j++;  // j 증가
        }
		
        tmp = a[pivot]; // 임시로 기준값 저장
        a[pivot] = a[i + 1];  // 2구역 첫번째 원소와 기준값을 서로 교환한다.
        a[i + 1] = tmp;  //교환한다.
         
		return i+1; //기준값 위치 리턴
	}
}
