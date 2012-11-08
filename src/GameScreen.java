import javax.swing.*;
import java.awt.*;

/**
 * Represents the screen of the game. This is where all the items of the game
 * are drawn onto.
 * 
 * @author TeamTroll
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GameScreen extends JPanel {
	private Scene scene;

	/**
	 * Creates the create game's screen.
	 */
	public GameScreen() {
		scene = new LogIn(this);
		new Game(this);
		setPreferredSize(new Dimension(518, 639));
	}

	/**
	 * Paints items onto the screen.
	 * 
	 * @param Graphics
	 *            g The screen of the game.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		scene.paint(this, g);
	}

	/**
	 * Sets the scene of the current game.
	 * 
	 * @param Scene
	 *            scene The scene to be set.
	 */
	public void setScene(Scene scene) {
		this.scene = scene;
		repaint();
	}

	/**
	 * Getter for the scene.
	 * 
	 * @return Scene The current scene.
	 */
	public Scene getScene() {
		return scene;
	}
}
