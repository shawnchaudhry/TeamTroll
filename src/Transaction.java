import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Transaction extends JPanel {
	private JLabel transLabel;
	private Player player;
	private Market market;
	private int balance, change;
	private Hashtable<String, Integer> trans;

	@SuppressWarnings("unchecked")
	public Transaction(Player player, Market market) {
		this.player = player;
		this.market = market;
		balance = player.getMoney();
		trans = new Hashtable<String, Integer>();
		
		for(String good : player.getInventory().keySet())
			trans.put(good, 0);

		transLabel = new JLabel("Transaction: $" + balance + " + (" + change + ") = $" 
				+ getNewBalance() + "      Cargo Space Remaining: " + (player.getCargoBay() - numItems()));
		add(transLabel);
	}

	public int add(String good, int price) {
		if(market.buy() && 0 < balance + change - price && numItems() <= player.getCargoBay()) {
			trans.put(good, trans.get(good) + 1);
			change -= price;
			System.out.println("add called, change: " + change);
		}
		else if(!market.buy() && trans.get(good) < player.getInventory().get(good)) {
			trans.put(good, trans.get(good) - 1);
			change += price;
		}

		refresh();

		return trans.get(good);
	}

	public int remove(String good, int price) {
		if(market.buy() && 0 < trans.get(good)) {
			trans.put(good, trans.get(good) - 1);
			change += price;
		}
		else if(!market.buy() && 0 < trans.get(good)) {
			trans.put(good, trans.get(good) + 1);
			change -= price;
		}

		refresh();

		return trans.get(good);
	}
	
	private Integer numItems() {
		Integer total = 0;
		
		for(Integer i : trans.values()) {
			total += i;
		}
		
		return total;
	}

	private int getNewBalance() {
		return balance + change;
	}

	private void refresh() {
		transLabel.setText("Transaction: $" + balance + " + (" + change + ") = $" + getNewBalance() 
				+ "      Cargo Space Remaining: " + (player.getCargoBay() - player.numItems() - numItems()));
		
		System.out.println("Refresh called");
	}

	public Transaction confirm() {
		Hashtable<String, Integer> playerInventory = player.getInventory();
		
		for(String good : trans.keySet())
			playerInventory.put(good, playerInventory.get(good) + trans.get(good));
	
		Game.getPlayer().setInventory(playerInventory);
		balance = getNewBalance();
		player.setMoney(balance);
		change = 0;
		
		trans = new Hashtable<String, Integer>();
		
		for(String good : player.getInventory().keySet())
			trans.put(good, 0);
		
		refresh();
		
		return this;
	}
}
