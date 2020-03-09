package cell;

public class ObstacleCell implements Cell{

	@Override
	public typeCell getType() {
		return typeCell.obstacleCell;
	}

	@Override
	public boolean getTraversable() {
		return false;
	} 
	@Override
	public boolean mange() {
		return false;
	}

	@Override
	public void setMange(boolean mange) {
		// TODO Auto-generated method stub
	}

	@Override
	public int score() {
		return 0;
	}
	

	
}
