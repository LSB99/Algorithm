package hw0_6;
//***************************
//���ϸ�: MyBinarySearchTree.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 4�� 21��
//����: �����˻�Ʈ�� Ŭ����
//***************************
public class MyBinarySearchTree {
	
	private Node root; // Ʈ���� ��Ʈ�� ����Ű�� ��� Ÿ�� ����(root) 
	private int count; // Ʈ���� ����� ���̵� ��(��� ��)
	
	
	private class Node { //Ʈ���� ��� ������ �����ϴ� private Ŭ����
		private String id;  //���̵�(���ڿ�) �ʵ�
		private Node left;  //�����ڽĸ�ũ �ʵ�
		private Node right; //�������ڽĸ�ũ �ʵ�
		
		public Node(String id){  //Node Ŭ���� ������
	        this.setId(id);  //���̵� ����
	        setLeft(null);  //�����ڽ� null
	        setRight(null);  // ������ �ڽ� null
	    }
	 
	    public String getId() {   // ���̵� ����
	    	return id;
	    }
	    public void setId(String id) {  //���̵� ����
	    	this.id = id;
	    }
	     
	    public Node getLeft() {  //���� �ڽĳ�� ����
	    	return left;
	    }
	    public void setLeft(Node left) {  //���� �ڽĳ�� ����
	    	this.left = left;
	    }
	    
	    public Node getRight() {  //������ �ڽĳ�� ����
	    	return right;
	    }
	    public void setRight(Node right) {  // ������ �ڽĳ�� ����
	    	this.right = right;
	    }
	}
	
	public MyBinarySearchTree() {  //������
		this.root = null;   
	} 
	
	public void print() {  //Ʈ���� ����� ���̵� ��� ���
		System.out.println("����� ���̵��� ���� : "+size());
		inorder(root);  // �߼��� ��ȸ
		System.out.println();  
	}
	
	private void inorder(Node root) {  //Ʈ���� �߼��� ��ȸ�ϸ� Ű���� ���
		if(root!=null){   
			inorder(root.getLeft()); // ���� �ڽ�
			System.out.print(root.getId()+"\n");  //��Ʈ
			inorder(root.getRight());  //������ �ڽ�
		}
	}
	
	public int size() { //Ʈ���� ����� ���̵� ��(��� ��)�� ����
		return count;
	}
	
	public boolean contains(String id) {  //Ʈ���� ���̵� �����ϴ��� ���θ� �˻�
		Node t = root;  // Ʈ���� ��Ʈ���	
		
		while(t!=null) {  // ��Ʈ�� null�� �ƴϸ�
			
			if(id.compareTo(t.getId())==0) { // id�� ��ġ�ϴ� ��带 ã������ �����Ѵ�.
				return true;
			}
			
			else if(id.compareTo(t.getId())<0) { //ã������ ���� �� ��庸�� ������ �������� �˻�
				t = t.getLeft();
			}
			
			else if(id.compareTo(t.getId())>0) {  //ã������ ���� �� ��庸�� ũ�� ���������� �˻�
				t = t.getRight();
			}
		}
		return false;  //�˻��� �������� ���
	}

	public boolean add(String id) {  //Ʈ���� ���̵�(���)�� ����
		
		Node newNode = new Node(id);  //������ ��� ����
		
		if(root==null) {  //Ʈ���� ������ ������ ��带 ��Ʈ�� �����.
			root=newNode;
			count++;
			return true;
		}
		
		Node current = root;  // ���� ���
		Node parent = null;   // current�� ���� ����� �θ���
		
		while(true) {
			parent = current;
			
			if(id.compareTo(current.getId())<0) { //������ ���� ���� ��庸�� ������ �������� ��������.
				current = current.getLeft();
				
				if(current==null) {  //���� �ڽ� ��尡 ������ ���ڸ��� ����
					parent.setLeft(newNode);
					count++;
					return true;
				}
			}
			
			else if(id.compareTo(current.getId())>0) { //������ ���� ���� ��庸�� ũ�� ���������� ��������.
				current = current.getRight();
				
				if(current==null) {  //������ �ڽ� ��尡 ������ ���ڸ��� ����
					parent.setRight(newNode);
					count++;
					return true;
				}
			}
			
			else if(id.compareTo(current.getId())==0) {  // �̹� �����ϴ� ���̵�� ���� ����
				return false;
			}
		}
	}
	
	public boolean remove(String id) {  //Ʈ������ ���̵�(���)�� ����.
		
		Node parent = root;  //������ġ�κ����� �θ� ���
		Node current = root;  //������ġ
		boolean isLeftChild = false;  //���� �ڽ����� Ȯ���ϴ� ���� 
		
		if(current==null) {  //�������� �ʴ� ���̵�� ���� ���� 
			return false;
		}
		
		while(!current.getId().equals(id)) { // ������ ���̵�� �����Ϸ��� ���̵� ���� ������
			parent = current;
			
			if(id.compareTo(current.getId())<0) { // ������ ���̵� �����庸�� ������ �������� ��������.
				isLeftChild = true;
				current = current.getLeft();
			}
			
			else if(id.compareTo(current.getId())>0) {  // ������ ���̵� �����庸�� ũ�� ���������� ��������.
				isLeftChild = false;
				current = current.getRight();
			}
			
			if(current==null) {  //�������� �ʴ� ���̵�� ���� ���� 
				return false;
			}
		}// ������� while�� ������ id(current)�� ��ġ�� ã�Ҵ�.
		
		
		//Case 1: �ڽĳ�尡 ���� ���
		if(current.getLeft()==null && current.getRight()==null) { 
			
			if(current==root) {  //id�� ���� ���� ������ ��尡 ��Ʈ�̰� �ڽ��̾��ٸ� ��Ʈ ���� 
				root = null;  
				count--;
				return true;
			}
			
			if(isLeftChild==true) {  // �θ����� ���� �ڽ��̸�
				parent.setLeft((null));  // �θ��� ���� �ڽ��� null ����
				count--;
				return true;
			}
			
			else if(isLeftChild==false) {  // �θ����� ������ �ڽ��̸�
				parent.setRight((null));  // �θ��� ������ �ڽ��� null ����
				count--;
				return true;
			}
		}
		
		
		 //Case 2 : ���� �ڽĸ� ���°��
		else if(current.getLeft()==null && current.getRight()!=null) {  // Case2-1 : ������ �ڽĸ� �������
			
			if(current==root) {  //���� ������� ��尡 ��Ʈ�̸�
				root = current.getRight(); //����� ��� ������ �ڽ��� ��Ʈ�� ����
				count--;
				return true;
			}
			
			else if(isLeftChild) { //������� ��尡 �θ����� ���� �ڽ��̸�
				parent.setLeft(current.getRight()); //������� ����� ������ �ڽ��� �θ��� ���ʿ� ���δ�.
				count--;
				return true;
			}
			
			else {  //������� ��尡 �θ����� ������ �ڽ��̸�
				parent.setRight(current.getRight());  //������� ����� ������ �ڽ��� �θ��� �����ʿ� ���δ�.
				count--;
				return true;
			}
		}
		
		else if(current.getLeft()!=null && current.getRight()==null) {  //Case2-2 : ���� �ڽĸ� �������
			
			if(current==root) { //���� ������� ��尡 ��Ʈ�̸�
				root = current.getLeft();  //����� ��� ���� �ڽ��� ��Ʈ�� ����
				count--;
				return true;
			}
			
			else if(isLeftChild) {  //������� ��尡 �θ����� ���� �ڽ��̸�
				parent.setLeft(current.getLeft()); //������� ����� ���� �ڽ��� �θ��� ���ʿ� ���δ�.
				count--;
				return true;
			}
			
			else{  //������� ��尡 �θ����� ������ �ڽ��̸�
                parent.setRight(current.getLeft()); //������� ����� ���� �ڽ��� �θ��� �����ʿ� ���δ�.
                count--;
                return true;
            }
		}
		
		
		//Case 3 : ���� �ڽ��� ���� ���
		 else if(current.getLeft()!=null && current.getRight()!=null) {
			// ������ ����Ʈ���� �ּҰ��� ã��
			 Node s = null;  // ������� ����� ������ �ڽ��� �ּҰ��� ������ ����
			 Node sParent = null;  // �ּҰ��� �θ���
			 Node current2 = current.getRight(); //�����ʿ��� �ּڰ� ã��
			 
			 while(current2!=null) {  // �����ڽ��� ���������� �ݺ�
				 sParent = s;  
				 s = current2;
				 current2 = current2.getLeft();  //���� ����Ʈ���� Ÿ�� ��������.
			 }
			 
			 if(s!=current.getRight()) {  // ������� ����� ������ �ڽĵ��� �ּҰ���  ������� ����� �ٷ� ������ �ڽ��� �ƴϸ�
		            sParent.setLeft(s.getRight()); // �ּҰ� �θ����� ���ʿ��ٰ�  �ּڰ��� ������ �ڽ��� ����
		            s.setRight(current.getRight());  // �ּҰ� ������ �ڽ� ��ġ���� ������� ����� ������ �ڽ� ����
		     }
			 
			 Node successor = s;
			 
			 if(current==root) {  // ������� ��尡 ��Ʈ�̸�
				 root = successor;  //��Ʈ�� �ּڰ� ����
				 count--;
			 }
			 
			 else if(isLeftChild) {  // ������� ��尡 ���ʿ� �ִ� �ڽ��̸�
				 parent.setLeft(successor);  //������� ����� �θ� ��� ���ʿ� �ּҰ� ����
				 count--;
			 }  
			 else {  //������� ��尡 �����ʿ� �ִ� �ڽ��̸�
				 parent.setRight(successor);  // ������� ����� �θ� ��� �����ʿ� �ּڰ� ����
				 count--;
			 }
			 
			 successor.setLeft(current.getLeft());  // �ּڰ� �����ڽ� ��ġ��  �������� ���� �ڽĵ� ����
			 return true;
		 }	
		
		return false;
	}
}


