import javax.swing.*;

@SuppressWarnings("serial")
public class SpaceTrader extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("SPACE TRADER");
		frame.add(new GameScreen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
}
