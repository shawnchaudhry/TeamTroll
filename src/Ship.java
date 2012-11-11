import java.io.Serializable;

/**
 * Represents a ship.
 *
 * @author TeamTroll
 * @version 1.0
 */
public class Ship implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fuel, cargoBay;
    private String type;
     
    /** 
     * Creates the ship.
     *
     * @param String type The type of the ship.
     */
    public Ship(String type) {
        this.type = type;
        fuel = 200;
        cargoBay = 100;
    }
     
    /** 
     * Decreases the amount of fuel the ship has. Used in conjunction with
     * the travel button.
     *
     * @param int cost The amount of fuel needed to travel to the planet.
     */
    public void decreaseFuel(int cost) {
        fuel -= cost;
    }
 
    /**
     * Getter for the current amount of fuel in the ship.
     * 
     * @return int The amount of fuel in the ship.
     */
    public int getFuel() {
        return fuel;
    }
 
    /**
     * Setter for the size of the cargo bay.
     *
     * @param int cargoBay The new size of the cargo bay.
     */
    public void setCargoBay(int cargoBay) {
        this.cargoBay = cargoBay;
    }
 
    /**
     * Getter for the size of the cargo bay.
     *
     * @return int The size of the cargo bay. 
     */
    public int getCargoBay() {
        return cargoBay;
    }
}