public class Ship {
	private int gas;
	private String type;
	
	public Ship(String type) {
		this.type = type;
		gas = 100;
	}
	
	public void decreaseGas(int cost) {
		gas -= cost;
	}

	public int getGas() {
		return gas;
	}
}
