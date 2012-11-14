import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class UniverseTest {

	public Driver driver;

	@Before
	public void setUp() throws Exception {
		this.driver = new Driver();
		driver.run();
	}

	@Test
	public void testCalcFuel() {
		Planet[] planets = driver.gameScreen.game.getUniverse().getPlanets();
		System.out.println(planets.length);
		for (int i = 0; i < planets.length; i++) {
			assertEquals(
					driver.gameScreen.game
							.getUniverse()
							.calcFuel(
									driver.gameScreen.game.getPlanet().getLoc(),
									planets[i].getLoc()),
					driver.gameScreen.game
							.getUniverse()
							.calcFuel(
									planets[i].getLoc(),
									driver.gameScreen.game.getPlanet().getLoc()));
		}
	}
}
