package pacgome;

import cell.Cell;
import cell.Cell.typeCell;
import pacgome.PacgomeSpecial.PacgomColor;

/** Choix du Pacgomme selon son type en utilisant Factory Pattern **/
public class pacgomeFactory {

	public static Cell makePacgome(typeCell type) {
		switch (type) {
		case pacgomeNormal:
			return new PacgomeNormal();

		case pacgomeSpecial:
			return new PacgomeSpecial(PacgomColor.PORANGE);

		case pacgomeSpecial1:
			return new PacgomeSpecial(PacgomColor.PVERT);

		case pacgomeSpecile2:
			return new PacgomeSpecial(PacgomColor.PVIOLET);
		default:
			break;
		}
		return null;

	}
}
