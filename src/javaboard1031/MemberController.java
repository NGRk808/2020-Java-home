package javaboard1031;

import java.util.Scanner;

public class MemberController {
	
	MemberDao memberDao = new MemberDao();
	Scanner sc = new Scanner(System.in);
	Member loginedMember = null;
	
	public MemberController() {
		memberDao.init();
	}
	
	public Member getLoginedMember() {
		return this.loginedMember;
	}
	
	public void doCommand(String cmd) {
		if (cmd.equals("signup")) {
			memberSignUp();
		}
		if (cmd.equals("signin")) {
			memberSignin();
		} 
	}
	
	public void memberSignin() {
		System.out.print("���̵� : ");
		String loginId = sc.nextLine();
		System.out.print("��й�ȣ : ");
		String loginPw = sc.nextLine();

		Member member = memberDao.getLoginMember(loginId, loginPw);
		
		
		// �α��� ó��
		if (member != null) {
			loginedMember = member;
			System.out.println(member.getNickname() + "�� �ݰ����ϴ�.!");
		} else {
			System.out.println("��й�ȣ�� Ʋ�Ȱų� �߸��� ȸ�������Դϴ�.");
		}

	}
	
	public void memberSignUp() {
		System.out.println("==== ȸ�� ������ �����մϴ� ====");
		System.out.print("���̵� �Է����ּ��� : ");
		String loginId = sc.nextLine();
		System.out.print("��й�ȣ�� �Է����ּ��� : ");
		String loginPw = sc.nextLine();
		System.out.print("�г����� �Է����ּ��� : ");
		String nick = sc.nextLine();

		Member member = new Member(loginId, loginPw, nick);
		
		memberDao.addMember(member);
		
		System.out.println("==== ȸ�������� �Ϸ�Ǿ����ϴ�. ====");
	}
}