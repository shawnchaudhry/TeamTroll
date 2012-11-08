import java.util.*;

/**
 * Database for the game. Saves the state of the game. Contains various methods
 * to find and edit the state of the game.
 * 
 * @author TeamTroll
 * @version 1.0
 */
public class Game {
	private static GameScreen screen;
	private static UserAccount userAccount;
	private static Player player;
	private static Universe universe;
	private static Planet planet;
	private static ArrayList<UserAccount> accounts;

	/**
	 * Creates an instance of the game.
	 * 
	 * @param GameScreen
	 *            screen The screen of the game.
	 */
	public Game(GameScreen screen) {
		Game.screen = screen;
		accounts = new ArrayList<UserAccount>();
	}

	/**
	 * Adds an account to the list of accounts.
	 * 
	 * @param UserAccount
	 *            acc The user account to be added.
	 */
	public static void addAccount(UserAccount acc) {
		accounts.add(acc);
	}

	/**
	 * Checks if the specified account exists in the game.
	 * 
	 * @param UserAccount
	 *            acc The account to be checked.
	 */
	public static boolean checkAccount(UserAccount acc) {
		return accounts.contains(acc);
	}

	/**
	 * Debugging method that prints out all the accounts in the game.
	 */
	public static void printAccounts() {
		for (UserAccount ua : accounts)
			System.out.println(ua);
	}

	/**
	 * Getter for the GameScreen.
	 * 
	 * @return GameScreen screen The game's screen.
	 */
	public static GameScreen getScreen() {
		return screen;
	}

	/**
	 * Setter for the user account.
	 * 
	 * @param UserAccount
	 *            userAccount The user account that is to be set.
	 */
	public static void setUserAccount(UserAccount userAccount) {
		Game.userAccount = userAccount;
	}

	/**
	 * Getter for the user account.
	 * 
	 * @return UserAccount The current user account.
	 */
	public static UserAccount getUserAccount() {
		return userAccount;
	}

	/**
	 * Setter for the player.
	 * 
	 * @param Player
	 *            player The player to be set.
	 */
	public static void setPlayer(Player player) {
		Game.player = player;
	}

	/**
	 * Getter for the player.
	 * 
	 * @return Player player The current player.
	 */
	public static Player getPlayer() {
		return player;
	}

	/**
	 * Setter for the universe.
	 * 
	 * @param Universe
	 *            universe The universe to be set.
	 */
	public static void setUniverse(Universe universe) {
		Game.universe = universe;
	}

	/**
	 * Getter for the universe.
	 * 
	 * @return Universe universe The current universe.
	 */
	public static Universe getUniverse() {
		return universe;
	}

	/**
	 * Setter for the planet.
	 * 
	 * @param Planet
	 *            planet The planet to be set.
	 */
	public static void setPlanet(Planet planet) {
		Game.planet = planet;
	}

	/**
	 * Getter for the planet.
	 * 
	 * @return Planet planet The current planet.
	 */
	public static Planet getPlanet() {
		return planet;
	}

	/**
	 * Debugging method that allows the game to skip a few scenes.
	 */
	public static void skip() {
		setUserAccount(new UserAccount("User", "Pass"));
		setPlayer(new Player("Name", 4, 4, 4, 4));
		setUniverse(new Universe(screen));
		screen.setScene(universe);
	}

}
