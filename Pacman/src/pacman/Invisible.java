package pacman;

import java.awt.Color;
import game.Game;
/**Pacman State = Invisible**/
public class Invisible extends PacmanNormal{

	public Invisible(Game game)
	{
		super(game);
	}
	
	@Override
	public boolean isInvisible() {
		return true;
	}
	
	@Override
	public Color pacmanColor() {
		return Color.orange;
	}
	
	@Override
	public void isAlive(PacmanContext pacman) {
		//System.out.println("vie est :" +PacmanContext.getLive());
	}
}
