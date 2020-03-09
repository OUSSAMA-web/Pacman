package fantome;

import java.awt.Color;

import game.Game;
import utils.Coordinate;

// cette classe et défini l'etat normale du fantome 
public class FantomeClassique extends Fantome{

	public FantomeClassique(Coordinate coordinate,Game game,int timerOut) {
		super(coordinate,game,timerOut);
	}

	@Override
	public Color getColor() {
		return Color.green;
	}

	@Override
	public void move() {
		super.move();
		
	}

}
