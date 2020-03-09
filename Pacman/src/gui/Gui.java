package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;
import gui.MyJComponent;
import pacman.PacmanObserver;

/**ObserverConcret**/
public class Gui extends JPanel implements PacmanObserver {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Game game;
	private String txtOnOff = "Off";

	public Gui(Game game, int tileHeight, int tileWidth) {
		this.game = game;
		frame = new JFrame("Pacman");
		frame.setLayout(new BorderLayout());
		JComponent component = new MyJComponent(game, tileHeight, tileWidth);
		frame.setContentPane(component);
		frame.setSize(17 * 20, 27 * 20);
		 frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.black);
		frame.setVisible(true);
		frame.addKeyListener(new MyKeyListner(game, this));
		game.getPacman().register(this);
	}

	/**redéfinit la methode update de l'interface Observer**/
	@Override
	public void update() {
		// System.out.println("B : Update the Laby");
		frame.repaint();
	}

	public String getTxtOnOff() {
		return txtOnOff;
	}

	public void setTxtOnOff(String txtOnOff) {
		this.txtOnOff = txtOnOff;
	}

	public Game getGame() {
		return game;
	}


}
