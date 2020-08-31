package hw8_2;
import java.util.Scanner;
import hw0_8.PutStone;

public class ExampleStone1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("3x8 배열  ExampleStone1\n");
		System.out.println("돌 놓기 문제를 동적프로그래밍을 이용하여 구현합니다. \n");
		
		int[][] w = {{6,7,12,-5,5,3,11,3},{-8,10,14,9,7,13,8,5},{11,12,7,4,8,-2,9,4}};  // 3x5 배열
		
		int row = w.length;
		int col = w[0].length;
		
		PutStone sd = new PutStone(row,col);
		sd.put(w,row,col);
		
		System.out.println(row+"x"+col+" 테이블 출력 :");
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(w[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n돌 놓기 문제 최종 값 = " + sd.pebble(row,col));
	}
}
