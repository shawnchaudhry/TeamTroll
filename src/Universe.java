import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Scene to let the user travel to the universe.
 * 
 * @author TeamTroll
 * @version 1.0
 */
public class Universe implements Scene, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon background, shipIcon;
	private Planet[] planets;
	private int numPlanets = 13;
	private GameScreen screen;
	private JTextField currentPlanetText, destPlanetText, fuelText;
	private JButton landButton, travelButton;
	private Planet destPlanet;
	private Random rand;
	private String[] namesArr = { "Acamar", "Adahn", "Aldea", "Andevian",
			"Antedi", "Balosnee", "Baratas", "Brax", "Bretel", "Calondia",
			"Campor", "Capelle", "Carzon", "Castor", "Cestus", "Cheron",
			"Courteney", "Daled", "Damast", "Davlos", "Deneb", "Deneva",
			"Devidia", "Draylon", "Drema", "Endor", "Esmee", "Exo", "Ferris",
			"Festen", "Fourmi", "Frolix", "Gemulon", "Guinifer", "Hades",
			"Hamlet", "Helena", "Hulst", "Iodine", "Iralius", "Janus",
			"Japori", "Jarada", "Jason", "Kaylon", "Khefka", "Kira", "Klaatu",
			"Klaestron", "Korma", "Kravat", "Krios", "Laertes", "Largo",
			"Lave", "Ligon", "Lowry", "Magrat", "Malcoria", "Melina", "Mentar",
			"Merik", "Mintaka", "Montor", "Mordan", "Orias", "Othello",
			"Parade", "Penthara", "Picard", "Pollux", "Quator", "Rakhar",
			"Ran", "Regulas", "Relva", "Rhymus", "Rochani", "Rubicum",
			"Myrthe", "Nelvana", "Nix", "Nyle", "Odet", "Og", "Omega",
			"Omphalos", "Rutia", "Sarpeidon", "Sefalla", "Seltrice", "Sigma",
			"Sol", "Somari", "Stakoron", "Styris", "Talani", "Tamus",
			"Tantalos", "Tanuga", "Tarchannen", "Terosa", "Thera", "Titan",
			"Torin", "Triacus", "Turkana", "Tyrus", "Umberlee", "Utopia",
			"Vadera", "Vagra", "Vandor", "Ventax", "Xenon", "Xerxes", "Yew",
			"Yojimbo", "Zalkon", "Zuul" };

	private String[] shipArr = { "img/spaceship1.png" };

	private Point[] loc = { new Point(25, 135), new Point(155, 165),
			new Point(275, 115), new Point(400, 125), new Point(120, 270),
			new Point(355, 240), new Point(110, 410), new Point(240, 340),
			new Point(320, 410), new Point(410, 440), new Point(40, 510),
			new Point(370, 540), new Point(260, 560) };

	private String[] tech = { "Pre-Agriculture", "Medieval", "Renaissance",
			"Early Industrial", "Industrial", "Post-Industrial", "Hi-Tech" };

	private String[] res = { "NOSPECIALRESOURCES", "MINERALRICH",
			"MINERALPOOR", "DESERT", "LOTSOFWATER", "RICHSOIL", "POORSOIL",
			"RICHFAUNA", "LIFELESS", "WEIRDMUSHROOMS", " LOTSOFHERBS",
			" ARTISTIC", " WARLIKE", "NOSPECIALRESOURCES",
			"NOSPECIALRESOURCES", "NOSPECIALRESOURCES" };

	private String[] pol = { "Anarchy", "Capitalist State", "Communist State",
			"Confederacy", "Corporate State", "Cybernetic State", "Democracy",
			"Dictatorship", "Fascist State", "Feudal State", "Military State",
			"Monarchy", "Pacifist State", "Socialist State", "State of Satori" };

	private String[] filenames = { "img/planet0.png", "img/planet1.png",
			"img/planet2.png", "img/planet3.png", "img/planet4.png",
			"img/planet5.png", "img/planet6.png", "img/planet7.png",
			"img/planet8.png", "img/planet9.png", "img/planet10.png",
			"img/planet11.png", "img/planet12.png", "img/planet13.png",
			"img/planet14.png", "img/planet15.png", "img/planet16.png",
			"img/planet17.png", "img/planet18.png", "img/planet19.png",
			"img/planet20.png", "img/planet21.png", "img/planet22.png",
			"img/planet23.png", "img/planet24.png", "img/planet25.png",
			"img/planet26.png", "img/planet27.png", "img/planet28.png",
			"img/planet29.png", "img/planet30.png", "img/planet31.png",
			"img/planet32.png", "img/planet33.png", "img/planet34.png",
			"img/planet35.png", "img/planet36.png", "img/planet37.png",
			"img/planet38.png", "img/planet39.png", "img/planet40.png",
			"img/planet41.png", "img/planet42.png", "img/planet43.png",
			"img/planet44.png", "img/planet45.png", "img/planet46.png",
			"img/planet47.png", "img/planet48.png", "img/planet49.png",
			"img/planet50.png", "img/planet51.png", "img/planet52.png",
			"img/planet53.png", "img/planet54.png", "img/planet55.png",
			"img/planet56.png", "img/planet57.png", "img/planet58.png",
			"img/planet59.png", "img/planet60.png", "img/planet61.png",
			"img/planet62.png", "img/planet63.png" };

	/**
	 * Creates the universe.
	 * 
	 * @param GameScreen
	 *            screen The screen of the game.
	 */
	public Universe(final GameScreen screen) {
		this.screen = screen;
		rand = new Random();
		final Ship ship = screen.game.getPlayer().getShip();

		background = new ImageIcon("img/spacebackground.png");
		int nameLength = namesArr.length, fileLength = filenames.length, nameNum, fileNum;

		shipIcon = new ImageIcon(shipArr[0]);

		planets = new Planet[numPlanets];
		numPlanets=numPlanets-1;

		for (int size = numPlanets; 0 <= size; size--) {
			nameNum = rand.nextInt(nameLength);
			fileNum = rand.nextInt(fileLength);

			planets[size] = new Planet(screen, namesArr[nameNum], loc[size],
					tech[rand.nextInt(tech.length)],
					res[rand.nextInt(res.length)],
					pol[rand.nextInt(pol.length)], filenames[fileNum]);
			nameLength=nameLength-1;
			fileLength=fileLength-1;
			namesArr[nameNum] = namesArr[nameLength];
			filenames[fileNum] = filenames[fileLength];
		}

		// set to screen.game.setPlanet(planet)
		// and screen.game.setUniverse(this).
		final Planet planet = planets[rand.nextInt(13)];
		screen.game.setPlanet(planet);
		screen.game.setUniverse(this);

		// Changed to screen.game.getPlayer();
		currentPlanetText = new JTextField("Current Planet: "
				+ planet.getName(), 25);
		destPlanetText = new JTextField("Destination Planet: "
				+ planet.getName(), 25);
		fuelText = new JTextField("Fuel Cost: 0", 15);

		landButton = new JButton("Land");
		travelButton = new JButton("Travel");
		travelButton.setEnabled(false);

		landButton.addActionListener(new ActionListener() {
			/**
			 * Lands on the planet and goes to the planet scene.
			 * 
			 * @param ActionEvent
			 *            e The created action event.
			 */
			public void actionPerformed(ActionEvent e) {
				
				if(!planet.getSpecialEvent().equals("ALLGOOD"))
					JOptionPane.showMessageDialog(screen, "This Planet suffers from " + planet.getSpecialEvent(),
						    "Special Event", JOptionPane.WARNING_MESSAGE);
				
				screen.setScene(planet);
			}
		});

		travelButton.addActionListener(new ActionListener() {
			/**
			 * Travels to the selected planet and sets the planet scene.
			 * 
			 * @param ActionEvent
			 *            e The created action event.
			 */
			public void actionPerformed(ActionEvent e) {
				Planet planet = screen.game.getPlanet();
				int cost = calcFuel(planet.getLoc(), destPlanet.getLoc());
				if (rand.nextInt(5) == 0) {
					new RandomEvents(screen.game.getPlayer());
				}
				if (destPlanet != null && cost <= ship.getFuel()) {
					ship.decreaseFuel(cost);
					screen.game.setPlanet(destPlanet);
					refresh();
				} else
					fuelText.setText("Not enough Fuel");
			}
		});
	}

	/**
	 * Paints the components onto the screen.
	 * 
	 * @param JPanel
	 *            p The panel to contain the components.
	 * @param Graphics
	 *            g The graphics to the corresponding page.
	 */
	public void paint(JPanel p, Graphics g) {
		final Planet planet = screen.game.getPlanet();
		
		p.removeAll();

		background.paintIcon(null, g, 0, 0);

		for (Planet pl : planets)
			pl.draw(p, g);

		Point currLoc = planet.getLoc();
		shipIcon.paintIcon(null, g, currLoc.x, currLoc.y);

		p.add(currentPlanetText);
		p.add(landButton);
		p.add(destPlanetText);
		p.add(travelButton);
		p.add(fuelText);

		p.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				for (Planet p : planets)
					if (p.getRect().contains(e.getPoint())) {
						travelButton.setEnabled(true);
						destPlanet = p;
						destPlanetText.setText("Destination Planet: " + p.getName());
						calcFuel(planet.getLoc(), destPlanet.getLoc());
					}
			}
		});

		p.revalidate();

	}

	/**
	 * Refreshes the view of the current planet.
	 */
	public void refresh() {
		screen.setScene(this);
		// Changed to screen.game.setPlanet(planet);
		currentPlanetText.setText("Current Planet: " + screen.game.getPlanet().getName());
		fuelText.setText("Fuel: " + screen.game.getPlayer().getShip().getFuel() + " Fuel Cost: " + 0);
	}

	/**
	 * Returns the array of planets.
	 * 
	 * @return Planet[] The array of planets.
	 */
	public Planet[] getPlanets() {
		return planets;
	}

	/**
	 * Calculates the cost of traveling from two points.
	 * 
	 * @param Point
	 *            curr The point of current location.
	 * @param Point
	 *            dest The point of destination location.
	 * 
	 * @return int The amount of fuel it costs to travel the distance.
	 */
	public int calcFuel(Point curr, Point dest) {
		int fuel = (int) Math.sqrt(Math.pow((curr.x - dest.x), 2)
				+ Math.pow((curr.y - dest.y), 2));

		fuel = (35 + rand.nextInt(30)) % 65;

		fuelText.setText("Fuel: " + screen.game.getPlayer().getShip().getFuel() + " Fuel Cost: "
				+ fuel);

		return fuel;
	}
	
	public String toString(){
		return super.toString();
	}
}