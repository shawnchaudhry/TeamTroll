import java.util.Random;


public class RandomEvents {
	Random rand;
	public RandomEvents()
	{
		rand = new Random();
		if (rand.nextInt(2) > 0)
		{
			piratesEncounter();
		}
		else
		{
			policeEncounter();
		}
	}
	
	private void policeEncounter() {
		int policeStrength = rand.nextInt(17);
		
	}
	
	private void piratesEncounter() {
		int pirateStrength = rand.nextInt(17);
		
	}
	
}
