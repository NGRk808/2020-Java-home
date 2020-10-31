package board;
import java.util.Scanner;

public class board {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		게시판 a게시판관리 = new 게시판();
		
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
				게시판add 게시물 = new 게시판add(cmd제목, cmd내용);
				a게시판관리.게시물저장(게시물);
				System.out.println("게시물이 등록되었습니다.");
			}
			
			if(cmd.equals("list")) {
				a게시판관리.게시물조회();				
			}
		}
		System.out.println("시스템을 종료합니다.");
		scan.close();
	}

}

class 게시판add {
	String 제목;
	String 내용;

	게시판add(String cmd제목, String cmd내용) {
		제목 = cmd제목;
		내용 = cmd내용;
		
	}
}

class 게시판 {

	게시판add[] 게시판정보 = new 게시판add[10];
	int size = 0;
	
	void 게시물저장(게시판add a게시판add) {		
		게시판정보[size] = a게시판add;
		size++;
	}
	
	void 게시물조회() {
		for (int i = 0; i < size; i++) {
			게시판add a게시판add = 게시판정보[i];
			System.out.println("제목 : " + a게시판add.제목);
			System.out.println("내용 : " + a게시판add.내용);
			System.out.println("=====================");
		}
	}
}
