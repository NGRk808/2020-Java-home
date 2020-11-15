package javaboard1031;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArticleDao {
	private ArrayList<Article> articles = new ArrayList<>();
	private ArrayList<Reply> replies = new ArrayList<>();
	int id = 4;
	
	public String getCurrentDate() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM.dd");
		Date time = new Date();		
		String time1 = format1.format(time);
		return time1;
	}
	
	public void init() {
		
		Article a1 = new Article(1, "�ȳ��ϼ���", "����1", getCurrentDate(), 0, "ȫ�浿");
		Article a2 = new Article(2, "�ݰ����ϴ�", "����2", getCurrentDate(), 0, "ȫ�浿");
		Article a3 = new Article(3, "�ȳ�2", "����3", getCurrentDate(), 0, "�̼���");  
		
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
	}
	
	public void addReply(Reply reply) {
		reply.setRegDate(getCurrentDate());
		replies.add(reply);
	}
	
	public void addArticle(Article article1) {
		article1.setId(id);
		article1.setRegDate(getCurrentDate());
		articles.add(article1);
		id++;
	}
	
	public boolean updateArticle(int id, String title, String body) {
		int index = getArticleIndexById(id);
		if(index != -1) {
			Article article = articles.get(index);
			article.setTitle(title);
			article.setBody(body);
			
			articles.set(index, article);
			return true;
		} 
		
		return false;
	}
	
	public boolean deleteArticle(int id) {
		int index = getArticleIndexById(id);
		if(index != -1) {
			articles.remove(index);
			return true;
		}
		
		return false;
	}
	
	public Article getArticleById(int id) {
		int index = getArticleIndexById(id);
		if(index == -1) {
			return null;
		} else {
			return articles.get(index);
		}
	}
	
	public int getArticleIndexById(int aid) {

		int existFlag = 1; // 1 ����, 2 �ִ�.
		int index = -1; // -1 ����.

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			if (aid == article.getId()) {
				existFlag = 2;
				index = i;
			}
		}

		return index;

	}
	
	public ArrayList<Article> getArticles() {
		return articles;
	}
	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
	public ArrayList<Reply> getReplies() {
		return replies;
	}
	public void setReplies(ArrayList<Reply> replies) {
		this.replies = replies;
	}	
	
}
