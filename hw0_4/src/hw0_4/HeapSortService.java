package hw0_4;
import shape.Shape;
//***************************
//���ϸ�: HeapSortService.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 10��
//����: ���� ���� ����� ��Ƴ��� Ŭ����
//***************************
public class HeapSortService {  //�� ���� ���Ŭ����

	public static void heapSort(Shape[] shape){  // ������ �޼ҵ�
		
		buildHeap(shape); // �� �����
	    int size= shape.length - 1; // �迭 ������ �ε��� ����
	    
	    for(int i = size; i > 0; i--) {
	    	swap(shape, 0, i); // ��Ʈ�� �ִ밪�� ������ ��带 �ٲ۴�.
	    	size= size-1; // ������ �ִ밪�� ������ ������ ����
	        heapify(shape, 0, size); // �ٽ� �ִ����� �����Ѵ�.
	    }
	}
	
	public static void buildHeap(Shape[] shape) { // �ִ������� �����ϴ� �޼ҵ�
		
	    for(int i =(shape.length - 1)/2; i >= 0; i--) { // �迭 ����� �������� �ݺ����� ������.
	        heapify(shape, i, shape.length - 1);  //�� �籸��
	    }
	}

	public static void heapify(Shape[] shape, int i, int size) {  // �� �籸�� �޼ҵ�
	    int left = 2 * i + 1; // ���� �ڽ� �ε��� 
	    int right = 2* i + 2; // ������ �ڽ� �ε���
	    int max = i; // �θ��� �ε��� ����

	    if(left <= size && shape[left].getArea() > shape[max].getArea()) {  // �����ڽ� ������ ���� ũ�ٸ�
	        max = left;
	    } 
	 
	    if(right <= size && shape[right].getArea() > shape[max].getArea()) {  //������ �ڽ� ������ ���� ũ�ٸ�
	        max = right;
	    }

	    if(max != i) {   // ���� �θ��� �������� �ڽ� ��� ������ �� ũ�ٸ�
	        swap(shape, i, max);  // ��ȯ�Ѵ�.
	        heapify(shape, max, size); // ��ȯ�� max(�θ�)��带 �������� �ڽ� ����� ���Ѵ�. 
	    }
	}

	public static void swap(Shape[] shape, int i, int max) {  // ��ȯ �޼ҵ�
	    Shape temp = shape[i];  // �θ� ��带 temp�� ����
	    shape[i] = shape[max];  // �θ��� ��ġ�� �ڽĳ�� ����
	    shape[max] = temp;  //�ڽĳ�� ��ġ�� �θ��� ����
	}
}
