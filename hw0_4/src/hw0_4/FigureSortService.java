package hw0_4;
import shape.Shape;
//***************************
//파일명: FigureSortService.java
//작성자: 임수빈
//작성일: 2020년 4월 10일
//내용: 정렬 관련 기능을 모아놓은 클래스
//***************************

public class FigureSortService {  //병합정렬 관련 기능을 모아놓은 클래스
	
	public static void mergeSort(Shape[] shape) { // mergeSort 메소드 - 도형 배열을 매개변수로 받는 static method
		int end = shape.length-1; // 배열의 마지막 인덱스를 end로 설정
		mergeSort(shape, 0, end);  //shape[0...end]를 정렬한다.
	}
	
	public static void mergeSort(Shape[] shape,int start, int end) { // 부분 배열을 정렬한다.
		
		if(start < end){ // 정렬할 원소가 2개이상인 경우
			int mid = (start+end)/2; // 중간지점 인덱스를 mid에 저장
			mergeSort(shape, start, mid); // 전반부 정렬
			mergeSort(shape, mid+1, end); // 후반부 정렬
			merge(shape, start,end);  // 병합
		}
	}

	public static void merge(Shape shape[],int start, int end) {  // 두 부분배열을 하나의 배열로 정렬한다.
		
		 int length = end - start + 1;   // 병합할 부분의 길이를 구한다.
		 int mid = (start+end)/2; // 중간지점 인덱스를 mid에 저장
		 Shape[] tmp = new Shape[length];   // 병합 결과를 저정할 임시 배열을 생성한다.
		 
		 int i = 0;   // 임시 배열에 대한 인덱스 변수
		 int index1 = start; // 앞부분(start ~ mid)에 대한 인덱스 변수
		 int index2 = mid+1; // 뒷부분(mid+1 ~ end)에 대한 인덱스 변수
	    
		 while (index1 <= mid && index2 <= end) { // 병합할 값이 앞부분과 뒷부분에 둘 다 남아 있다면
	            if (shape[index1].getArea() < shape[index2].getArea()) // 앞부분과 뒷부분의 선두의 면적을 비교하여
	                tmp[i++] = shape[index1++];   // 더 작은 값이 임시 배열에 먼저 들어간다
	            
	            else if(shape[index1].getArea() > shape[index2].getArea())
	                tmp[i++] = shape[index2++];
	            
	            else if(shape[index1].getArea() == shape[index2].getArea())  // 비교하는 값이 서로 같으면
	            		tmp[i++] = shape[index1++];   // 앞의 배열 원소를 집어넣는다. 
	     }
	    	 
		 while (index1 <= mid)   // 앞부분 배열에 남아있는 값을 임시 배열에 넣는다.
	            tmp[i++] = shape[index1++];
	       
		 while (index2 <= end)   // 뒤부분 배열에 남아있는 값을 임시 배열에 넣는다.
	            tmp[i++] = shape[index2++];
		 
		  for (i = 0; i < tmp.length; ++i)  // 임시 배열의 내용을  shape 배열의 start 위치에 복사한다.
			  shape[start + i] = tmp[i];      
	}
}
