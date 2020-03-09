package pacman;

import java.awt.Color;

 
public interface PacmanState {

	public void move(PacmanContext pacman);
	public  Color pacmanColor() ; 	
	public  boolean isSuperpacman();
	public  boolean isInvisible();
	public void isAlive(PacmanContext pacman);
	
	
}
