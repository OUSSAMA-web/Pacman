package game;

import cell.*;
import gui.Gui;
import pacgome.PacgomeNormal;
import pacgome.PacgomeSpecial;
import pacgome.PacgomeSpecial.PacgomColor;

public class App extends MazeFactory {

	final static int CELL = 20;
	private static Cell[][] cell;
	private static int tileHeight = 22;
	private static int tileWidth = 16;
	private char[][] map = new char[tileHeight][tileWidth];
  
	@Override
	public Cell makeCellNormal() {
		return new NormalCell();
	}

	@Override
	public Cell makeCellObstacle() {
		return new ObstacleCell();
	}

	@Override
	public Cell makeCellSortie() {
		return new FantomeSortie();
	}

	@Override
	public Cell makeCellPacgome(PacgomColor color) {
		if (color != null) {
			return new PacgomeSpecial(color);
		} else {
			return new PacgomeNormal();
		}
	}
	/**Choix d'objet correspondant selon la structure du Map en utilisant factory pattern**/
	public  Cell Factory(char type) {
		switch (type) {
		case 'h':
			return makeCellObstacle();
		case 'e':
			return makeCellSortie();
		case 'p':
			return makeCellPacgome(PacgomColor.PORANGE);
		case 'q':
			return makeCellPacgome(PacgomColor.PVERT);
		case 'm':
			return makeCellPacgome(PacgomColor.PVIOLET);
		case 'n':
			return makeCellPacgome(null);
		default:
			break;
		}
		return makeCellNormal();
	}

	/** Remplissage de la Matrice Cell[][] **/
	public static Cell[][] Map(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				cell[i][j] = new App().Factory(map[i][j]);
			}
		}
		return cell;
	}

	public static void main(String[] args) {

		cell = new Cell[tileHeight][tileWidth];
		cell = Map(map1(0));

		Game game = new Game(cell);
		new Gui(game, tileHeight, tileWidth);
		game.start();
	}

	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}

	/** définit deux matrice pour le changement du Map **/
	public static char[][] map1(int x) {
		char[][] map = {
				{ 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h' },
				{ 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h' },
				{ 'h', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'o', 'h', 'h', 'h', 'o', 'h' },
				{ 'h', 'p', 'o', '*', '*', '*', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'm', 'h' },
				{ 'h', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'o', 'h', 'o', 'h' },
				{ 'o', 'o', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'o', 'h', 'o', 'o' },
				{ 'o', 'o', 'h', 'o', 'h', 'o', 'h', 'e', 'e', 'h', 'o', 'h', 'o', 'h', 'o', 'o' },
				{ 'h', 'o', 'o', 'o', 'h', 'o', 'h', 'o', 'o', 'h', 'o', 'h', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'h', 'o', 'o', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'h', 'h', 'h', 'h', 'o', 'o', 'o', 'o', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'o', 'o', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'h', 'o', 'h', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'h', 'm', 'o', 'h', 'o', 'h', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'n', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'h', 'h', 'h', 'o', 'h', 'o', 'h', 'o', 'h', 'o', 'h' },
				{ 'h', 'q', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'h', 'h', 'o', 'h' },
				{ 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'p', 'o', 'o', 'o', 'h' },
				{ 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h' }, };
		
		char[][] map1 = {
				{ 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h' },
				{ 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h' },
				{ 'h', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'h', 'h', 'h', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'h', 'e', 'e', 'h', 'o', 'o', 'o', 'h', 'o', 'h' },
				{ 'o', 'o', 'o', 'o', 'h', 'o', 'h', 'o', 'o', 'h', 'o', 'o', 'o', 'h', 'o', 'o' },
				{ 'o', 'o', 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'h', 'o', 'o', 'o', 'h', 'o', 'o' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'h', 'h', 'h', 'h', 'o', 'o', 'o', 'o', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', '*', '*', '*', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'h', '*', 'h', '*', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'h', 'h', 'h', 'h', '*', 'h', '*', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', '*', 'h', '*', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h', 'o', 'h' },
				{ 'h', 'o', 'h', 'h', 'h', 'h', 'h', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'h' },
				{ 'h', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'h' },
				{ 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'o', 'o', 'h', 'h', 'h', 'h', 'h', 'h', 'h' }, };

		if (x == 0)
			return map;
		return map1;
	}
	
}