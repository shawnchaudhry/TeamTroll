import java.util.*;

/**
 * Represents a planet in the game.
 * 
 * @author TeamTroll
 * @version 1.0
 */

public class Planet {
	private String name;
	private int x, y, technology, resources;
	private Random rand = new Random();

	/**
	 * Planet constructor.
	 *
	 * @param String name The planet's name
	 * @param int x The planet's x-coordinate
	 * @param int y The planet's y-coordinate
	 */
	public Planet(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;

		technology = rand.nextInt(8);
		resources = rand.nextInt(15);

		if(12 < resources)
			resources = 0;
	}
}