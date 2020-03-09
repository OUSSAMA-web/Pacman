package pacman;

import java.awt.Color;

import cell.Cell;
import cell.Cell.typeCell;
import game.Game;
import utils.Coordinate;

public abstract class PacmanNormal implements PacmanState {

	public Game game;
	private Cell[][] cell;
	private static boolean viePlus = false;

	public PacmanNormal(Game game) {
		this.game = game;
		this.cell = game.getcell();

	}

	@Override
	public void move(PacmanContext pacman) {
		int xPacman = pacman.getCoordinate().getX();
		int yPacman = pacman.getCoordinate().getY();
		int xDirection = pacman.getDirection().getX();
		int yDirection = pacman.getDirection().getY();
		boolean traverse = cell[xPacman + xDirection][yPacman + yDirection].getTraversable();

		pacman.decrement();
		outFrame(pacman, xPacman, yPacman, xDirection, yDirection, traverse);
		changementState(pacman, xPacman + xDirection, yPacman + yDirection);
		PacmanContext.setScore(PacmanContext.getScore() + cell[xPacman][yPacman].score());
		cell[xPacman][yPacman].setMange(true);

		/**Pacman mort ou non s'il traverse un fantome selon son état**/
		if (pacman.isFantome()) {
			pacman.getPacmanState().isAlive(pacman);
		}
		if (viePlus == false)
			viePlus(pacman);
	}

	/**methode qui gére les déplacement du pacman si'il dépasse les bornes**/
	public void outFrame(PacmanContext pacman, int xPacman, int yPacman, int xDirection, int yDirection,
			boolean traverse) {
		if (traverse) {
			if (xPacman + xDirection == 0) {
				pacman.setCoordinate(new Coordinate(22, yPacman));
			} else if (xPacman + xDirection >= 21) {
				pacman.setCoordinate(new Coordinate(0, yPacman));
			} else if (yPacman + yDirection == 0) {
				pacman.setCoordinate(new Coordinate(xPacman, 15));
			} else if (yPacman + yDirection >= 15) {
				pacman.setCoordinate(new Coordinate(xPacman, 0));
			} else {
				pacman.setCoordinate(new Coordinate(xPacman + xDirection, yPacman + yDirection));
			}
		}
	}

	/**methode qui change l'état du pacman lorsqu'il mange des pacgome**/
	public void changementState(PacmanContext pacman, int x, int y) 
	{
		if (pacman.isPacgome(typeCell.pacgomeSpecial, x, y)) {
			pacman.setPacmanState(new SuperPacman(game));
			this.game.getFantome().setVulnerable(true);
			pacman.setTimer(20);
		}
		if (pacman.isPacgome(typeCell.pacgomeSpecial1, x, y)) {
			game.setChangeMap(true);
		}
		if (pacman.isPacgome(typeCell.pacgomeSpecile2, x, y)) {
			pacman.setPacmanState(new Invisible(game));
			pacman.setTimer(50);
		}
		/** Pacman revient à son état normal une fois le compteur=0 **/
		if (pacman.getTimer() == 0)
			pacman.setPacmanState(new Normal(game));
	}

	/**methode qui ajoute une vie de plus si pacman aura un score > 5000 **/
	public void viePlus(PacmanContext pacman) {
		if (PacmanContext.getScore() > 5000) {
			viePlus = true;
			PacmanContext.setLive((PacmanContext.getLive() + 1));
		}
	}

	@Override
	public Color pacmanColor() {
		return Color.MAGENTA;
	}

	@Override
	public boolean isSuperpacman() {
		return false;
	}

	@Override
	public boolean isInvisible() {
		return false;
	}

}
