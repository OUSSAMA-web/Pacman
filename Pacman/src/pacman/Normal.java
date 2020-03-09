package pacman;

import game.Game;

public class Normal extends PacmanNormal {

	public Normal(Game game)
	{
	   super(game);
	}

	@Override
	public void isAlive(PacmanContext pacman) {
		PacmanContext.setLive(PacmanContext.getLive()-1);
		//System.out.println("vie est :" +PacmanContext.getLive());
	}
}
