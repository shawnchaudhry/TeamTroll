import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameScreen extends JPanel {
	private Scene scene;
	
	public GameScreen() {
		scene = new LogIn(this);
		new Game(this);
		setPreferredSize(new Dimension(518, 639));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		scene.paint(this, g);
	}

	public void setScene(Scene scene) {
		this.scene = scene;
		repaint();
	}

	public Scene getScene() {
		return scene;
	}
}
