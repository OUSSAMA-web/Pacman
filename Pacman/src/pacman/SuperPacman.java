package pacman;

import java.awt.Color;

import game.Game;

/** Pacman State = Super Pacman **/
public class SuperPacman extends PacmanNormal {

	public SuperPacman(Game game) {
		super(game);
	}

	@Override
	public Color pacmanColor() {
		return Color.orange;
	}
	
	@Override
	public boolean isSuperpacman() {
		return true;
	}
	
	@Override
	public void isAlive(PacmanContext pacman) {
		// System.out.println("vie est :" +PacmanContext.getLive());
	}
}
