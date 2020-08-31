package hw0_8;

public class PutStone {

	private int[][] w;  //  
	private int[][] peb; 
	
	public PutStone(int row, int col) {  // ������
		w = new int[row][col];  // 3 x 5  ���̺�
		peb = new int[row+1][col]; // 4 x 5 �迭
	}

	public void put(int[][] array, int row, int col) {  // w���̺� ���� ����  row = ���� ũ��  ,  column = ���� ũ��
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				w[i][j] = array[i][j];
			}
		}
	}
		
	public int pebble(int row, int column) {  // row = ���� ũ��  ,  column = ���� ũ��
		
		int col = column-1;  //  ��  �ε��� ����,  col = ������ �� �ε���
		
		for(int p=0;p<=row;p++) {  // c�迭�� ù��° ����   w�迭�� ù��° ���� �״�� �����Ѵ�.
			
			if(p==row) {   //  ������ ���̸�
				peb[p][0] = w[0][0]+w[row-1][0];
				break;
			}
			
			peb[p][0] = w[p][0];
		}
		
		for(int i=1;i<=col;i++) {  //  c�迭�� 1������ �����Ѵ�.
			
			for(int p=0;p<=row;p++) {  //  p=0 : ����1 , p=1 : ����2 , p=2 : ����3 ,  p=3 :����4
				
				if(p==row) {  // peb �迭��  ���� 4 ���� 
					peb[p][i] = w[0][i]+w[p-1][i] + max(i-1, p); 
					break;
				}
				
				peb[p][i] = w[p][i] + max(i-1, p);  //  max(�ٷ� �� ���� �ε���, ���� ��ȣ)
			}
		}
		
		
		System.out.println("\npeb �迭 ��� : \n"); 
		
		for(int i=0;i<=row;i++) {    
			for(int j=0;j<=col;j++) {
				System.out.print(peb[i][j]+" ");  // peb �迭 ���
			}
			System.out.println();
		}
		
		
		int max = peb[0][col];  
		
		for(int i=1;i<=row;i++) {  // �� ���� ���� �������� ���
			
			if(max<peb[i][col]) {  // ������ �� ���ڳ����� ��  col=������ �� �ε���
				max = peb[i][col];
			}
		}
	
		return max;
	}
	
	public int max(int col, int pattern) {  // �Ű�����  col = ���� �迭 ���� ����  �ٷ� �� ���� �ε���,  pattern = ���Ϲ�ȣ
		// ���� �迭 ������ ���ϰ�  ���� �縳�� �� �ִ� ������ ã�� �ִ밪�� ����
	   //  pattern=0 : ����1 , pattern=1 : ����2 , pattern=2 : ����3 ,   pattern=3 :����4
		
		
		if(pattern==0) {  // ������ 1�� ���  ���� 2�� ���� 3�� �ִ밪 ����
			
			if(peb[1][col] >= peb[2][col]) {    // ���� 2�� ����  ���� 3�� ������ ũ�ų� ������
				return peb[1][col];
			}
			
			else if(peb[2][col] >= peb[1][col]) {  // ���� 3�� ����  ���� 2�� ������ ũ�ų� ������
				return peb[2][col];
			}
		}
		
		
		else if(pattern==1) {  // ������ 2�� ���   ���� 1, ����3, ���� 4��  �ִ밪 ����
			
			if(peb[0][col] >= peb[2][col] && peb[0][col]>=peb[3][col]) {  // ���� 1�� ����  ���� 3��   ���� 4���� ũ�ų�  ���� ���
				return peb[0][col];
			}
			
			else if(peb[2][col] >= peb[0][col] &&  peb[2][col]>=peb[3][col]) {  //  ���� 3�� ����   ���� 1��   ���� 4���� ũ�ų�  ���� ���
				return peb[2][col];
			}
			
			else if(peb[3][col] >= peb[0][col] &&  peb[3][col]>=peb[2][col]) {   //  ���� 4�� ����   ���� 1��  ���� 3���� ũ�ų�  ���� ���
				return peb[3][col];
			}
		}
		
		
		else if(pattern==2) {  // ������ 3�� ���   ���� 1, ���� 2 �� �ִ밪 ����
			
			if(peb[0][col] >= peb[1][col]) {  // ���� 1�� ����  ���� 2�� ������ ũ�ų� ������
				return peb[0][col];
			}
			
			else if(peb[1][col] >= peb[0][col]) {  // ���� 2�� ����  ���� 1�� ������ ũ�ų� ������
				return peb[1][col];
			}
		}
		
		
		else if(pattern==3) {  // ������ 4�� ���  ���� 2 ���� ����	
			return peb[1][col];
		}	
		
		return -1;
	}
}
