package javaboard1031;

public class Like {
	private int parentId; // ���Խñ۹�ȣ
	private String checkMemberId; // üũ�� ��� ���̵�
	private String regDate; // ��� ��¥
	
	public Like(int parentId, String checkMemberId) {
		super();
		this.parentId = parentId;
		this.checkMemberId = checkMemberId;
	}
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getCheckMemberId() {
		return checkMemberId;
	}
	public void setCheckMemberId(String checkMemberId) {
		this.checkMemberId = checkMemberId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}