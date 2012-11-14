import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test
 * @author Aditya
 *
 */
public class LogInTest {

	LogIn log;
	@Before
	public void setUp() {
		 log = new LogIn(new GameScreen());
		Game game;
		Driver driver = new Driver();
		driver.run();
		game = driver.gameScreen.game;
		game.setUserAccount(new UserAccount("test", "test1"));
		
	}
	
	
	@Test
	public void testLoginHelper() {
		log.setFields("","");
		boolean test=log.login();
		assertFalse(test);
	}
	
	@Test
	public void testLoginHelper_1() {
		log.setFields("test","test1");
		assertFalse(log.login());
	}
	
	@Test
	public void testLoginHelper_2() {
		log.setFields("hello","test1");
		assertFalse(log.login());
	}
	
	@Test
	public void testLoginHelper_3() {
		log.setFields("test","tes");
		assertFalse(log.login());
	}

}
