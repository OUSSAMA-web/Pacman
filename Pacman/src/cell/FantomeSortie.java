package cell;

public class FantomeSortie implements Cell{

	@Override
	public typeCell getType() {
		return typeCell.fantomeSortie;
	}

	@Override
	public boolean getTraversable() {
		return true;
	}
	
	@Override
	public boolean mange() {
		return false;
	}

	@Override
	public void setMange(boolean mange) {	
	}

	@Override
	public int score() {
		return 0;
	}

	
}
