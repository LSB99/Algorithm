package hw10_2;
import hw10.GetTopologicalSort;
import java.util.Scanner;
//***************************
//파일명: TopologicalSort.java
//작성자: 임수빈
//작성일: 2020년 6월 5일
//프로그램 설명: 위상 정렬 알고리즘 버전 2 main 클래스
//***************************

public class TopologicalSort {

	public static void main(String[] args) {
		
		System.out.println("hw10_2 : 임수빈\n");
		Scanner scanner = new Scanner(System.in);  
		
		System.out.println("위상 정렬을 수행합니다. DAG를 입력하세요.");
		System.out.print("정점 수 입력: ");
		int n = scanner.nextInt();  // 정점 수 n을 입력받음
		
		GetTopologicalSort graph = new GetTopologicalSort(n);  // 정점 수가 n인 방향 그래프를 생성
		
		System.out.print("간선 수 입력: ");
		
		int e = scanner.nextInt();// 간선 수 e를 입력받음
		
		System.out.println("\n"+e+"개의 간선 입력(각 간선은 정점 번호 2개를 whitespace로 구분하여 입력):");
		
		
		// e개의 정점 쌍 v1과 v2를 입력받아 그래프에 <v1, v2>를 삽입
		for(int i=0;i<e;i++) {
			int edge = i+1;
			System.out.print("간선"+edge+" 입력: ");
			
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			
			if(v1>=n || v2>=n) {
				System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <"+v1+","+v2+">\n");
				continue;
			}
			
			else {
				graph.addEdge(v1,v2);  //그래프에 <v1, v2> 삽입
			}	
		}
		System.out.println();
		graph.printAdjacencyList();  //  그래프 구현을 확인
		
		System.out.print("\n위상정렬 결과: ");
		
		graph.topologicalSort2();   // 위상정렬
		System.out.println();
	}
}
