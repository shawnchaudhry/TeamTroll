import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
// So this is my Driver class, I found it was just easier to make everything into one class and not have to deal with
// it in main. If I put it in main, it would always turn out to be static somehow so I just decided to put it in here.

public class Driver {
	JFrame frame;
	GameScreen gameScreen;
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newGame;
	JMenuItem loadGame;
	JMenuItem saveGame;
	JFileChooser fc;

	public Driver() {

		// Create the menu bar, menu, and items.
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		newGame = new JMenuItem("New Game");
		loadGame = new JMenuItem("Load Game");
		saveGame = new JMenuItem("Save Game");

		// Create the file chooser.
		fc = new JFileChooser();

		// Add items into the Menu Bar.
		menuBar.add(fileMenu);
		fileMenu.add(newGame);
		fileMenu.add(loadGame);
		fileMenu.add(saveGame);
		frame = new JFrame("SPACE TRADER");

		// Load the initial game
		gameScreen = new GameScreen();

		// This ActionListener will create a new GameScreen (which will then
		// start a new game).
		// I dispose of the old frame and create a new frame. It was the only
		// way I could get it to
		// refresh properly. Maybe you could think of something better. Let me
		// know!
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameScreen = new GameScreen();
				frame.dispose();
				frame = new JFrame("SPACE TRADER");
				run();
			}
		});

		// This ActionListener will set up the game to be saved. To save the
		// game, I had to serialize Game, Market, Planet, Player, Ship,
		// Universe, and UserAccount.
		saveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final int returnVal = fc.showSaveDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						final File file = fc.getSelectedFile();
						final ObjectOutputStream outputFile = new ObjectOutputStream(
								new FileOutputStream(file));
						outputFile.writeObject(gameScreen.game);
						outputFile.close();
						JOptionPane.showMessageDialog(frame, "Game Saved.");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Game not Saved.");
				}
			}
		});

		// This ActionListener will load a game. The way it does this is by
		// first
		// reading the savedGame file, secondly setting the gameScreen object =
		// to
		// the gameScreenObject that was stored in the game object, and thirdly
		// will dispose of the frame and create a new frame running the run()
		// method.
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final int returnVal = fc.showOpenDialog(frame);
				final File file = fc.getSelectedFile();
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					try {
						final ObjectInputStream inputFile = new ObjectInputStream(
								new FileInputStream(file));
						gameScreen.game = (Game) inputFile.readObject();
						gameScreen = gameScreen.game.getScreen();
						frame.dispose();
						frame = new JFrame("SPACE TRADER");
						run();
						inputFile.close();
					} catch (IOException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					JOptionPane
							.showMessageDialog(frame, "Did not load a game.");
				}
			}
		});
	}

	// This run method will set the gameScreen, menuBar.. basically everything
	// that main used to do.
	public void run() {
		frame.add(gameScreen);
		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
}
