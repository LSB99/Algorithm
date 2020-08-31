package hw12;
import java.util.HashMap;
//***************************
//���ϸ�: BoyerMooreHorspool.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 6�� 17��
//���α׷� ����: Boyer-Moore-Horspool �˰���  ���� Ŭ���� 
//***************************

public class BoyerMooreHorspool {
	
	HashMap<String, Integer> jump;  //  jump table
	
	private int count = 0;   //  ���� �� ����
	
	private char[] pattern;  //  ���� �迭
	private char[] text;    //  �ؽ�Ʈ �迭
	
	public BoyerMooreHorspool(char P[], char A[]) {  //  P[] = ���Ϲ��ڿ�  , A[] = �ؽ�Ʈ ���ڿ�  
		
		pattern = new char[P.length];
		text = new char[A.length];
		jump = new HashMap<String, Integer>();
		
		pattern = P;  // ���� ���ڿ� ����
		text = A;    // �ؽ�Ʈ ���ڿ� ����
		
		computeJump(pattern);  // ���� ���ڿ��� ����  ���� ���̺��� �ϼ��Ѵ�.
	}
	
	public void computeJump(char P[]) {  // �������̺��� �ϼ��ϴ� �Լ�
		
		int size = P.length;  // size ������  ���Ϲ��ڿ� ���̸� ����
		
		for(int i=0; i<size;i++) {  //  ���� ���ڿ���  ������ ���� ������ �ݺ��Ѵ�.
			
			if(i==size-1) {  // ���� ���ڿ��� ������ �����϶�
				
				if(!jump.containsKey(String.valueOf(P[size-1]))) {  // �Ǹ����� ���Ұ� �������� ���� Ű���̸�
					jump.put(String.valueOf(P[size-1]), P.length);  // �� ������ ���Ҵ�  ���� �迭 ���̸�ŭ ����
				}
			}
			
			else {    // ���� ���ڿ��� ������ ���Ұ� �ƴҶ�
				
				if(jump.containsKey(String.valueOf(P[i]))) {  //  �̹� �����ϴ� Ű���� ���
					
					int n = jump.get(String.valueOf(P[i]));   // �����ϴ� Ű����  n�� �����Ѵ�.
					
					if(n>P.length-i-1) {   //  �̹� �����ϴ� Ű����  �� ũ�ٸ�   ���� ������ �����Ѵ�.
						jump.remove(String.valueOf(P[i]));   
						jump.put(String.valueOf(P[i]), P.length-i-1);
					}
				}
				
				
				else {   //  �������� ����  Ű���� ��� 
					jump.put(String.valueOf(P[i]), P.length-i-1);
				}	
				
			}
		}
		
		jump.put("��Ÿ", P.length);  // ��Ÿ������ ���� ��ȣ ����
	}
	
	public void match() {  // ���� ���ڿ���  �ؽ�Ʈ ���ڿ���  ��Ī�ϴ� �Լ� 
		
		int m = pattern.length;   // ���� ���ڿ� ����
		int n = text.length;     //  �ؽ�Ʈ ���ڿ� ����
		int i = 0;    
		
		while(i<=n-m) {
			
			int j = m-1;
			int k = i+m-1;
			
			while(j>=0 && pattern[j]==text[k]) {  // ���� ���ڿ��� �ؽ�Ʈ ���ڿ��� ��ġ�ϴ��� Ȯ��
				j--;
				k--;
			}
			
			if(j<0) {   // ���� ���ڿ��� �ؽ�Ʈ ���ڿ��� ��ġ�ϸ�
				
				System.out.print(i+" ");  //  �ؽ�Ʈ ���ڿ���  i �ڸ����� ��Ī�� �Ͼ�ٰ� ����Ѵ�.
			}
			
			if(jump.containsKey(String.valueOf(text[i+m-1]))){  // ���Ϲ��ڿ��� ���ԵǴ� ������ ���
				
				i = i+jump.get(String.valueOf(text[i+m-1]));  // �ش� ���� ������ȣ��  �����Ѵ�.
				count++;  
				
			}
			
			else if(!jump.containsKey(String.valueOf(text[i+m-1]))) {  // ���Ե��� �ʰ� ��Ÿ������ ���
				
				i = i+jump.get("��Ÿ");  // ��Ÿ����  ������ȣ��  �����Ѵ�.
				count++;   
				
			}
		}
	}
	
	public int jumpcount() {  // ���� �� ����
		return count;
	}
}
