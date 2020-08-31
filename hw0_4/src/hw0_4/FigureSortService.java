package hw0_4;
import shape.Shape;
//***************************
//���ϸ�: FigureSortService.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 10��
//����: ���� ���� ����� ��Ƴ��� Ŭ����
//***************************

public class FigureSortService {  //�������� ���� ����� ��Ƴ��� Ŭ����
	
	public static void mergeSort(Shape[] shape) { // mergeSort �޼ҵ� - ���� �迭�� �Ű������� �޴� static method
		int end = shape.length-1; // �迭�� ������ �ε����� end�� ����
		mergeSort(shape, 0, end);  //shape[0...end]�� �����Ѵ�.
	}
	
	public static void mergeSort(Shape[] shape,int start, int end) { // �κ� �迭�� �����Ѵ�.
		
		if(start < end){ // ������ ���Ұ� 2���̻��� ���
			int mid = (start+end)/2; // �߰����� �ε����� mid�� ����
			mergeSort(shape, start, mid); // ���ݺ� ����
			mergeSort(shape, mid+1, end); // �Ĺݺ� ����
			merge(shape, start,end);  // ����
		}
	}

	public static void merge(Shape shape[],int start, int end) {  // �� �κй迭�� �ϳ��� �迭�� �����Ѵ�.
		
		 int length = end - start + 1;   // ������ �κ��� ���̸� ���Ѵ�.
		 int mid = (start+end)/2; // �߰����� �ε����� mid�� ����
		 Shape[] tmp = new Shape[length];   // ���� ����� ������ �ӽ� �迭�� �����Ѵ�.
		 
		 int i = 0;   // �ӽ� �迭�� ���� �ε��� ����
		 int index1 = start; // �պκ�(start ~ mid)�� ���� �ε��� ����
		 int index2 = mid+1; // �޺κ�(mid+1 ~ end)�� ���� �ε��� ����
	    
		 while (index1 <= mid && index2 <= end) { // ������ ���� �պκа� �޺κп� �� �� ���� �ִٸ�
	            if (shape[index1].getArea() < shape[index2].getArea()) // �պκа� �޺κ��� ������ ������ ���Ͽ�
	                tmp[i++] = shape[index1++];   // �� ���� ���� �ӽ� �迭�� ���� ����
	            
	            else if(shape[index1].getArea() > shape[index2].getArea())
	                tmp[i++] = shape[index2++];
	            
	            else if(shape[index1].getArea() == shape[index2].getArea())  // ���ϴ� ���� ���� ������
	            		tmp[i++] = shape[index1++];   // ���� �迭 ���Ҹ� ����ִ´�. 
	     }
	    	 
		 while (index1 <= mid)   // �պκ� �迭�� �����ִ� ���� �ӽ� �迭�� �ִ´�.
	            tmp[i++] = shape[index1++];
	       
		 while (index2 <= end)   // �ںκ� �迭�� �����ִ� ���� �ӽ� �迭�� �ִ´�.
	            tmp[i++] = shape[index2++];
		 
		  for (i = 0; i < tmp.length; ++i)  // �ӽ� �迭�� ������  shape �迭�� start ��ġ�� �����Ѵ�.
			  shape[start + i] = tmp[i];      
	}
}
