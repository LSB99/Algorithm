package hw12_1;
import hw12.BoyerMooreHorspool;
import java.util.Scanner;
//***************************
//���ϸ�: BoyerMooreHorspoolTest.java
//�ۼ���: �Ӽ���
//�ۼ���: 2020�� 6�� 17��
//���α׷� ����: Boyer-Moore-Horspool �˰���  main Ŭ����
//***************************

public class BoyerMooreHorspoolTest {
	
	public static void main(String[] args) {
		
		System.out.println("hw12_1 : �Ӽ���\n");
		Scanner scanner = new Scanner(System.in);  
		
		char[] pattern;  // ���� ���ڿ��� ����  ���ڹ迭
		char[] text;    // �ؽ�Ʈ ���ڿ��� ����  ���ڹ迭
		
		System.out.print("���� �Է� : ");
		String p = scanner.next();
		pattern = p.toCharArray();  // ���ڿ���  ���ڹ迭�� ġȯ
		
		System.out.print("�ؽ�Ʈ �Է� : ");
		String t = scanner.next();
		text = t.toCharArray();   // ���ڿ���  ���ڹ迭�� ġȯ
		
		
		BoyerMooreHorspool bmh = new BoyerMooreHorspool(pattern,text);  // ��ü �����ϰ� �Ű�������  ����, �ؽ�Ʈ ���� �Ѱ��ش�.
		
		System.out.print("��Ī ��ġ = ");
	    bmh.match();   // ��Ī ��ġ ���
		
		System.out.print("\n���� �� = ");
		System.out.println(bmh.jumpcount());  //  ���� �� ���
		
	}
}
