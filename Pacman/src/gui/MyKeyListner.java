package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Game;
import pacman.PacmanContext;
import utils.Direction;

public class MyKeyListner extends KeyAdapter {
	private Game game;
	private Gui gui;

	public MyKeyListner(Game game, Gui gui) {
		this.game = game;
		this.gui = gui;

	}

	@Override
	public void keyPressed(KeyEvent k) {
		PacmanContext pacman = game.getPacman();
		switch (k.getKeyCode()) {
			case (KeyEvent.VK_LEFT):
				if(!pacman.hasObstacleLeft()) {//left of pacman
					pacman.setDirection(Direction.Left);
				}
				break;
	
			case (KeyEvent.VK_RIGHT):
				if(!pacman.hasObstacleRight()) {//right of pacman
					pacman.setDirection(Direction.Right);
				}
				break;
	
			case (KeyEvent.VK_UP):
				if(!pacman.hasObstacleUp()) {//above pacman
					pacman.setDirection(Direction.Up);
				}					
				break;
	
			case (KeyEvent.VK_DOWN):
				if(!pacman.hasObstacleDown()) {//down pacman
					pacman.setDirection(Direction.Down);
				}
				break;
			default:
		//	System.out.println("No event !!");
			break;
		}
		gui.update();
	//	System.out.println("pacman direction is " + pacman.getDirection());

	}

}
