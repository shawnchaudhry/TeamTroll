import javax.swing.*;
 
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
    public static void main(String[] args) {
        JFrame frame = new JFrame("SPACE TRADER");
        frame.add(new GameScreen());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}