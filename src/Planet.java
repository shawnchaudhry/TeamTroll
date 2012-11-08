import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Represents a planet in the game.
 * 
 * @author TeamTroll
 * @version 2.0
 */

public class Planet implements Scene {
	private GameScreen screen;
	private String name, tech, res, pol;
	private ImageIcon img;
	private Point loc;
	
	private JLabel planetNameLabel, planetTechLabel,planetResLabel,planetPolLabel;
	private JButton marketButton, universeButton;
	private Market market;
	private Rectangle planetRect;

	/**
	 * Planet constructor.
	 *
	 * @param String name The planet's name
	 * @param int x The planet's x-coordinate
	 * @param int y The planet's y-coordinate
	 */
	public Planet(final GameScreen screen, String name, Point loc, String tech, String res, String pol, String filename) {
		this.screen = screen;
		this.name = name;
		this.loc = loc;
		this.tech = tech;
		this.res = res;
		this.pol = pol;
		img = new ImageIcon(filename);
		
		market = new Market(screen, this);
		planetRect = new Rectangle(loc, new Dimension(img.getIconWidth(),img.getIconHeight()));
		planetNameLabel = new JLabel("Planet Name: " + name,JLabel.CENTER);
		planetTechLabel = new JLabel("Planet Tech Level: " + tech,JLabel.CENTER);
		planetResLabel = new JLabel("Planet Resourses: " + res,JLabel.CENTER);
		planetPolLabel = new JLabel("Planet Politics: " + pol,JLabel.CENTER);
		
		planetNameLabel.setPreferredSize(new Dimension(518,50));
		planetTechLabel.setPreferredSize(new Dimension(518,50));
		planetResLabel.setPreferredSize(new Dimension(518,50));
		planetPolLabel.setPreferredSize(new Dimension(518,50));
		
		marketButton = new JButton("Market");
		universeButton = new JButton("Universe");

		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setScene(market);
			}
		});

		universeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setScene(Game.getUniverse());
			}
		});
		
	}

	public void draw(JPanel p, Graphics g) {
		img.paintIcon(null, g, loc.x, loc.y);
	}

	public void paint(JPanel p, Graphics g) {
		p.removeAll();

		p.add(planetNameLabel);
		p.add(planetTechLabel);
		p.add(planetResLabel);
		p.add(planetPolLabel);
		p.add(marketButton);
		p.add(universeButton);

		p.revalidate();
	}

	public String getName() {
		return name;
	}

	public Point getLoc() {
		return loc;
	}

	public String getTech() {
		return tech;
	}
	public int getTechLevel() {
		int level = 0;
		
		if(tech.equals("Pre-Agriculture"))
			level = 0;
		else if(tech.equals("Medieval"))
			level = 1;
		else if(tech.equals("Renaissance"))
			level = 2;
		else if(tech.equals("Early Industrial"))
			level = 3;
		else if(tech.equals("Industrial"))
			level = 4;
		else if(tech.equals("Post-Industrial"))
			level = 5;
		else if(tech.equals("Hi-Tech"))
			level = 6;

		return level;
	}

	public String getRes() {
		return res;
	}

	public String getPol() {
		return pol;
	}
	
	public ImageIcon getImg() {
		return img;
	}
	public Rectangle getRect(){
		return planetRect;
	}
}