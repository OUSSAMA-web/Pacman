package pacgome;

import java.awt.Color;

import cell.Cell;


//PacgommeNormal = Pacgomme blue
public class PacgomeNormal implements PacgomeI,Cell{

	private boolean mange = false;
//	private typeCell currentRoomType ; 
	
	@Override
	public typeCell pacgomeType() {
		return getType() ; 
	}
	
	@Override
	public int score() {
		if(!mange())
		{
			return 100;
		}else
			return 0;
		
	}
	@Override
	public boolean mange() {
		return mange;
	}

	@Override
	public void setMange(boolean mange) {
		this.mange = mange ; 
	}

	@Override
	public boolean travesable() {
		return true ;
	}

	@Override
	public typeCell getType() {
		if (!mange()) {
			return typeCell.pacgomeNormal;
		} else {
			return typeCell.normalCell;
		}
	}

	@Override
	public boolean getTraversable() {
		return true;
	}

	@Override
	public Color pacgomeColor() {
		return Color.BLUE;
	}
	
}
