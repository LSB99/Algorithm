package hw0_5;
//***************************
//���ϸ�: Selectservice.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 14��
//����: ���þ˰���
//***************************

public class Selectservice{

	public static int select(int a[],int begin,int end,int i) {  // select �˰���
		
		if(begin==end)  //���Ұ� �ϳ��̸�
			return a[begin];  
		
		int q = partition(a,begin,end);  //partition �˰���
		 
		int k = q-begin+1;  // �迭 a����  k��°�� ��������
		
		if(i<k)  //ã�����ϴ� i��°��  k��° ���� ������
			return select(a,begin,q-1,i); 
		
		else if(i==k) //i��°�� k��°�� ������
			return a[q];  //i��°�� ���� ���� ����
		
		else  //ã�����ϴ� i��°��  k��° ���� ũ��
			return select(a,q+1,end,i-k);
	}
	
	public static int partition(int a[],int begin,int end) {  //partition �˰���
		int pivot = end;  // pivot�� �� ������ �ε��� ���ذ� �ε���
		int i=begin-1;  // i�� �迭ù��° �ε���-1
		int j = begin;  // j�� �迭 ù��° �ε���
		int tmp;  // �ӽ� ���庯��

		while (j < end) {  // �ݺ���
            if (a[j] < a[pivot]) {  //���� j��° ���� ���ذ����� ������
                tmp = a[j];   // �ӽ�����
                a[j] = a[i + 1];  // i+1��°�� j��° ���Ҹ� ��ȯ�Ͽ�
                a[i + 1] = tmp;  // ���ذ����� ���� ���Ҹ� 1�������� ������.
                i++;  // i ����
            }
            j++;  // j ����
        }
		
        tmp = a[pivot]; // �ӽ÷� ���ذ� ����
        a[pivot] = a[i + 1];  // 2���� ù��° ���ҿ� ���ذ��� ���� ��ȯ�Ѵ�.
        a[i + 1] = tmp;  //��ȯ�Ѵ�.
         
		return i+1; //���ذ� ��ġ ����
	}
}
