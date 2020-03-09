package fantome;

import java.awt.Color;

import game.Game;
import utils.Coordinate;

// cette classe et l'etat vulnérable du fantome lorsque le pacman et superpacman

public class FantomeVulnérable extends Fantome {

	// ce timer qui rends le move du fantome lent 
	private int timer;

	public FantomeVulnérable(Coordinate coordinate, Game game,int timerOut) {
		super(coordinate, game,timerOut);
		this.setTimer(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.BLUE;
	}

	
	@Override
	public void move() {
		if (this.timer > 0) {
			timer--;
		} else if (timer == 0) {
			// System.out.println("move vulnerable :");
			super.move();
			this.setTimer(1);
		}

	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

}
