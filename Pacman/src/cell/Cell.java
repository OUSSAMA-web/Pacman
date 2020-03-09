package cell;

public interface Cell {
	 
	//pacgomeNormal = pacgomeBlue
	//pacgomeSpecial = pacgomeAutreCouleur
	public static enum typeCell{
		normalCell , obstacleCell, 
		pacgomeNormal, pacgomeSpecial,pacgomeSpecial1,pacgomeSpecile2,
		fantomeSortie;
	}
	public typeCell getType();
	public boolean getTraversable();
	public boolean mange();
	public void setMange(boolean mange);
	public int score() ; 
	
}
