package hw8_2;
import hw0_8.PutStone;
import java.util.Scanner;

public class PutStoneTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("3x5 �迭  �����̵峻��\n");
		System.out.println("�� ���� ������ �������α׷����� �̿��Ͽ� �����մϴ�. \n");
		
		int[][] w = {{5,3,-20,10,10},{2,5,10,5,-5},{10,6,1,-10,5}};  // 3x5 �迭
		
		int row = w.length;
		int col = w[0].length;
		
		PutStone sd = new PutStone(row,col);
		sd.put(w,row,col);
		
		System.out.println(row+"x"+col+" ���̺� ��� : \n");
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(w[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n�� ���� ���� ���� �� = " + sd.pebble(row,col));
	}
}
