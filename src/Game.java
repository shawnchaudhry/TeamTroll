public class Game {
	private static GameScreen screen;
	private static UserAccount userAccount;
	private static Player player;
	private static Universe universe;
	private static Planet planet;
	
	public Game(GameScreen screen) {
		Game.screen = screen;
		new Database();
	}
	
	public static GameScreen getScreen() {
		return screen;
	}
	
	public static void setUserAccount(UserAccount userAccount) {
		Game.userAccount = userAccount;
	}
	
	public static UserAccount getUserAccount() {
		return userAccount;
	}
	
	public static void setPlayer(Player player) {
		Game.player = player;
	}
	
	public static Player getPlayer() {
		return player;
	}

	public static Universe getUniverse() {
		return universe;
	}

	public static void setUniverse(Universe universe) {
		Game.universe = universe;
	}
	
	public static Planet getPlanet() {
		return planet;
	}

	public static void setPlanet(Planet planet) {
		Game.planet = planet;
	}
	
	public static void skip() {
		setUserAccount(new UserAccount("User", "Pass"));
		setPlayer(new Player("Name", 4, 4, 4, 4));
		setUniverse(new Universe(screen));
		screen.setScene(universe);
	}
	
}
