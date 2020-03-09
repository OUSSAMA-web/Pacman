package pacgome;

import cell.Cell;

public class PacgomeSpecial extends PacgomeDecorator implements Cell {

	private PacgomColor color;
	
	public static enum PacgomColor{
		PORANGE , PVIOLET , PVERT ; 
	}
	
	public PacgomeSpecial(PacgomColor color) {
		super();
		this.color=color;
		
	}
	
	@Override
	public typeCell getType() {
		
			if(this.color.equals(PacgomColor.PORANGE))
			{
				return typeCell.pacgomeSpecial;
			}else if(this.color.equals(PacgomColor.PVERT))
			{
				return typeCell.pacgomeSpecial1;
			}else{
				return typeCell.pacgomeSpecile2;
			}
	}
	
	@Override
	public int score() {
		if(this.color.equals(PacgomColor.PORANGE))
		{
			return pacgomme.score()+400;
		}else if(this.color.equals(PacgomColor.PVERT)){
			return pacgomme.score()+900;
		}else{
			return pacgomme.score()+200;
		}
		
	}
	
	@Override
	public boolean mange() {
		return pacgomme.mange() ; 
	}

	@Override
	public void setMange(boolean mange) {
		pacgomme.setMange(mange);
	}

	@Override
	public boolean getTraversable() {
		return pacgomme.travesable() ; 
	}
	
}
