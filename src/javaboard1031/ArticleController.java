//
package javaboard1031;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ArticleController {
	
	ArticleDao articleDao = new ArticleDao();
	Scanner sc = new Scanner(System.in);
	Member loginedMember = null;
	
	public ArticleController() {
		articleDao.init();
	}
	
	public void setLoginedMember(Member member) {
		this.loginedMember = member;
	}
	
	public void doCommand(String cmd) {
		if (cmd.equals("add")) {
			
			// �α��� üũ
			if(isLogin()) {
				addArticle();
			}
		}
		if (cmd.equals("list")) {
			printArticleList(articleDao.getArticles());
		}
		if (cmd.equals("update")) {
			updateArticle();
		}
		if (cmd.equals("delete")) {
			deleteArticle();
		}
		if (cmd.equals("read")) {
			readArticle();
		}
		if (cmd.equals("search")) {
			searchArticle();
		}
		if (cmd.equals("sort")) {
			sortArticle();
		}
	}
	
	public void sortArticle() {
		System.out.print("���� ����� �������ּ���. (id : ��ȣ, hit : ��ȸ��) : ");
		String sortTarget = sc.nextLine();
		System.out.print("���� ����� �������ּ���. (asc : ��������, desc : ��������) : ");
		String sortType = sc.nextLine();
		
		ArrayList<Article> articles = articleDao.getArticles();
		
		MyComp comp = new MyComp();
		comp.sortTarget = sortTarget;
		comp.sortType = sortType;
		
		
		Collections.sort(articles, comp);
		
		printArticleList(articles);
		
		
	}
	
	public boolean isMyArticle(Article article) {
		System.out.println("article : " + article);
		System.out.println("loginedMember : " + loginedMember);
		if(article.getWriterId().equals(loginedMember.getLoginId())) {
			return true;
		} else {
			System.out.println("�ڽ��� �Խù��� ����/������ �� �ֽ��ϴ�.");
			return false;
		}
	}
	
	public boolean isLogin() {
		if(loginedMember == null) {
			System.out.println("�α����� �ʿ��� ����Դϴ�.");
			return false;
		} else {
			return true;
		}
	}
	
	public void searchArticle() {

		System.out.println("�˻� �׸��� �������ּ��� (1. ����, 2. ����, 3. ���� + ����, 4. �ۼ���) : ");
		int searchTarget = Integer.parseInt(sc.nextLine());

		System.out.print("�˻� Ű���带 �Է����ּ��� : ");
		String keyword = sc.nextLine();

		ArrayList<Article> articles = articleDao.getArticles();

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			String targetStr = "";
			if (searchTarget == 1) {
				targetStr = article.getTitle();
			} else if (searchTarget == 2) {
				targetStr = article.getBody();
			} else if (searchTarget == 3) {
				targetStr = article.getTitle() + article.getBody();
			} else {
				targetStr = article.getWriter();
			}

			if (targetStr.contains(keyword)) {
				System.out.println("��ȣ : " + article.getId());
				System.out.println("���� : " + article.getTitle());
				System.out.println("��ϳ�¥ : " + article.getRegDate());
				System.out.println("��ȸ�� : " + article.getHit());
				System.out.println("�ۼ��� : " + article.getWriter());
				System.out.println("===================");
			}
		}
	}
	
	public void readProcess(Article article) {
		while (true) {
			System.out.print("�󼼺��� ����� �������ּ���(1. ��� ���, 2. ���ƿ�, 3. ����, 4. ����, 5. �������) : ");
			int rCmdNo = Integer.parseInt(sc.nextLine());

			if (rCmdNo == 1) {
				
				if(isLogin()) {					
					System.out.print("��� ������ �Է����ּ��� : ");
					String replyBody = sc.nextLine();
					Reply re = new Reply(article.getId(), replyBody, loginedMember.getNickname(), loginedMember.getLoginId());
					
					articleDao.addReply(re);
					System.out.println("����� ��ϵǾ����ϴ�.");
					
					printArticle(article);
				}

			} else if (rCmdNo == 2) {
				
				Like like = articleDao.getLikeByParentIdAndMemberLoginId(article.getId(), loginedMember.getLoginId());
				
				if(isLogin() && (like == null)) {
					
					like = new Like(article.getId(), loginedMember.getLoginId());
					articleDao.addLike(like);
					
					System.out.println("�ش� �Խù��� �����մϴ�.");	
					printArticle(article);
				} else {
					articleDao.removeLike(like);
					System.out.println("�ش� �Խù��� ���ƿ並 �����մϴ�.");
					printArticle(article);
				}
			} else if (rCmdNo == 3) {
				if(isLogin() && isMyArticle(article)) {
					updateMyArticle(article.getId());					
				}
			} else if (rCmdNo == 4) {
				if(isLogin() && isMyArticle(article)) {					
					deleteMyArticle(article.getId());
				}
			} else if (rCmdNo == 5) {
				break;
			}
		}
	}
	
	public void deleteMyArticle(int targetId) {		
		boolean rst = articleDao.deleteArticle(targetId);
		if (!rst) {
			System.out.println("���� �Խù� ��ȣ�Դϴ�.");
		}
	}
	
	public void updateMyArticle(int targetId) {
		
		System.out.print("���� : ");
		String title = sc.nextLine();
		System.out.print("���� : ");
		String body = sc.nextLine();

		boolean rst = articleDao.updateArticle(targetId, title, body);

		if (!rst) {
			System.out.println("���� �Խù� ��ȣ�Դϴ�.");
		}
	}
	
	public void readArticle() {
		System.out.print("�󼼺����� �Խù� ��ȣ : ");
		String aid = sc.nextLine();
		int targetId = Integer.parseInt(aid);

		Article article = articleDao.getArticleById(targetId);

		if (article == null) {
			System.out.println("���� �Խù��Դϴ�.");
		} else {

			int targetHit = article.getHit();
			article.setHit(targetHit + 1);

			printArticle(article);
			readProcess(article);
		}
	}
	
	public void deleteArticle() {
		System.out.print("������ �Խù� ��ȣ : ");
		String aid = sc.nextLine();
		int targetId = Integer.parseInt(aid);
		boolean rst = articleDao.deleteArticle(targetId);
		if (!rst) {
			System.out.println("���� �Խù� ��ȣ�Դϴ�.");
		}
	}
	
	public void updateArticle() {
		System.out.print("������ �Խù� ��ȣ : ");
		String aid = sc.nextLine();
		int targetId = Integer.parseInt(aid);

		System.out.print("���� : ");
		String title = sc.nextLine();
		System.out.print("���� : ");
		String body = sc.nextLine();

		boolean rst = articleDao.updateArticle(targetId, title, body);

		if (!rst) {
			System.out.println("���� �Խù� ��ȣ�Դϴ�.");
		}

	}
	
	public void printArticleList(ArrayList<Article> articles) {
	
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
	
	public void addArticle() {
		System.out.print("�Խù� ������ �Է����ּ��� : ");
		String title = sc.nextLine();
		System.out.print("�Խù� ������ �Է����ּ��� : ");
		String body = sc.nextLine();
		System.out.println("�Խù��� ��ϵǾ����ϴ�.");

		Article article1 = new Article(title, body, 0, loginedMember.getNickname(), loginedMember.getLoginId());

		articleDao.addArticle(article1);
	}
	
	public void printArticle(Article article) {

		System.out.println("��ȣ : " + article.getId());
		System.out.println("���� : " + article.getTitle());
		System.out.println("���� : " + article.getBody());
		System.out.println("��ϳ�¥ : " + article.getRegDate());
		System.out.println("��ȸ�� : " + article.getHit());
		System.out.println("���ƿ� : " + articleDao.getLikeCountByParentId(article.getId()));
		System.out.println("�ۼ��� : " + article.getWriter());
		System.out.println("======================");
		System.out.println("--------- ��� --------");

		ArrayList<Reply> replies = articleDao.getReplies();
		for (int i = 0; i < replies.size(); i++) {
			Reply re = replies.get(i);
			if (re.getParentId() == article.getId()) {
				System.out.println("���� : " + re.getBody());
			}
		}
	}
}

class MyComp implements Comparator<Article> {
	
	String sortTarget = "hit";
	String sortType = "asc";

	@Override
	public int compare(Article a1, Article a2) {
		if(sortTarget.equals("hit")) {
			if(sortType.equals("asc")) {
				if(a1.getHit() > a2.getHit()) {
					return 1;
				}
				return -1;							
			} else {
				if(a1.getHit() < a2.getHit()) {
					return 1;
				}
				return -1;
			}
		} else {
			if(sortType.equals("asc")) {
				if(a1.getId() > a2.getId()) {
					return 1;
				}
				return -1;							
			} else {
				if(a1.getId() < a2.getId()) {
					return 1;
				}
				return -1;
			}
		}
	}
	
}