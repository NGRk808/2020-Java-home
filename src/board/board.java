package board;
import java.util.Scanner;
public class board {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("명령어를 입력해주세요. :");
			String cmd = scan.nextLine();
			
			if(cmd.equals("exit")) {
				break;
			}
			if(cmd.equals("add")) {
				System.out.println("게시물 제목을 입력해주세요. : ");
				String cmd제목 = scan.nextLine();
				System.out.println("게시물 내용을 입력해주세요. : ");
				String cmd내용 = scan.nextLine();
				System.out.println("게시물이 등록되었습니다.");
			}
		}
		System.out.println("시스템을 종료합니다.");
		scan.close();
	}

}
