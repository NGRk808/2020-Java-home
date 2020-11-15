package javaboard1031;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Member> members = new ArrayList<>();
	static ArticleDao articleDao = new ArticleDao();
	
	public static void printArticle(Article article) {
		
		System.out.println("��ȣ : " + article.getId());
		System.out.println("���� : " + article.getTitle());
		System.out.println("���� : " + article.getBody());
		System.out.println("��ϳ�¥ : " + article.getRegDate());
		System.out.println("��ȸ�� : " + article.getHit());
		System.out.println("�ۼ��� : " + article.getWriter());
		System.out.println("======================");
		System.out.println("--------- ��� --------");
		
		ArrayList<Reply> replies = articleDao.getReplies();
		for(int i = 0; i < replies.size(); i++) {
			Reply re = replies.get(i);
			if(re.getParentId() == article.getId()) {
				System.out.println("���� : " + re.getBody());				
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		Member loginedMember = null;
		
		
		while (true) {
			if(loginedMember == null) {
				System.out.print("��ɾ �Է����ּ��� : ");				
			} else {
				System.out.print("��ɾ �Է����ּ��� [" + loginedMember.getLoginId() + "(" + loginedMember.getNickname() + ")] : ");				
			}
			String cmd = sc.nextLine();
			if (cmd.equals("exit")) {
				System.out.println("����");
				break;
			}

			if (cmd.equals("add")) {

				System.out.print("�Խù� ������ �Է����ּ��� : ");
				String title = sc.nextLine();
				System.out.print("�Խù� ������ �Է����ּ��� : ");
				String body = sc.nextLine();
				System.out.println("�Խù��� ��ϵǾ����ϴ�.");

				Article article1 = new Article(title, body, 0,  "�͸�");
				
				articleDao.addArticle(article1);
				

			}
			if (cmd.equals("list")) {
				ArrayList<Article> articles = articleDao.getArticles();
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					System.out.println("��ȣ : " + article.getId());
					System.out.println("���� : " + article.getTitle());
					System.out.println("��ϳ�¥ : " + article.getRegDate());
					System.out.println("��ȸ�� : " + article.getHit());
					System.out.println("�ۼ��� : " + article.getWriter());
					System.out.println("===================");
				}
			}

			if (cmd.equals("update")) {
				System.out.print("������ �Խù� ��ȣ : ");
				String aid = sc.nextLine();
				int targetId = Integer.parseInt(aid);
				
				System.out.print("���� : ");
				String title = sc.nextLine();
				System.out.print("���� : ");
				String body = sc.nextLine();
				
				boolean rst = articleDao.updateArticle(targetId, title, body);
				
				if(!rst) {
					System.out.println("���� �Խù� ��ȣ�Դϴ�.");
				}

			}

			if (cmd.equals("delete")) {
				System.out.print("������ �Խù� ��ȣ : ");
				String aid = sc.nextLine();
				int targetId = Integer.parseInt(aid);
				boolean rst = articleDao.deleteArticle(targetId);
				if(!rst) {
					System.out.println("���� �Խù� ��ȣ�Դϴ�.");
				}
			}
			if(cmd.equals("read")) {
				System.out.print("�󼼺����� �Խù� ��ȣ : ");
				String aid = sc.nextLine();
				int targetId = Integer.parseInt(aid);
				
				Article article = articleDao.getArticleById(targetId);
				
				if(article == null) {
					System.out.println("���� �Խù��Դϴ�.");
				} else {
					
					int targetHit = article.getHit();
					article.setHit(targetHit + 1);
					
					printArticle(article);
					
					while(true) {
						System.out.print("�󼼺��� ����� �������ּ���(1. ��� ���, 2. ���ƿ�, 3. ����, 4. ����, 5. �������) : ");
						int rCmdNo = Integer.parseInt(sc.nextLine());
						
						if(rCmdNo == 1) {
							
							System.out.print("��� ������ �Է����ּ��� : ");
							String replyBody = sc.nextLine();
							Reply re = new Reply(article.getId(), replyBody, "�͸�");
							
							articleDao.addReply(re);
							System.out.println("����� ��ϵǾ����ϴ�.");
							
							printArticle(article);
							
						} else if(rCmdNo == 2) {
							System.out.println("[���ƿ� ���]");
						} else if(rCmdNo == 3) {
							System.out.println("[���� ���]");
						} else if(rCmdNo == 4) {
							System.out.println("[���� ���]");
						} else if(rCmdNo == 5) {
							break;
						}
					}
				}
			}
			
			if(cmd.equals("search")) {
				
				System.out.println("�˻� �׸��� �������ּ��� (1. ����, 2. ����, 3. ���� + ����, 4. �ۼ���) : ");
				int searchTarget = Integer.parseInt(sc.nextLine());
				
				System.out.print("�˻� Ű���带 �Է����ּ��� : ");
				String keyword = sc.nextLine();
				
				ArrayList<Article> articles = articleDao.getArticles();
				
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					String targetStr = "";
					if(searchTarget == 1) {
						targetStr = article.getTitle();
					} else if(searchTarget == 2) {
						targetStr = article.getBody();
					} else if(searchTarget == 3) {
						targetStr = article.getTitle() + article.getBody();
					} else {
						targetStr = article.getWriter();
					}
					
					if(targetStr.contains(keyword)) {
						System.out.println("��ȣ : " + article.getId());
						System.out.println("���� : " + article.getTitle());
						System.out.println("��ϳ�¥ : " + article.getRegDate());
						System.out.println("��ȸ�� : " + article.getHit());
						System.out.println("�ۼ��� : " + article.getWriter());
						System.out.println("===================");
					}
				}
			}
			if(cmd.equals("signup")) {
				System.out.println("==== ȸ�� ������ �����մϴ� ====");
				System.out.print("���̵� �Է����ּ��� : ");
				String loginId = sc.nextLine();
				System.out.print("��й�ȣ�� �Է����ּ��� : ");
				String loginPw = sc.nextLine();
				System.out.print("�г����� �Է����ּ��� : ");
				String nick = sc.nextLine();
			
				Member member = new Member(loginId, loginPw, nick);
				members.add(member);
				System.out.println("==== ȸ�������� �Ϸ�Ǿ����ϴ�. ====");
				
			}
			if(cmd.equals("signin")) {
				System.out.print("���̵� : ");
				String loginId = sc.nextLine();
				System.out.print("��й�ȣ : ");
				String loginPw = sc.nextLine();
				
				boolean loginFlag = false; // �α��� ���� ����
				Member member = null;
				
				for(int i = 0; i < members.size(); i++) {
					member = members.get(i);
					String targetId = member.getLoginId();
					String targetPw = member.getLoginPw();
					
					if(loginId.equals(targetId) && loginPw.equals(targetPw)) {
						loginFlag = true;
						break;
					} 
				}
				// �α��� ó��
				if(loginFlag) {
					loginedMember = member;
					System.out.println(member.getNickname() + "�� �ݰ����ϴ�.!");
				} else {
					System.out.println("��й�ȣ�� Ʋ�Ȱų� �߸��� ȸ�������Դϴ�.");
				}
				
			}
		}
	}
}
