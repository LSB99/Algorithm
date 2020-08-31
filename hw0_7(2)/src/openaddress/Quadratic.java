package openaddress;

public class Quadratic {
	private int[] table;  // �ؽ����̺�
	private int m;   //�ؽ����̺� ũ��
	private static final int EMPTY = -1;  // ����ִ� �ڸ����� ��Ÿ���� ��
	private static final int DELETED = -2; // ������ �ڸ����� ��Ÿ���� ��
	
	//ũ�Ⱑ size�� �ؽ����̺� ����
	public Quadratic(int size) {  
		table = new int[size];
		m = size;   //�迭ũ�� 
		
		for(int i=0;i<size;i++) {   // �迭�� ����ִ� �������� ����
			table[i] = EMPTY;
		}
	}
	
	// �ؽ����̺� key���� �����ϰ� ���� ���� ���θ� ����
	public boolean put(int key) {  
		
		int i=0;   // i��° ����
		int j=0;  //�ؽð� ���庯�� 
		
		do {
			j = hash(i,key);  // �ؽð� ����
			
			if(table[j]==EMPTY || table[j]==DELETED) {  //�ؽð� �ּ���ġ�� ��������� �����Ѵ�.
				table[j] = key;  // Ű�� ����
				return true;
			}
			
			else 
				i++;  //1�� ����
			
		}while(i!=m);  // �ؽ����̺� ũ�⸸ŭ ����ִ� ������ ã�� ���ϸ� ���� ����
		
		return false;  
	}
	
	// �ؽ� ���̺� key���� �˻��Ͽ� �ε����� ����, �˻� ���н� -1����
	private int search(int key) {
		
		int i=0;   // i��° ����
		int j=0;  //�ؽð� ���庯��
		
		do {
			j = hash(i,key);  // �ؽð� ����
			
			if(table[j]==key) {   // key���� ã����  
				return j;    //�ε��� ����
			} 
			
			else 
				i++;
			
		}while(table[j]!=EMPTY || i!=m);  // �ؽ� ���̺� ������ ����ְų�  ���̺� ũ�⸸ŭ �ɶ����� ã�� ���ϸ� �˻� ����
		
		return -1;
	}
	
	//�ؽ����̺��� key���� �˻��ϰ� �˻� ���� ���θ� ����
	public boolean contains(int key) {  
		int index = search(key);  // �˻��Ͽ� ���ϵ� �ε��� ����
		return (index>=0);    // ������ false �ƴϸ� true
	}
	
	
	//�ؽ����̺��� key���� �����ϰ� ���� ���� ���θ� ����
	public boolean remove(int key) {  

		int i=0;   // i��° ����
		int j=0;  //�ؽð� ���庯��   
		
		do {
			j = hash(i,key);  // �ؽð� ����
			
			if(table[j]==key) {    //�ؽð� �ּ���ġ ���Ұ� key ���̸�
				table[j] = DELETED;  // �����ϰ� DELETED ������� �����Ѵ�.
				return true;
			}
			
			else 
				i++;
			
		}while(i!=m);  // �ؽ� ���̺� ũ�⸸ŭ key���� ã�� ���ϸ� ���� ����
		
		return false;
	}
	
	
	//�ؽ����̺��� ������ Ȯ���ϱ� ���� �ؽ� ���̺��� ������ ��� ���
	public void print() {  
		
		System.out.println("�ؽ����̺� ����:");
		
		for(int i=0;i<m;i++) {
			if(table[i]==EMPTY)  //����ִ� �ڸ� 
				System.out.println("["+i+"]");
			
			else if(table[i]==DELETED)  //������ �ڸ�
				System.out.println("["+i+"] DELETED");
			
			else
				System.out.println("["+i+"] "+table[i]);
		}
	}
	
	//division method �ؽ� �Լ� h(x) = x mod m
	private int hash(int x) {
		int hx = x % m;  
		return hx;
	}
	
	//linear probing i��° �ؽ� �Լ� hi(x) = (h(x) + i) mod m
	private int hash(int i, int x) {
		int hix = (hash(x)+i*i) % m;
		return hix;
	}
}
