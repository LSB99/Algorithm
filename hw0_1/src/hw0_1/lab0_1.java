package hw0_1;

import java.util.*;

class Calc{
	public static int abs(int n) {
		return (n>0)?n:-n;
	}
}

public class lab0_1 {
	
	public static void main(String[] args)
	{
		int[] array = {-30, -15, 1, 40, 50, 200, 315, 800, 9000, 12345};
		
		Scanner s = new Scanner(System.in);
		System.out.println("hw0_1 : �Ӽ���");
		System.out.println("���� ���߱� ���α׷��Դϴ�.");
		System.out.print("�ϳ��� �������� �Է��ϼ��� : ");
		
		int n = s.nextInt();
		
		for(int i=0;i<array.length;i++) {
			
			if (array[i]==n) {
				array[i]=0;
				continue;
			}
			
			else if(array[i]<0&&n>0) {
				array[i] = array[i]+n;
				continue;
			}
			
			else if(array[i]<0&&n<0) {
				array[i] = array[i]-n;
				continue;
			}
		
			else if(array[i]>n&&n>0) {
				array[i]= array[i]-n;
				continue;
			}
			
			else if(array[i]>n&&n<0) {
				array[i]= array[i]+n;
				continue;
			}
			
			else if(array[i]<n) {
				array[i]= n-array[i];
				continue;
			}
			
		}
		
		int min = Calc.abs(array[0]);
		
		for(int i=1;i<array.length;i++) {
			if(min>Calc.abs(array[i]))
				min = Calc.abs(array[i]);
		}
		int total = 100-min;
		System.out.println("���� = "+ total );
	}

}
