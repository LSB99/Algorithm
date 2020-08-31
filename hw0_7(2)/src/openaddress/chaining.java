package openaddress;

public class chaining {
	private Node[] table;  // �ؽ����̺�
	private int m;   //�ؽ����̺� ũ��
	
	private class Node{
		
		private int key;  //�й�
		private int value;  // ����
		private Node link; // ��ũ 
		
		public Node(int id, int grade){  //Node Ŭ���� ������
	        this.setKey(id);  //�й� ����
	        setValue(grade);  //���� ����
	        setLink(null);
	    }
		
		public int getKey() {   // key�� �й� ����
	    	return key;
	    }
	    public void setKey(int id) {  // key�� �й� ����
	    	this.key = id;
	    }
	     
	    public int getValue() {  // value ��  ��������
	    	return value;
	    }
	    public void setValue(int grade) {  // value �� ���� ����
	    	this.value = grade;
	    }
	    
	    public Node getLink() {  // ���� ��ũ ��帮��
	    	return link;
	    }
	    public void setLink(Node link) {  // ���� ��ũ ��� ����
	    	this.link = link;
	    }
		
	}
	
	//ũ�Ⱑ size�� �ؽ����̺� ����
	public chaining(int size) {  
		table = new Node[size];
		m = size;   //�迭ũ�� 
		
		for(int i=0;i<size;i++) {   // ���̺��� ����ִ� �������� ����
			table[i] = null;
		}
	}
	
	public boolean put(int key, int value) {  //�й�, ������ �Ű������� �޾� ���̺� ����. �̹� �ִ� �й��̸� ���� ����   
		
		int j=hash(key);  // �ؽð� 
		
		if(table[j]==null) {  // ��������� 
			table[j] = new Node(key, value);  // <�й�, ����> ����     
			return true;
		}
		
		else if(table[j]!=null){  // ������� ������ 
			Node x = table[j];
			
			while(x.getLink()!=null && x.getKey()!=key) {  //�״��� ��尡 ������� �ʰ� �̹� �ִ� �й��� �ƴϸ�
				x=x.getLink();   // �״��� ��ũ�� ����
			}
			
			if(x.getKey() == key) {   //�̹� �ִ� �й��̸�
				x.setValue(value);   // ������ �����Ѵ�.
				return true;
			}
			
			else {    //���ο� �й��̰� �� ���� ��尡 ��� ������
				x.setLink(new Node(key, value));   // �� ���� ��忡 ���ο�  <�й�, ����> ����   
				return true;
			}
		}
		
		else   //���� ����
			return false;
	}
	
	public int get(int key) {  //�й��� �Ű������� �޾� �� �й��� ������ ����
		
		int j = hash(key);   // �ؽð� 
			
		if(table[j]!=null) {   // ���̺��� ������� ������
			Node x = table[j];
			
			while(x!=null && x.getKey()!=key) {  //�״��� ��ũ�� ������� �ʰ� ã�� �й��� �ƴϸ�
				 x=x.getLink();   // �״��� ��ũ�� �Ѿ��.
			}
			
			if(x == null) {  // ������ ���ḵũ ������ �Դµ�  ã�� �й��� ���ٸ�
				return -1;   // �˻� ����
			}
			
			else if(x.getKey()==key)  // �й��� ã�Ҵٸ�
				return x.getValue();  // ���� ����
		}
		
		return -1;
	}
	
	
	//�ؽ����̺��� key���� �����ϰ� ���� ���� ���θ� ����
	public boolean remove(int key) {  

		int j = hash(key);  // �ؽð�
		
		if(table[j]!=null) {  //���̺��� ������� ������
			
			Node prenode = null;
			Node node = table[j];
			
			while (node.getLink() != null && node.getKey() != key) { //�״��� ��尡 ������� �ʰ� �����Ϸ��� �й��� �ƴϸ�
                prenode = node;
                node = node.getLink();

			}

			if (node.getKey() == key) {  // �����Ϸ��� �й��� ã����

                if (prenode == null) { // ������ ����� ��尡 ������
                     table[j] = node.getLink(); // �����ϴ� �й� ��ġ�� �״��� ���� ��带 ����
                     return true;
                }

                else if(prenode != null){  // ������ ����� ��尡 ������ 
                     prenode.setLink(node.getLink()); // ���� ���� ���� �״��� �����带 �̾��ش�.
                     return true;
                }

			}
		}
		return false;
	}
	
	
	//�ؽ����̺��� ������ Ȯ���ϱ� ���� �ؽ� ���̺��� ������ ��� ���
	public void print() {  
		
		System.out.println("�ؽ����̺� ����:");
		
		for(int i=0;i<m;i++) {
			
			if(table[i]==null) {  //����ִ� �ڸ� 
				System.out.println("["+i+"]");
			}
			
			else if(table[i]!=null) {  //������� ������ 
				Node node = table[i];
				System.out.print("["+i+"]--> ");
				
				while(node!=null) {  // ���Ḯ��Ʈ�� ������ ��� ���
					System.out.print("<"+node.getKey()+","+node.getValue()+">");
					node = node.getLink();
					
					if(node!=null) {
						System.out.print(" --> ");
					}
				}
				System.out.println();
			}
		}
	}
	
	//division method �ؽ� �Լ� h(x) = x mod m
	private int hash(int x) {
		double hx = Math.floor(m*(x*0.13 % 1));
		return (int)hx;
	}
}
