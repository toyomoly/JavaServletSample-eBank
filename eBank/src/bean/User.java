package bean;

public class User {

	private String userId;
	private String password;
	private String userName;
	private int saving;

	public User(String userId, String password, String userName, int saving) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.saving = saving;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public boolean equalsPassword(String password) {
		return this.password.equals(password);
	}

	public int getSaving() {
		return saving;
	}
}
