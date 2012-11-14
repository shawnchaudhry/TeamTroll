import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

public class RandomEvents {
	Random rand;
	Player player;

	public RandomEvents(Player player) {
		rand = new Random();
		this.player = player;
		if (rand.nextInt(2) > 0) {
			piratesEncounter();
		} else {
			policeEncounter();
		}
	}

	private void policeEncounter() {
		final int policeStrength = rand.nextInt(17);
		if (player.getPilot() > policeStrength) {
			JOptionPane.showMessageDialog(null,
					"Congratulations, you have outran the police!");
		} else if (player.getPilot() == policeStrength) {
			JOptionPane.showMessageDialog(null, "The police let you go.");
		} else {
			if (player.getMoney() > 0) {
				final int fine = rand.nextInt(player.getMoney());
				JOptionPane.showMessageDialog(null,
						"The police caught you and fined you: $" + fine);
				player.setMoney(player.getMoney() - fine);
			} else {
				// Dont know if this is the best idea because how often will the
				// player have exactly $0?
				final Iterator<String> it = player.getInventory().keySet().iterator();
				JOptionPane
						.showMessageDialog(null,
								"The police caught you, and since you're broke they took some cargo");
				while (it.hasNext()) {
					String item = it.next();
					boolean remove = rand.nextBoolean();
					if (remove) {
						int amount = rand.nextInt(101);
						if (player.getInventory().get(item) <= amount) {
							player.getInventory().put(item, 0);
						} else {
							player.getInventory().put(item,
									player.getInventory().get(item) - amount);
						}
					}
				}
			}
		}
	}

	private void piratesEncounter() {
		final int pirateStrength = rand.nextInt(17);
		if (player.getFight() > pirateStrength) {
			JOptionPane.showMessageDialog(null,
					"Congratulations, you have defeated the pirates!");
		} else if (player.getFight() == pirateStrength) {
			JOptionPane.showMessageDialog(null,
					"You make it away from the pirates unharmed.");
		} else {
			final Iterator<String> it = player.getInventory().keySet().iterator();
			JOptionPane
					.showMessageDialog(null,
							"The pirates defeated you and are now taking whatever they like!");
			while (it.hasNext()) {
				String item = it.next();
				boolean remove = rand.nextBoolean();
				if (remove) {
					int amount = rand.nextInt(101);
					if (player.getInventory().get(item) <= amount) {
						player.getInventory().put(item, 0);
					} else {
						player.getInventory().put(item,
								player.getInventory().get(item) - amount);
					}
				}
			}
		}
	}

}
