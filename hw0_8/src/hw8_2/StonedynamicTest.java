package hw8_2;
import java.util.Scanner;
import hw0_8.Stonedynamic;
//***************************
//���ϸ�: StonedynamicTest.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 5�� 20��
//����:  �� ���� ����  �������α׷���  ����Ŭ����
//***************************

public class StonedynamicTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("hw8_2 : �Ӽ���\n");
		System.out.println("�� ���� ������ �������α׷����� �̿��Ͽ� �����մϴ�. \n");
		
		int row = 3;   // ����� �� ����
	    int col = (int)(Math.random()*(8-5+1)+5);  //  5 ~ 8  �� �����ѹ��� �����Ѵ�. ����� �� ����
	    
		int[][] w = new int[row][col]; // 3 x col �迭
		
		for(int i=0;i<row;i++) {  // w�迭��  ���� ���� ����
			for(int j=0;j<col;j++) {
				w[i][j] = (int)(Math.random()*(15-(-15)+1)+(-15)); //  -15 ~ 15 �� �����ѹ��� �����Ѵ�. 
			}
		}
		
		Stonedynamic sd = new Stonedynamic(row,col);  
		sd.put(w,row,col);   // Stonedynamic Ŭ������ �迭��  w�迭 ����
		
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
