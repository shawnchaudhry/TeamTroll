import javax.swing.JFrame;

/**
 * Driver class for the Space Trader game.
 * 
 * @author TeamTroll
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SpaceTrader extends JFrame {
	/**
	 * Main method.
	 */

	// This method now sets up the driver object and then calls the run method.
	public static void main(String[] args) {
		final Driver driver = new Driver();
		driver.run();
	}
}
