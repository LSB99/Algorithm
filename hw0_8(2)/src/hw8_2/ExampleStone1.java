package hw8_2;
import java.util.Scanner;
import hw0_8.PutStone;

public class ExampleStone1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("3x8 �迭  ExampleStone1\n");
		System.out.println("�� ���� ������ �������α׷����� �̿��Ͽ� �����մϴ�. \n");
		
		int[][] w = {{6,7,12,-5,5,3,11,3},{-8,10,14,9,7,13,8,5},{11,12,7,4,8,-2,9,4}};  // 3x5 �迭
		
		int row = w.length;
		int col = w[0].length;
		
		PutStone sd = new PutStone(row,col);
		sd.put(w,row,col);
		
		System.out.println(row+"x"+col+" ���̺� ��� :");
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(w[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n�� ���� ���� ���� �� = " + sd.pebble(row,col));
	}
}
