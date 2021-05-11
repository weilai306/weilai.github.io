package jluee.entity;

public class User {
	String userName;
	String passWord;
	String idendity;
	String status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isAdmin() {
		if (userName.equals("admin") && passWord.equals("admin"))
			return true;
		else
			return false;
	}

	public String getIdendity() {
		return idendity;
	}

	public void setIdendity(String idendity) {
		this.idendity = idendity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
