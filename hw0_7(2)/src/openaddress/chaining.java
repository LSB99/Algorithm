package openaddress;

public class chaining {
	private Node[] table;  // 해시테이블
	private int m;   //해시테이블 크기
	
	private class Node{
		
		private int key;  //학번
		private int value;  // 성적
		private Node link; // 링크 
		
		public Node(int id, int grade){  //Node 클래스 생성자
	        this.setKey(id);  //학번 설정
	        setValue(grade);  //성적 설정
	        setLink(null);
	    }
		
		public int getKey() {   // key값 학번 리턴
	    	return key;
	    }
	    public void setKey(int id) {  // key값 학번 설정
	    	this.key = id;
	    }
	     
	    public int getValue() {  // value 값  성적리턴
	    	return value;
	    }
	    public void setValue(int grade) {  // value 값 성적 설정
	    	this.value = grade;
	    }
	    
	    public Node getLink() {  // 연결 링크 노드리턴
	    	return link;
	    }
	    public void setLink(Node link) {  // 연결 링크 노드 설정
	    	this.link = link;
	    }
		
	}
	
	//크기가 size인 해시테이블 생성
	public chaining(int size) {  
		table = new Node[size];
		m = size;   //배열크기 
		
		for(int i=0;i<size;i++) {   // 테이블을 비어있는 공간으로 설정
			table[i] = null;
		}
	}
	
	public boolean put(int key, int value) {  //학번, 성적을 매개변수로 받아 테이블에 삽입. 이미 있는 학번이면 성적 갱신   
		
		int j=hash(key);  // 해시값 
		
		if(table[j]==null) {  // 비어있으면 
			table[j] = new Node(key, value);  // <학번, 성적> 저장     
			return true;
		}
		
		else if(table[j]!=null){  // 비어있지 않으면 
			Node x = table[j];
			
			while(x.getLink()!=null && x.getKey()!=key) {  //그다음 노드가 비어있지 않고 이미 있는 학번이 아니면
				x=x.getLink();   // 그다음 링크로 설정
			}
			
			if(x.getKey() == key) {   //이미 있는 학번이면
				x.setValue(value);   // 성적을 갱신한다.
				return true;
			}
			
			else {    //새로운 학번이고 그 다음 노드가 비어 있으면
				x.setLink(new Node(key, value));   // 그 다음 노드에 새로운  <학번, 성적> 저장   
				return true;
			}
		}
		
		else   //삽입 실패
			return false;
	}
	
	public int get(int key) {  //학번을 매개변수로 받아 그 학번의 성적을 리턴
		
		int j = hash(key);   // 해시값 
			
		if(table[j]!=null) {   // 테이블이 비어있지 않으면
			Node x = table[j];
			
			while(x!=null && x.getKey()!=key) {  //그다음 링크가 비어있지 않고 찾는 학번이 아니면
				 x=x.getLink();   // 그다음 링크로 넘어간다.
			}
			
			if(x == null) {  // 마지막 연결링크 노드까지 왔는데  찾는 학번이 없다면
				return -1;   // 검색 실패
			}
			
			else if(x.getKey()==key)  // 학번을 찾았다면
				return x.getValue();  // 성적 리턴
		}
		
		return -1;
	}
	
	
	//해시테이블에서 key값을 삭제하고 삭제 성공 여부를 리턴
	public boolean remove(int key) {  

		int j = hash(key);  // 해시값
		
		if(table[j]!=null) {  //테이블이 비어있지 않으면
			
			Node prenode = null;
			Node node = table[j];
			
			while (node.getLink() != null && node.getKey() != key) { //그다음 노드가 비어있지 않고 삭제하려는 학번이 아니면
                prenode = node;
                node = node.getLink();

			}

			if (node.getKey() == key) {  // 삭제하려는 학번을 찾으면

                if (prenode == null) { // 이전에 연결된 노드가 없으면
                     table[j] = node.getLink(); // 삭제하는 학번 위치에 그다음 연결 노드를 저장
                     return true;
                }

                else if(prenode != null){  // 이전에 연결된 노드가 있으면 
                     prenode.setLink(node.getLink()); // 이전 연결 노드와 그다음 연결노드를 이어준다.
                     return true;
                }

			}
		}
		return false;
	}
	
	
	//해시테이블의 구현을 확인하기 위해 해시 테이블의 구조를 모두 출력
	public void print() {  
		
		System.out.println("해시테이블 내용:");
		
		for(int i=0;i<m;i++) {
			
			if(table[i]==null) {  //비어있는 자리 
				System.out.println("["+i+"]");
			}
			
			else if(table[i]!=null) {  //비어있지 않으면 
				Node node = table[i];
				System.out.print("["+i+"]--> ");
				
				while(node!=null) {  // 연결리스트로 구성된 노드 출력
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
	
	//division method 해시 함수 h(x) = x mod m
	private int hash(int x) {
		double hx = Math.floor(m*(x*0.13 % 1));
		return (int)hx;
	}
}
