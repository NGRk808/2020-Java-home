package javaboard1031;

public class Member {
	private	String loginId;
	private String loginPw;
	private String Nickname;
	
	Member(String loginId, String loginPw, String NickName) {
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.Nickname = Nickname;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getNickname() {
		return Nickname;
	}

	public void setNickname(String nickname) {
		Nickname = nickname;
	}
}
