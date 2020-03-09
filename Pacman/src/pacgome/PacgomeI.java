package pacgome;

import java.awt.Color;

import cell.Cell.typeCell;
/**Interface designe les caractéristiques d'un pacgommes : type, score...**/
public interface PacgomeI {
	
	public int score() ; 
	public boolean mange() ; 
	public void setMange(boolean mange) ; 
	public boolean travesable() ; 
	public typeCell pacgomeType() ;
	public Color pacgomeColor() ; 
}
