import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Scene to let user make an account.
 * 
 * @author TeamTroll
 * @version 1.0
 */
public class CreateAccount implements Scene {
	private GameScreen screen;
	final private JTextField userText, passText, repassText;
	final private JLabel userLabel, passLabel, repassLabel, outputLabel;
	final private JButton createButton, backButton;

	/**
	 * Creates the create account scene.
	 * 
	 * @param GameScreen
	 *            screen The screen of the game.
	 */
	public CreateAccount(final GameScreen screen) {
		this.screen = screen;

		userText = new JTextField(10);
		passText = new JTextField(10);
		repassText = new JTextField(10);

		userLabel = new JLabel("Username: ");
		passLabel = new JLabel("Password: ");
		repassLabel = new JLabel("Reenter Password: ");
		outputLabel = new JLabel();

		createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			/**
			 * Creates a new account.
			 * 
			 * @param ActionEvent
			 *            e The created action event.
			 */
			public void actionPerformed(ActionEvent e) {
				createAccount();
			}
		});

		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			/**
			 * Goes back to login screen.
			 * 
			 * @param ActionEvent
			 *            e The created action event.
			 */
			public void actionPerformed(ActionEvent e) {
				screen.setScene(new LogIn(screen));
			}
		});
	}

	/**
	 * Creates the user account with the text entered in the fields.
	 */
	public boolean createAccount() {
		
		final String user = userText.getText();
		final String pass = passText.getText();
		final String repass = repassText.getText();

		if (user.length() == 0)
			outputLabel.setText("Must enter a username.");
		else if (pass.length() == 0)
			outputLabel.setText("Must enter a password.");
		else if (!pass.equals(repass))
			outputLabel.setText("Passwords do not match.");
		else {
			screen.game.addAccount(new UserAccount(user, pass));
			screen.setScene(new LogIn(screen));
			return true;
		}
		return false;
		// Database.printAccounts();
	}
	
	public void setText(String user,String pass,String repass)
	{
		userText.setText(user);
		passText.setText(pass);
		repassText.setText(repass);
	}
	

	/**
	 * Paints the components onto the screen.
	 * 
	 * @param JPanel
	 *            p The panel to contain the components.
	 * @param Graphics
	 *            g The graphics to the corresponding page.
	 */
	@Override
	public void paint(JPanel p, Graphics g) {
		p.removeAll();

		p.add(userLabel);
		p.add(userText);
		p.add(passLabel);
		p.add(passText);
		p.add(repassLabel);
		p.add(repassText);
		p.add(outputLabel);

		p.add(createButton);
		p.add(backButton);

		p.revalidate();
	}
}
