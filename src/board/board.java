package board;
import java.util.Scanner;
public class board {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
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
				System.out.println("�Խù��� ��ϵǾ����ϴ�.");
			}
		}
		System.out.println("�ý����� �����մϴ�.");
		scan.close();
	}

}
