import java.util.*;

public class Player {
	private String name, inventoryString;
	private int fight, trade, engin, pilot, money, cargoBay;
	private Hashtable<String, Integer> inventory;
	private Ship ship;

	public Player(String name, int fight, int trade, int engin, int pilot) {
		this.name = name;
		this.setFight(fight);
		this.setTrade(trade);
		this.setEngin(engin);
		this.setPilot(pilot);

		ship = new Ship("Gnat");

		inventory = new Hashtable<String, Integer>();
		inventory.put("Water", 0);
		inventory.put("Furs", 0);
		inventory.put("Food", 0);
		inventory.put("Ore", 0);
		inventory.put("Games", 0);
		inventory.put("Firearms", 0);
		inventory.put("Medicine", 0);
		inventory.put("Machines", 0);
		inventory.put("Narcotics", 0);
		inventory.put("Robots", 0);

		cargoBay = 100;
		money = 10000;

		System.out.println("player created!");
	}
	
	public String getName() {
		return name;
	}

	public int getFight() {
		return fight;
	}

	public void setFight(int fight) {
		this.fight = fight;
	}
	
	public int getTrade() {
		return trade;
	}

	public void setTrade(int trade) {
		this.trade = trade;
	}

	public int getEngin() {
		return engin;
	}

	public void setEngin(int engin) {
		this.engin = engin;
	}

	public int getPilot() {
		return pilot;
	}

	public void setPilot(int pilot) {
		this.pilot = pilot;
	}

	public void setInventory(Hashtable<String, Integer> inventory) {
		this.inventory = inventory;
	}

	public Hashtable<String, Integer> getInventory() {
		return inventory;
	}

	private void generateInventoryString() {
		String inventoryString = "| ";

		for(String itemName : inventory.keySet())
			inventoryString += itemName + ": " + inventory.get(itemName) + " | ";
		
		this.inventoryString = inventoryString;
	}

	public String getInventory1() {
		generateInventoryString();
		int split = inventoryString.indexOf("Furs");
		return inventoryString.substring(0, split);
	}

	public String getInventory2() {
		generateInventoryString();
		int split = inventoryString.indexOf("Furs");
		return "| " + inventoryString.substring(split, inventoryString.length());
	}

	public void setCargoBay(int cargoBay) {
		this.cargoBay = cargoBay;
	}

	public int getCargoBay() {
		return cargoBay;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public Ship getShip() {
		return ship;
	}
	
	public Integer numItems() {
		Integer total = 0;
		
		for(Integer i : inventory.values()) {
			total += i;
		}
		
		return total;
	}
	
}
