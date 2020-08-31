package hw0_4;
import shape.Shape;
//***************************
//파일명: HeapSortService.java
//작성자: 임수빈
//작성일: 2020년 4월 10일
//내용: 정렬 관련 기능을 모아놓은 클래스
//***************************
public class HeapSortService {  //힙 정렬 기능클래스

	public static void heapSort(Shape[] shape){  // 힙정렬 메소드
		
		buildHeap(shape); // 힙 만들기
	    int size= shape.length - 1; // 배열 마지막 인덱스 저장
	    
	    for(int i = size; i > 0; i--) {
	    	swap(shape, 0, i); // 루트인 최대값과 마지막 노드를 바꾼다.
	    	size= size-1; // 마지막 최대값을 제외한 나머지 노드로
	        heapify(shape, 0, size); // 다시 최대힙을 구성한다.
	    }
	}
	
	public static void buildHeap(Shape[] shape) { // 최대힙으로 구성하는 메소드
		
	    for(int i =(shape.length - 1)/2; i >= 0; i--) { // 배열 가운데를 기준으로 반복문을 돌린다.
	        heapify(shape, i, shape.length - 1);  //힙 재구성
	    }
	}

	public static void heapify(Shape[] shape, int i, int size) {  // 힙 재구성 메소드
	    int left = 2 * i + 1; // 왼쪽 자식 인덱스 
	    int right = 2* i + 2; // 오른쪽 자식 인덱스
	    int max = i; // 부모노드 인덱스 대입

	    if(left <= size && shape[left].getArea() > shape[max].getArea()) {  // 왼쪽자식 면적이 제일 크다면
	        max = left;
	    } 
	 
	    if(right <= size && shape[right].getArea() > shape[max].getArea()) {  //오른쪽 자식 면적이 제일 크다면
	        max = right;
	    }

	    if(max != i) {   // 만약 부모노드 면적보다 자식 노드 면적이 더 크다면
	        swap(shape, i, max);  // 교환한다.
	        heapify(shape, max, size); // 교환한 max(부모)노드를 기준으로 자식 노드들과 비교한다. 
	    }
	}

	public static void swap(Shape[] shape, int i, int max) {  // 교환 메소드
	    Shape temp = shape[i];  // 부모 노드를 temp에 저장
	    shape[i] = shape[max];  // 부모노드 위치에 자식노드 저장
	    shape[max] = temp;  //자식노드 위치에 부모노드 저장
	}
}
