package model;

public class User {
	private String username;
	private String password;
	protected boolean isSell;
	protected boolean isAdmin;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, boolean isSell, boolean isAdmin) {
		this.username = username;
		this.password = password;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSell() {
		return isSell;
	}

	public void setSell(boolean isSell) {
		this.isSell = isSell;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", isSell=" + isSell + ", isAdmin=" + isAdmin
				+ "]";
	}
	
}
