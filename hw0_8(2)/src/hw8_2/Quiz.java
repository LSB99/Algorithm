package hw8_2;
import java.util.Scanner;
import hw0_8.PutStone;

public class Quiz {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("3x8 �迭  Quiz5 ����\n");
		System.out.println("�� ���� ������ �������α׷����� �̿��Ͽ� �����մϴ�. \n");
		
		int[][] w = {{1,6,12,-5,5,3,9,2},{-14,9,14,9,7,13,6,4},{6,11,7,4,8,-2,7,3}};  // 3x8 �迭
		
		int row = w.length;
		int col = w[0].length;
		
		PutStone sd = new PutStone(row,col);
		sd.put(w,row,col);
		
		System.out.println(row+"x"+col+" ���̺� ��� : \n");
		
		for(int i=0;i<row;i++) {  // w�迭 ���
			for(int j=0;j<col;j++) {
				System.out.print(w[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(); 
		
		System.out.println("\n�� ���� ���� ���� �� = " + sd.pebble(row,col));  //  ������ ���
	}
}
