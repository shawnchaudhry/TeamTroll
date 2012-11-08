import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class CreateAccount implements Scene {
	private GameScreen screen;
	private JTextField userText, passText, repassText;
	private JLabel userLabel, passLabel, repassLabel, output;
	private JButton create;

	public CreateAccount(final GameScreen screen) {
		this.screen = screen;

		userText = new JTextField(10);
		passText = new JTextField(10);
		repassText = new JTextField(10);

		userLabel = new JLabel("Username: ");
		passLabel = new JLabel("Password: ");
		repassLabel = new JLabel("Reenter Password: ");
		output = new JLabel();

		create = new JButton("Create");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createAccount();
			}
		});
	}

	public void createAccount() {
		String user = userText.getText();
		String pass = passText.getText();
		String repass = repassText.getText();

		if(user.length() == 0)
			output.setText("Must enter a username.");
		else if(pass.length() == 0)
			output.setText("Must enter a password.");
		else if(!pass.equals(repass)) 
			output.setText("Passwords do not match.");
		else {
			Database.addAccount(new UserAccount(user, pass));
			screen.setScene(new LogIn(screen));
		}

		Database.printAccounts();
	}

	@Override
	public void paint(JPanel p, Graphics g) {
		p.removeAll();
		
		p.add(userLabel);
		p.add(userText);
		p.add(passLabel);
		p.add(passText);
		p.add(repassLabel);
		p.add(repassText);

		p.add(output);
		p.add(create);

		p.revalidate();
	}
}	
