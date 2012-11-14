import java.io.Serializable;
import java.util.ArrayList;


/**
 * Database for the game. Saves the state of the game. Contains various methods
 * to find and edit the state of the game.
 * 
 * @author TeamTroll
 * @version 1.0
 */
public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameScreen screen;
	private UserAccount userAccount;
	private Player player;
	private Universe universe;
	private Planet planet;
	private ArrayList<UserAccount> accounts;

	/**
	 * Creates an instance of the game.
	 * 
	 * @param GameScreen
	 *            screen The screen of the game.
	 */
	public Game(GameScreen screen) {
		this.screen = screen;
		accounts = new ArrayList<UserAccount>();
	}

	/**
	 * Adds an account to the list of accounts.
	 * 
	 * @param UserAccount
	 *            acc The user account to be added.
	 */
	public void addAccount(UserAccount acc) {
		accounts.add(acc);
	}

	/**
	 * Checks if the specified account exists in the game.
	 * 
	 * @param UserAccount
	 *            acc The account to be checked.
	 */
	public boolean checkAccount(UserAccount acc) {
		return accounts.contains(acc);
	}

	/**
	 * Debugging method that prints out all the accounts in the game.
	 */
	public void printAccounts() {
		for (UserAccount ua : accounts)
			System.out.println(ua);
	}

	/**
	 * Getter for the GameScreen.
	 * 
	 * @return GameScreen screen The game's screen.
	 */
	public GameScreen getScreen() {
		return screen;
	}

	/**
	 * Setter for the user account.
	 * 
	 * @param UserAccount
	 *            userAccount The user account that is to be set.
	 */
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	/**
	 * Getter for the user account.
	 * 
	 * @return UserAccount The current user account.
	 */
	public UserAccount getUserAccount() {
		return userAccount;
	}

	/**
	 * Setter for the player.
	 * 
	 * @param Player
	 *            player The player to be set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Getter for the player.
	 * 
	 * @return Player player The current player.
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Setter for the universe.
	 * 
	 * @param Universe
	 *            universe The universe to be set.
	 */
	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	/**
	 * Getter for the universe.
	 * 
	 * @return Universe universe The current universe.
	 */
	public Universe getUniverse() {
		return universe;
	}

	/**
	 * Setter for the planet.
	 * 
	 * @param Planet
	 *            planet The planet to be set.
	 */
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	/**
	 * Getter for the planet.
	 * 
	 * @return Planet planet The current planet.
	 */
	public Planet getPlanet() {
		return planet;
	}

	/**
	 * Debugging method that allows the game to skip a few scenes.
	 */
	public void skip() {
		setUserAccount(new UserAccount("User", "Pass"));
		setPlayer(new Player("Name", 4, 4, 4, 4));
		setUniverse(new Universe(screen));
		screen.setScene(universe);
	}
	public String toString(){
		return super.toString();
	}
}
