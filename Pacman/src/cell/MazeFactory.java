package cell;

import pacgome.PacgomeSpecial.PacgomColor;

public abstract class MazeFactory {
	
	public abstract Cell makeCellNormal() ; 
	public abstract Cell makeCellObstacle() ; 
	public abstract Cell makeCellSortie() ; 
	public abstract Cell makeCellPacgome(PacgomColor color) ; 
	
	
}
