import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Market implements Scene {
	private GameScreen screen;
	private Planet planet;
	private Player player;
	private JButton planetButton, confirm;
	private JLabel outputLabel, inventoryLabel1, inventoryLabel2, moneyLabel;
	private int level, money; 
	private Good[] buyGoods, sellGoods; 
	private Hashtable<String, Integer> inventory;
	private Transaction trans;
	private JRadioButton buyRadio, sellRadio;
	private ButtonGroup buttonGroup;

	public Market(final GameScreen screen, Planet planet) {
		this.screen = screen;
		this.planet = planet;
		this.player = Game.getPlayer();
		inventory = player.getInventory();
		trans = new Transaction(player, this);
		
		buyRadio = new JRadioButton("Buy", true);
		sellRadio = new JRadioButton("Sell", false);
		
		buyRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		
		sellRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(buyRadio);
		buttonGroup.add(sellRadio);

		planetButton = new JButton("Planet");
		planetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setScene(Game.getPlanet());
			}
		});

		confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trans = trans.confirm();
				refresh();
			}
		});
		
		level = planet.getTechLevel();
		money = player.getMoney();

		outputLabel = new JLabel("      Market Place (" + planet.getName() + ", Level " + level + ")         ");
		moneyLabel = new JLabel("Total Money: $" + money + "      Cargo Space: " + (player.getCargoBay() 
				- player.numItems()) + "     ");
		inventoryLabel1 = new JLabel(player.getInventory1());
		inventoryLabel2 = new JLabel(player.getInventory2());

		buyGoods = generateBuyMarket(); 
		sellGoods = generateSellMarket();
	}

	public void paint(JPanel p, Graphics g) {
		p.removeAll();

		p.add(outputLabel);
		p.add(planetButton);
		p.add(inventoryLabel1);
		p.add(inventoryLabel2);
		p.add(moneyLabel);
		p.add(buyRadio);
		p.add(sellRadio);
		
		for(Good good : buyGoods)
			p.add(good);

		p.add(trans);
		p.add(confirm);

		p.revalidate();
	}
	
	private void refresh() {
		inventoryLabel1.setText(player.getInventory1());
		inventoryLabel2.setText(player.getInventory2());
		moneyLabel = new JLabel("Total Money: $" + money + "      Cargo Space: " + (player.getCargoBay() 
				- player.numItems()) + "     ");
		
		for(Good g : buyGoods) {
			g.reset(trans);
		}

		screen.setScene(this);
	}

	public Good[] generateBuyMarket() {
		Good[] buyGoods = new Good[10];

		//fix this
		buyGoods[0] = new Good(planet, this, trans, "Water", 0, 0, 2, 30, 3, 4, 30, 50);
		buyGoods[1] = new Good(planet, this, trans, "Furs", 0, 0, 0, 250, 10, 10, 230, 280);
		buyGoods[2] = new Good(planet, this, trans, "Food", 1, 0, 1, 100, 5, 5, 90, 160);
		buyGoods[3] = new Good(planet, this, trans, "Ore", 2, 2, 3, 350, 20, 10, 350, 420);
		buyGoods[4] = new Good(planet, this, trans, "Games", 3, 1, 6, 250, -10, 5, 160, 270);
		buyGoods[5] = new Good(planet, this, trans, "Firearms", 3, 1, 5, 1250, -75, 100, 600, 1100);
		buyGoods[6] = new Good(planet, this, trans, "Medicine", 4, 1, 6, 650, -20, 10, 400, 700);
		buyGoods[7] = new Good(planet, this, trans, "Machines", 4, 3, 5, 900, -30, 5, 600, 800);
		buyGoods[8] = new Good(planet, this, trans, "Narcotics", 5, 0, 5, 3500, -125, 150, 2000, 3000);
		buyGoods[9] = new Good(planet, this, trans, "Robots", 6, 4, 7, 5000, -150, 100, 3500, 5000);

		if(level < 6)
			buyGoods[9].disable();
		if(level < 5)
			buyGoods[8].disable();
		if(level < 4) {
			buyGoods[7].disable();
			buyGoods[6].disable();
		}
		if(level < 3) {
			buyGoods[5].disable();
			buyGoods[4].disable();
		}	
		if(level < 2)
			buyGoods[3].disable();
		if(level < 1)
			buyGoods[2].disable();

		return buyGoods;
	}

	public Good[] generateSellMarket() {
		Good[] sellGoods = new Good[10];

		sellGoods[0] = new Good(planet, this, trans, "Water", 0, 0, 2, 30, 3, 4, 30, 50);
		sellGoods[1] = new Good(planet, this, trans, "Furs", 0, 0, 0, 250, 10, 10, 230, 280);
		sellGoods[2] = new Good(planet, this, trans, "Food", 1, 0, 1, 100, 5, 5, 90, 160);
		sellGoods[3] = new Good(planet, this, trans, "Ore", 2, 2, 3, 350, 20, 10, 350, 420);
		sellGoods[4] = new Good(planet, this, trans, "Games", 3, 1, 6, 250, -10, 5, 160, 270);
		sellGoods[5] = new Good(planet, this, trans, "Firearms", 3, 1, 5, 1250, -75, 100, 600, 1100);
		sellGoods[6] = new Good(planet, this, trans, "Medicine", 4, 1, 6, 650, -20, 10, 400, 700);
		sellGoods[7] = new Good(planet, this, trans, "Machines", 4, 3, 5, 900, -30, 5, 600, 800);
		sellGoods[8] = new Good(planet, this, trans, "Narcotics", 5, 0, 5, 3500, -125, 150, 2000, 3000);
		sellGoods[9] = new Good(planet, this, trans, "Robots", 6, 4, 7, 5000, -150, 100, 3500, 5000);

		if(level < 4)
			sellGoods[9].disable();
		if(level < 3) 
			sellGoods[7].disable();
		if(level < 2)
			sellGoods[3].disable();
		if(level < 1) {
			sellGoods[6].disable();
			sellGoods[5].disable();
			sellGoods[4].disable();
		}

		return sellGoods;
	}
	
	public boolean buy() {
		return buyRadio.isSelected();
	}
}
