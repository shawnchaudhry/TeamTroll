import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class CreatePlayer implements Scene {
	private JLabel playerNameLabel, fightLabel, tradeLabel, enginLabel, pilotLabel, statsLabel, output;
	private JTextField playerNameText;
	private int stats;
	private JButton fightPlus, fightMinus, tradePlus, tradeMinus, enginPlus, enginMinus, 
		pilotPlus, pilotMinus, create;
	private int fight, trade, engin, pilot;
	
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
		output = new JLabel();

		statsLabel = new JLabel("Skill points: " + stats);

		playerNameText = new JTextField(10);

		fightPlus = new JButton("+");
		fightMinus = new JButton("-");
		tradePlus = new JButton("+");
		tradeMinus = new JButton("-");
		enginPlus = new JButton("+");
		enginMinus = new JButton("-");
		pilotPlus = new JButton("+");
		pilotMinus = new JButton("-");

		create = new JButton("create");

		fightPlus.addActionListener(new StatListener(1, 1));
		fightMinus.addActionListener(new StatListener(1, -1));
		tradePlus.addActionListener(new StatListener(2, 1));
		tradeMinus.addActionListener(new StatListener(2, -1));
		enginPlus.addActionListener(new StatListener(3, 1));
		enginMinus.addActionListener(new StatListener(3, -1));
		pilotPlus.addActionListener(new StatListener(4, 1));
		pilotMinus.addActionListener(new StatListener(4, -1));

		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName = playerNameText.getText();
				if(playerName.length() == 0)
					output.setText("Must enter player name.");
				else if(stats != 0)
					output.setText("Must allocate all skill points.");
				else {
					UserAccount acc = Game.getUserAccount();
					Player newPlayer = new Player(playerName, fight, trade, engin, pilot);
					acc.setPlayer(newPlayer);
					Game.setPlayer(newPlayer);
					
					Universe universe = new Universe(screen);
					acc.setUniverse(universe);
					Game.setUniverse(universe);

					screen.setScene(Game.getUniverse());
				}
			}
		});
	} 

	private class StatListener implements ActionListener {
		int stat;
		int delta;

		public StatListener(int stat, int delta) {
			this.stat = stat;
			this.delta = delta;
		}

		public void actionPerformed(ActionEvent e) {
			if(stat == 1) { //fight, might change these to enums
				if(0 <= (fight + delta) && (fight + delta) <= 16 && 0 <= (stats + delta*-1)) {
					fight += delta;
					stats += (delta*-1);
					fightLabel.setText("Fighter: " + fight);
					statsLabel.setText("Skill points: " + stats);
				}
			}
			else if(stat == 2) { //trade
				if(0 <= (trade + delta) && (trade + delta) <= 16 && 0 <= (stats + delta*-1)) {
					trade += delta;
					stats += (delta*-1);
					tradeLabel.setText("Trader: " + trade);
					statsLabel.setText("Skill points: " + stats);
				}
			}
			else if(stat == 3) { //engineer
				if(0 <= (engin + delta) && (engin + delta) <= 16 && 0 <= (stats + delta*-1)) {
					engin += delta;
					stats += (delta*-1);
					enginLabel.setText("Engineer: " + engin);
					statsLabel.setText("Skill points: " + stats);
				}
			}
			else if(stat == 4) { //pilot
				if(0 <= (pilot + delta) && (pilot + delta) <= 16 && 0 <= (stats + delta*-1)) {
					pilot += delta;
					stats += (delta*-1);
					pilotLabel.setText("Pilot: " + pilot);
					statsLabel.setText("Skill points: " + stats);
				}
			}
		}

	}

	@Override
	public void paint(JPanel p, Graphics g) {
		p.removeAll();
		
		p.add(playerNameLabel);
		p.add(playerNameText);

		p.add(statsLabel);

		p.add(fightLabel);
		p.add(fightPlus);
		p.add(fightMinus);

		p.add(tradeLabel);
		p.add(tradePlus);
		p.add(tradeMinus);

		p.add(enginLabel);
		p.add(enginPlus);
		p.add(enginMinus);

		p.add(pilotLabel);
		p.add(pilotPlus);
		p.add(pilotMinus);

		p.add(create);
		p.add(output);
		
		p.revalidate();
		
	}

}
