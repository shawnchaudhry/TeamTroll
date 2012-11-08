import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * Scene to let user log into game.
 * 
 * @author TeamTroll
 * @version 1.0
 */
public class LogIn implements Scene {
	private JLabel titleLabel, userLabel, passLabel, outputLabel;
	private JTextField userText, passText;
	private JButton loginButton, newAccButton, skipAheadButton;
	private GameScreen screen;

	/**
	 * Creates the login scene.
	 * 
	 * @param GameScreen
	 *            screen The screen of the game.
	 */
	public LogIn(final GameScreen screen) {
		this.screen = screen;

		titleLabel = new JLabel("Space Trader");
		userLabel = new JLabel("Username:");
		passLabel = new JLabel("Password:");
		outputLabel = new JLabel();

		userText = new JTextField(10);
		passText = new JTextField(10);

		loginButton = new JButton("Login");
		newAccButton = new JButton("Create Account");
		skipAheadButton = new JButton("skipAheadButton");

		loginButton.addActionListener(new ActionListener() {
			/**
			 * Go to create player scene.
			 * 
			 * @param ActionEvent
			 *            e The created action event.
			 */
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		newAccButton.addActionListener(new ActionListener() {
			/**
			 * Goes to create account scene.
			 * 
			 * @param ActionEvent
			 *            e The created action event.
			 */
			public void actionPerformed(ActionEvent e) {
				screen.setScene(new CreateAccount(screen));
			}
		});

		skipAheadButton.addActionListener(new ActionListener() {
			/**
			 * Skips to universe scene.
			 * 
			 * @param ActionEvent
			 *            e The created action event.
			 */
			public void actionPerformed(ActionEvent e) {
				Game.skip();
			}
		});
	}

	/**
	 * Checks if login data is valid. If so, goes to the create player scene.
	 * Otherwise, goes to the universe screen.
	 */
	public void login() {
		String userInput = userText.getText();
		String passInput = passText.getText();

		if (userText.getText().length() == 0
				&& passText.getText().length() == 0)
			outputLabel.setText("Enter account information");
		else if (!Game.checkAccount(new UserAccount(userInput, passInput)))
			outputLabel.setText("Invalid Account");
		else if (Game.getPlayer() == null) {
			Game.setUserAccount(new UserAccount(userInput, passInput));
			screen.setScene(new CreatePlayer(screen));
		} else
			screen.setScene(Game.getUniverse());
	}

	/**
	 * Paints the components onto the screen.
	 * 
	 * @param JPanel
	 *            p The panel to contain the components.
	 * @param Graphics
	 *            g The graphics to the corresponding page.
	 */
	public void paint(JPanel p, Graphics g) {
		p.removeAll();

		p.add(titleLabel);
		p.add(userLabel);
		p.add(userText);
		p.add(passLabel);
		p.add(passText);
		p.add(loginButton);
		p.add(outputLabel);
		p.add(newAccButton);
		p.add(skipAheadButton);

		p.revalidate();
	}

}
