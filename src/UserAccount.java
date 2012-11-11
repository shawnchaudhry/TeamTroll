import java.io.Serializable;

/**
 * Represents a user account in the game.
 * 
 * @author TeamTroll
 * @version 1.0
 */
public class UserAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username, password;

	/**
	 * Creates the user account.
	 * 
	 * @param GameScreen
	 *            screen The screen of the game.
	 */
	public UserAccount(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Checks equality of two user accounts.
	 * 
	 * @param Object
	 *            o The object to check equality.
	 */
	public boolean equals(Object o) {
		return (username.equals(((UserAccount) o).getUser()) && password
				.equals(((UserAccount) o).getPass()));
	}

	/**
	 * Returns a string representing the user account.
	 * 
	 * @return String A string representing the user account.
	 */
	public String toString() {
		return "Username: " + username + " Password: " + password;
	}

	/**
	 * Getter for the username.
	 * 
	 * @return String The username.
	 */
	public String getUser() {
		return username;
	}

	/**
	 * Getter for the password.
	 * 
	 * @return String The password.
	 */
	public String getPass() {
		return password;
	}
}
