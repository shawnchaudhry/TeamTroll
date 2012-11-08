
public class UserAccount {
	private String username, password;
	private Player player;
	private Universe universe;

	public UserAccount(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean equals(Object o) {
		return (username.equals(((UserAccount)o).getUser()) && password.equals(((UserAccount)o).getPass()));
	}

	public String toString() {
		return "Username: " + username + " Password: " + password;
	}
	
	public String getUser() {
		return username;
	}
	
	public String getPass() {
		return password;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	public Universe getUniverse() {
		return universe;
	}
}
