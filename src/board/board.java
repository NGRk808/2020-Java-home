package board;
import java.util.Scanner;

public class board {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		�Խ��� a�Խ��ǰ��� = new �Խ���();
		
		while(true) {
			System.out.println("��ɾ �Է����ּ���. :");
			String cmd = scan.nextLine();
			
			if(cmd.equals("exit")) {
				break;
			}
			
			if(cmd.equals("add")) {
				System.out.println("�Խù� ������ �Է����ּ���. : ");
				String cmd���� = scan.nextLine();
				System.out.println("�Խù� ������ �Է����ּ���. : ");
				String cmd���� = scan.nextLine();
				�Խ���add �Խù� = new �Խ���add(cmd����, cmd����);
				a�Խ��ǰ���.�Խù�����(�Խù�);
				System.out.println("�Խù��� ��ϵǾ����ϴ�.");
			}
			
			if(cmd.equals("list")) {
				a�Խ��ǰ���.�Խù���ȸ();				
			}
		}
		System.out.println("�ý����� �����մϴ�.");
		scan.close();
	}

}

class �Խ���add {
	String ����;
	String ����;

	�Խ���add(String cmd����, String cmd����) {
		���� = cmd����;
		���� = cmd����;
		
	}
}

class �Խ��� {

	�Խ���add[] �Խ������� = new �Խ���add[10];
	int size = 0;
	
	void �Խù�����(�Խ���add a�Խ���add) {		
		�Խ�������[size] = a�Խ���add;
		size++;
	}
	
	void �Խù���ȸ() {
		for (int i = 0; i < size; i++) {
			�Խ���add a�Խ���add = �Խ�������[i];
			System.out.println("���� : " + a�Խ���add.����);
			System.out.println("���� : " + a�Խ���add.����);
			System.out.println("=====================");
		}
	}
}
