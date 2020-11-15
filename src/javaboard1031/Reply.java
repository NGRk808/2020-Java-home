package javaboard1031;

public class Reply {
	private int parentId; // ���Խù� ��ȣ
	private String body; // ��� ����
	private String wirter; // ��� �ۼ���
	private String regDate; // ��� �ۼ���
	
	public Reply(int parentId, String body, String wirter) {
		super();
		this.parentId = parentId;
		this.body = body;
		this.wirter = wirter;
	}
	
	public Reply(int parentId, String body, String wirter, String regDate) {
		super();
		this.parentId = parentId;
		this.body = body;
		this.wirter = wirter;
		this.regDate = regDate;
	}
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWirter() {
		return wirter;
	}
	public void setWirter(String wirter) {
		this.wirter = wirter;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
