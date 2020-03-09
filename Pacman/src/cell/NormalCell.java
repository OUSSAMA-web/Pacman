package cell;
/****/
public class NormalCell implements Cell{

	@Override
	public typeCell getType() {
		return typeCell.normalCell;
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
		// TODO Auto-generated method stub
	}

	@Override
	public int score() {
		return 0;
	}

}
