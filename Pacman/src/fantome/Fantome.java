package fantome;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import cell.Cell;
import cell.Cell.typeCell;
import game.Game;
import utils.Coordinate;
import utils.Direction;

// cette classe 
public abstract class Fantome {

	private Cell[][] cell;
	private Game game;
	private Coordinate coordinate;
	private Direction direction;
	@SuppressWarnings("unused")
	private Color color;
	ArrayList<Direction> fantomDirection = new ArrayList<>();
	// ces deux attributs nous aident a affecter des direction aleatoire 
	Random random = new Random();
	int nb = random.nextInt(3);
	private boolean center;
    private int timerOut; 
	
	
	// constructeur 
	public Fantome(Coordinate coordinate, Game game, int timerOut) {
		this.setCoordinate(coordinate);
		this.setDirection(Direction.Up);
		this.game = game;
		this.cell = game.getcell();
		this.timerOut=timerOut;
	}

	public abstract Color getColor();

	// move normale pour chaque fanyome
	public void move() {

		if(timerOut==0)
		{
		int x = coordinate.getX() + direction.getX();
		int y = coordinate.getY() + direction.getY();
		fantomDirection();
		Direction d = getDirection();
		if (passer() || outRoom()) {
			this.fantomDirection.remove(d);
			setDirection(this.fantomDirection.get(nb));
			this.fantomDirection.add(d);
		} else {
			setCoordinate(new Coordinate(x, y));
		}
		}else timerOut--;
	}
	
  //gestion de deplacement du fantome dans JPanel
	public boolean passer() {
		int x = coordinate.getX() + direction.getX();
		int y = coordinate.getY() + direction.getY();
		if (!cell[x][y].getTraversable() || (x > 20 || x <= 0) || (y >= 15 || y < 1)) {
			return true;
		} else
			return false;
	}
 
	// cette methode ne permet pas au fantome de rentrer dans la case initiale 
	public boolean outRoom() {
		if (cell[coordinate.getX() + 1][coordinate.getY()].getType().equals(typeCell.fantomeSortie)
				&& this.getDirection().equals(Direction.Down)) {
			// System.out.println(this.getCell()[coordinate.getX()
			// +1][coordinate.getY()].getType());
			return true;
		} else
			return false;
	}

	// tableaux des direction 
	public void fantomDirection() {
		this.fantomDirection.add(Direction.Down);
		this.fantomDirection.add(Direction.Up);
		this.fantomDirection.add(Direction.Left);
		this.fantomDirection.add(Direction.Right);
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Cell[][] getCell() {
		return cell;
	}

	public void setCell(Cell[][] cell) {
		this.cell = cell;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public boolean isCenter() {
		return center;
	}

	public void setCenter(boolean center) {
		this.center = center;
	}

}
