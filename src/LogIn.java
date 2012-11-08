import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LogIn implements Scene {
	private JLabel title, userLabel, passLabel, output;
	private JTextField user, pass;
	private JButton login, newUser, skipAhead;
	private GameScreen screen;
	
	public LogIn(final GameScreen screen) {
		this.screen = screen;

		title = new JLabel("Space Trader");
		userLabel = new JLabel("Username:");
		passLabel = new JLabel("Password:");
		output = new JLabel();

		user = new JTextField(10);
		pass = new JTextField(10);

		login = new JButton("Login");
		newUser = new JButton("Create Account");
		skipAhead = new JButton("skipAhead");

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		newUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setScene(new CreateAccount(screen));
			}
		});
		
		skipAhead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.skip();
			}
		});
	}

	public void login() {
	 	String userInput = user.getText();
	 	String passInput = pass.getText();

	 	if(!Database.checkAccount(new UserAccount(userInput, passInput)))
	 		output.setText("Invalid Account");
	 	else {
	 		Game.setUserAccount(new UserAccount(userInput, passInput));
	 		screen.setScene(new CreatePlayer(screen));
	 	}
	}
	
	public void paint(JPanel p, Graphics g) {
		p.removeAll();

		p.add(title);
		p.add(userLabel);
		p.add(user);
		p.add(passLabel);
		p.add(pass);
		p.add(login);
		p.add(output);
		p.add(newUser);
		p.add(skipAhead);

		p.revalidate();
	}

}
