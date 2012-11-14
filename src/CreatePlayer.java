import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Scene to let user make a player.
 * 
 * @author TeamTroll
 * @version 1.0
 */
public class CreatePlayer implements Scene {
	private JLabel playerNameLabel, fightLabel, tradeLabel, enginLabel,
			pilotLabel, statsLabel, outputLabel;
	private JTextField playerNameText;
	private int stats, fight, trade, engin, pilot;
	private JButton fightPlusButton, fightMinusButton, tradePlusButton,
			tradeMinusButton, enginPlusButton, enginMinusButton,
			pilotPlusButton, pilotMinusButton, createButton;

	/**
	 * Creates the create player scene.
	 * 
	 * @param GameScreen
	 *            screen The screen of the game.
	 */
	public CreatePlayer(final GameScreen screen) {
		fight = 0;
		trade = 0;
		engin = 0;
		pilot = 0;

		stats = 16;

		playerNameLabel = new JLabel("Enter Player Name: ");

		fightLabel = new JLabel("Fighter: " + fight);
		tradeLabel = new JLabel("Trader: " + trade);
		enginLabel = new JLabel("Engineer: " + engin);
		pilotLabel = new JLabel("Pilot: " + pilot);
		outputLabel = new JLabel();

		statsLabel = new JLabel("Skill points: " + stats);

		playerNameText = new JTextField(10);

		fightPlusButton = new JButton("+");
		fightMinusButton = new JButton("-");
		tradePlusButton = new JButton("+");
		tradeMinusButton = new JButton("-");
		enginPlusButton = new JButton("+");
		enginMinusButton = new JButton("-");
		pilotPlusButton = new JButton("+");
		pilotMinusButton = new JButton("-");

		createButton = new JButton("create");

		fightPlusButton.addActionListener(new StatListener(1, 1));
		fightMinusButton.addActionListener(new StatListener(1, -1));
		tradePlusButton.addActionListener(new StatListener(2, 1));
		tradeMinusButton.addActionListener(new StatListener(2, -1));
		enginPlusButton.addActionListener(new StatListener(3, 1));
		enginMinusButton.addActionListener(new StatListener(3, -1));
		pilotPlusButton.addActionListener(new StatListener(4, 1));
		pilotMinusButton.addActionListener(new StatListener(4, -1));

		createButton.addActionListener(new ActionListener() {
			/**
			 * Uses inputted text to create a new Player.
			 * 
			 * @param ActionEvent
			 *            e The created action event.
			 */
			public void actionPerformed(ActionEvent e) {
				String playerName = playerNameText.getText();
				if (playerName.length() == 0)
					outputLabel.setText("Must enter player name.");
				else if (stats != 0)
					outputLabel.setText("Must allocate all skill points.");
				else {
					screen.game.setPlayer(new Player(playerName, fight, trade, engin,
							pilot));
					screen.game.setUniverse(new Universe(screen));

					screen.setScene(screen.game.getUniverse());
				}
			}
		});
	}

	/**
	 * Helper class to allocate skill points.
	 */
	private class StatListener implements ActionListener {
		private int stat;
		private int delta;

		/**
		 * Creates a new listener for the stat buttons.
		 * 
		 * @param int stat An int identifier for the stat.
		 * @param int delta The change in stat, either 1 or -1.
		 */
		public StatListener(int stat, int delta) {
			this.stat = stat;
			this.delta = delta;
		}

		/**
		 * Changes the value of a stat accordingly.
		 * 
		 * @param ActionEvent
		 *            e The created action event.
		 */
		public void actionPerformed(ActionEvent e) {
			if (stat == 1) { // fight, might change these to enums
				if (0 <= (fight + delta) && (fight + delta) <= 16
						&& 0 <= (stats + delta * -1)) {
					fight += delta;
					stats += (delta * -1);
					fightLabel.setText("Fighter: " + fight);
					statsLabel.setText("Skill points: " + stats);
				}
			} else if (stat == 2) { // trade
				if (0 <= (trade + delta) && (trade + delta) <= 16
						&& 0 <= (stats + delta * -1)) {
					trade += delta;
					stats += (delta * -1);
					tradeLabel.setText("Trader: " + trade);
					statsLabel.setText("Skill points: " + stats);
				}
			} else if (stat == 3) { // engineer
				if (0 <= (engin + delta) && (engin + delta) <= 16
						&& 0 <= (stats + delta * -1)) {
					engin += delta;
					stats += (delta * -1);
					enginLabel.setText("Engineer: " + engin);
					statsLabel.setText("Skill points: " + stats);
				}
			} else if (stat == 4) { // pilot
				if (0 <= (pilot + delta) && (pilot + delta) <= 16
						&& 0 <= (stats + delta * -1)) {
					pilot += delta;
					stats += (delta * -1);
					pilotLabel.setText("Pilot: " + pilot);
					statsLabel.setText("Skill points: " + stats);
				}
			}
		}

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

		p.add(playerNameLabel);
		p.add(playerNameText);

		p.add(statsLabel);

		p.add(fightLabel);
		p.add(fightPlusButton);
		p.add(fightMinusButton);

		p.add(tradeLabel);
		p.add(tradePlusButton);
		p.add(tradeMinusButton);

		p.add(enginLabel);
		p.add(enginPlusButton);
		p.add(enginMinusButton);

		p.add(pilotLabel);
		p.add(pilotPlusButton);
		p.add(pilotMinusButton);

		p.add(createButton);
		p.add(outputLabel);

		p.revalidate();

	}

}
