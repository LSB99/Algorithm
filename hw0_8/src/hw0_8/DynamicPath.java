package hw0_8;
//***************************
//���ϸ�: DynamicPath.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 5�� 19��
//����: ��� ��� ����  �������α׷��� �˰���
//***************************

public class DynamicPath {
	
	private int[][] m;  // ��� m
	private int[][] c;  // �迭 c
	private String[] s;  // �ִ� ���� ��θ� ������ �迭

	public DynamicPath(int n) {  // ������
		m = new int[n][n];  // n x n ���
		c = new int[n+1][n+1]; // (n+1) x (n+1) �迭 c
	}
	
	public void put(int[][] array, int n) {  // ��� ���� ����
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				m[i][j] = array[i][j];
			}
		}
	}
	
	public int matrixPath(int n) {  //(1,1) ���� (n,n)�� �̸���  �ְ�����
		
		for(int i=0;i<=n;i++) {  // �迭 c  0����  0���� �ʱ�ȭ
			c[i][0] = 0;
		}
		
		for(int j=1;j<=n;j++) {  // �迭 c  0����  0���� �ʱ�ȭ
			c[0][j] = 0;
		}
		
		for(int i=1;i<=n;i++) {    // �ְ������� ���ϴ� �ݺ���
			for(int j=1;j<=n;j++) {
				c[i][j] = m[i-1][j-1]+max(c[i-1][j], c[i][j-1]);
			}
		}
		
		return c[n][n];  // �ְ������� �����Ѵ�.
	}
	
	public int max(int n1, int n2) {
		
		if(n1>n2) {  // n1�� n2���� ũ��
			return n1;
		}
		
		else if(n2>n1) { // n2�� n1���� ũ��
			return n2;
		}
		
		else   // �� ���� ������
			return n1;
	}
	
	public void maxscorepath(int n) {  // �ִ� ���� ��θ� ������ ����Ѵ�.
		
		int i=n;  //���� ǥ���� ����
		int j=n;  // ���� ǥ���� ����
		int index=0; // �ִ� ���� ��� �迭 s �ε���
		
		s = new String[n*n];
		s[index] = "("+n+","+n+")"; // �ִ� ���� ��ġ ����
		index++;
		
		while(true) {
			if(i==1 && j-1==1) {  // ���ۿ��� �ٷ� ���̸�
				s[index] = "("+1+","+1+")";  // (1,1) ����
				break;
			}
			
			if(i-1==1 && j==1) {  // ���ۿ��� �ٷ� ���̸�
				s[index] = "("+1+","+1+")";  // (1,1) ����
				break;
			}
		
			if(c[i-1][j] > c[i][j-1]) {  // ���� ������  �ٷ� ���� ���Ұ�  �ٷ� ���� ���Һ��� ũ�ٸ�
				int n1 = i-1;
				int n2 = j;
			
				s[index] = "("+n1+","+n2+")";
				
				i--;
				index++;
				continue;
			}
			
			else if(c[i][j-1] > c[i-1][j] ) {  // ���� ������  �ٷ� ���� ���Ұ�  �ٷ� ���� ���Һ��� ũ�ٸ�
				int n1 = i;
				int n2 = j-1;
				
				s[index] = "("+n1+","+n2+")";
				
				j--;
				index++;
				continue;
			}
			
			else if(c[i][j-1]==c[i-1][j]) {  // ���� ������  �ٷ� ���� ���ҿ� ���� ���Ұ� ������  ���� ���ҷ� �ö󰡵��� ����
				int n1 = i-1;
				int n2 = j;
			
				s[index] = "("+n1+","+n2+")";
				
				i--;
				index++;
				continue;
			}
		}
		
		for(int k=index;k>=0;k--) {  // �ִ� ���� ��θ� ������ �迭�� ����Ѵ�.
			System.out.print(s[k]+" ");
		}
	}
}
