package javaboard1031;

public class Reply {
	private int parentId; // 원게시물 번호
	private String body; // 댓글 내용
	private String wirter; // 댓글 작성자
	private String wirterId; // 댓글 작성자 아이디
	private String regDate; // 댓글 작성일
	
	public Reply(int parentId, String body, String wirter, String wirterId) {
		super();
		this.parentId = parentId;
		this.body = body;
		this.wirter = wirter;
		this.wirterId = wirterId;
	}
	
	public Reply(int parentId, String body, String wirter, String regDate, String wirterId) {
		super();
		this.parentId = parentId;
		this.body = body;
		this.wirter = wirter;
		this.regDate = regDate;
		this.wirterId = wirterId;
	}
	
	public String getWirterId() {
		return wirterId;
	}

	public void setWirterId(String wirterId) {
		this.wirterId = wirterId;
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