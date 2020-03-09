package pacgome;

import java.awt.Color;

import cell.Cell.typeCell;

/** Utilisation du Decorator Pattern pour faciliter l'ajout
 	** des nouvelles fonctionnalités, attributes... au pacgommes **/
public abstract class PacgomeDecorator implements PacgomeI{
	
	protected PacgomeI pacgomme ; 
	
	public PacgomeDecorator() {//ex : Shape = Rect or Cercle
		this.pacgomme = new PacgomeNormal() ; 
	}
	
	
	public typeCell pacgomeType() {
		return pacgomme.pacgomeType() ; 
	}
	public int score() {
		return pacgomme.score() ; 
	}
	

	
	public boolean mange() {
		return pacgomme.mange();
	}
	
	public void setMange(boolean mange) {
		pacgomme.setMange(mange);
	}
	
	public boolean travesable() {
		return pacgomme.travesable();
	}
	
	public Color pacgomeColor() {
		return pacgomme.pacgomeColor();
	}
	

}
