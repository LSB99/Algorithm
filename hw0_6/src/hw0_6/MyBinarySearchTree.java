package hw0_6;
//***************************
//파일명: MyBinarySearchTree.java
//작성자: 임수빈
//작성일: 2020년 4월 21일
//내용: 이진검색트리 클래스
//***************************
public class MyBinarySearchTree {
	
	private Node root; // 트리의 루트를 가리키는 노드 타입 변수(root) 
	private int count; // 트리에 저장된 아이디 수(노드 수)
	
	
	private class Node { //트리의 노드 구조를 정의하는 private 클래스
		private String id;  //아이디(문자열) 필드
		private Node left;  //왼쪽자식링크 필드
		private Node right; //오른쪽자식링크 필드
		
		public Node(String id){  //Node 클래스 생성자
	        this.setId(id);  //아이디 설정
	        setLeft(null);  //왼쪽자식 null
	        setRight(null);  // 오른쪽 자식 null
	    }
	 
	    public String getId() {   // 아이디 리턴
	    	return id;
	    }
	    public void setId(String id) {  //아이디 설정
	    	this.id = id;
	    }
	     
	    public Node getLeft() {  //왼쪽 자식노드 리턴
	    	return left;
	    }
	    public void setLeft(Node left) {  //왼쪽 자식노드 설정
	    	this.left = left;
	    }
	    
	    public Node getRight() {  //오른쪽 자식노드 리턴
	    	return right;
	    }
	    public void setRight(Node right) {  // 오른쪽 자식노드 설정
	    	this.right = right;
	    }
	}
	
	public MyBinarySearchTree() {  //생성자
		this.root = null;   
	} 
	
	public void print() {  //트리에 저장된 아이디를 모두 출력
		System.out.println("저장된 아이디의 갯수 : "+size());
		inorder(root);  // 중순위 순회
		System.out.println();  
	}
	
	private void inorder(Node root) {  //트리를 중순위 순회하며 키값을 출력
		if(root!=null){   
			inorder(root.getLeft()); // 왼쪽 자식
			System.out.print(root.getId()+"\n");  //루트
			inorder(root.getRight());  //오른쪽 자식
		}
	}
	
	public int size() { //트리에 저장된 아이디 수(노드 수)를 리턴
		return count;
	}
	
	public boolean contains(String id) {  //트리에 아이디가 존재하는지 여부를 검사
		Node t = root;  // 트리의 루트노드	
		
		while(t!=null) {  // 루트가 null이 아니면
			
			if(id.compareTo(t.getId())==0) { // id와 일치하는 노드를 찾았으면 리턴한다.
				return true;
			}
			
			else if(id.compareTo(t.getId())<0) { //찾으려는 값이 비교 노드보다 작으면 왼쪽으로 검색
				t = t.getLeft();
			}
			
			else if(id.compareTo(t.getId())>0) {  //찾으려는 값이 비교 노드보다 크면 오른쪽으로 검색
				t = t.getRight();
			}
		}
		return false;  //검색에 실패했을 경우
	}

	public boolean add(String id) {  //트리에 아이디(노드)를 삽입
		
		Node newNode = new Node(id);  //삽입할 노드 생성
		
		if(root==null) {  //트리가 없으면 삽입할 노드를 루트로 만든다.
			root=newNode;
			count++;
			return true;
		}
		
		Node current = root;  // 비교할 노드
		Node parent = null;   // current의 상위 노드인 부모노드
		
		while(true) {
			parent = current;
			
			if(id.compareTo(current.getId())<0) { //삽입할 값이 비교할 노드보다 작으면 왼쪽으로 내려간다.
				current = current.getLeft();
				
				if(current==null) {  //왼쪽 자식 노드가 없으면 그자리에 삽입
					parent.setLeft(newNode);
					count++;
					return true;
				}
			}
			
			else if(id.compareTo(current.getId())>0) { //삽입할 값이 비교할 노드보다 크면 오른쪽으로 내려간다.
				current = current.getRight();
				
				if(current==null) {  //오른쪽 자식 노드가 없으면 그자리에 삽입
					parent.setRight(newNode);
					count++;
					return true;
				}
			}
			
			else if(id.compareTo(current.getId())==0) {  // 이미 존재하는 아이디면 삽입 실패
				return false;
			}
		}
	}
	
	public boolean remove(String id) {  //트리에서 아이디(노드)를 삭제.
		
		Node parent = root;  //현재위치로부터의 부모 노드
		Node current = root;  //현재위치
		boolean isLeftChild = false;  //왼쪽 자식인지 확인하는 변수 
		
		if(current==null) {  //존재하지 않는 아이디면 삭제 실패 
			return false;
		}
		
		while(!current.getId().equals(id)) { // 현재노드 아이디와 삭제하려는 아이디가 같지 않으면
			parent = current;
			
			if(id.compareTo(current.getId())<0) { // 삭제할 아이디가 현재노드보다 작으면 왼쪽으로 내려간다.
				isLeftChild = true;
				current = current.getLeft();
			}
			
			else if(id.compareTo(current.getId())>0) {  // 삭제할 아이디가 현재노드보다 크면 오른쪽으로 내려간다.
				isLeftChild = false;
				current = current.getRight();
			}
			
			if(current==null) {  //존재하지 않는 아이디면 삭제 실패 
				return false;
			}
		}// 여기까지 while이 돌고나면 id(current)의 위치를 찾았다.
		
		
		//Case 1: 자식노드가 없는 경우
		if(current.getLeft()==null && current.getRight()==null) { 
			
			if(current==root) {  //id와 같은 값을 가지는 노드가 루트이고 자식이없다면 루트 삭제 
				root = null;  
				count--;
				return true;
			}
			
			if(isLeftChild==true) {  // 부모노드의 왼쪽 자식이면
				parent.setLeft((null));  // 부모노드 왼쪽 자식을 null 설정
				count--;
				return true;
			}
			
			else if(isLeftChild==false) {  // 부모노드의 오른쪽 자식이면
				parent.setRight((null));  // 부모노드 오른쪽 자식을 null 설정
				count--;
				return true;
			}
		}
		
		
		 //Case 2 : 한쪽 자식만 갖는경우
		else if(current.getLeft()==null && current.getRight()!=null) {  // Case2-1 : 오른쪽 자식만 있을경우
			
			if(current==root) {  //만약 지울려는 노드가 루트이면
				root = current.getRight(); //지우는 노드 오른쪽 자식을 루트로 설정
				count--;
				return true;
			}
			
			else if(isLeftChild) { //지울려는 노드가 부모노드의 왼쪽 자식이면
				parent.setLeft(current.getRight()); //지울려는 노드의 오른족 자식을 부모노드 왼쪽에 붙인다.
				count--;
				return true;
			}
			
			else {  //지울려는 노드가 부모노드의 오른쪽 자식이면
				parent.setRight(current.getRight());  //지울려는 노드의 오른족 자식을 부모노드 오른쪽에 붙인다.
				count--;
				return true;
			}
		}
		
		else if(current.getLeft()!=null && current.getRight()==null) {  //Case2-2 : 왼쪽 자식만 있을경우
			
			if(current==root) { //만약 지울려는 노드가 루트이면
				root = current.getLeft();  //지우는 노드 왼쪽 자식을 루트로 설정
				count--;
				return true;
			}
			
			else if(isLeftChild) {  //지울려는 노드가 부모노드의 왼쪽 자식이면
				parent.setLeft(current.getLeft()); //지울려는 노드의 왼쪽 자식을 부모노드 왼쪽에 붙인다.
				count--;
				return true;
			}
			
			else{  //지울려는 노드가 부모노드의 오른쪽 자식이면
                parent.setRight(current.getLeft()); //지울려는 노드의 왼쪽 자식을 부모노드 오른쪽에 붙인다.
                count--;
                return true;
            }
		}
		
		
		//Case 3 : 양쪽 자식을 갖는 경우
		 else if(current.getLeft()!=null && current.getRight()!=null) {
			// 오른쪽 서브트리의 최소값을 찾음
			 Node s = null;  // 지울려는 노드의 오른쪽 자식중 최소값을 저장할 변수
			 Node sParent = null;  // 최소값의 부모노드
			 Node current2 = current.getRight(); //오른쪽에서 최솟값 찾기
			 
			 while(current2!=null) {  // 왼쪽자식이 없을때까지 반복
				 sParent = s;  
				 s = current2;
				 current2 = current2.getLeft();  //왼쪽 서브트리를 타고 내려간다.
			 }
			 
			 if(s!=current.getRight()) {  // 지울려는 노드의 오른쪽 자식들중 최소값이  지울려는 노드의 바로 오른쪽 자식이 아니면
		            sParent.setLeft(s.getRight()); // 최소값 부모노드의 왼쪽에다가  최솟값의 오른쪽 자식을 저장
		            s.setRight(current.getRight());  // 최소값 오른쪽 자식 위치에는 지울려는 노드의 오른쪽 자식 저장
		     }
			 
			 Node successor = s;
			 
			 if(current==root) {  // 지울려는 노드가 루트이면
				 root = successor;  //루트에 최솟값 저장
				 count--;
			 }
			 
			 else if(isLeftChild) {  // 지울려는 노드가 왼쪽에 있는 자식이면
				 parent.setLeft(successor);  //지울려는 노드의 부모 노드 왼쪽에 최소값 저장
				 count--;
			 }  
			 else {  //지울려는 노드가 오른쪽에 있는 자식이면
				 parent.setRight(successor);  // 지울려는 노드의 부모 노드 오른쪽에 최솟값 저장
				 count--;
			 }
			 
			 successor.setLeft(current.getLeft());  // 최솟값 왼쪽자식 위치에  지운노드의 왼쪽 자식들 저장
			 return true;
		 }	
		
		return false;
	}
}


