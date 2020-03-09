package pacman;

/**
 * cette classe permet de definir les caractéristiques du Pacman  
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import cell.Cell.typeCell;
import game.Game;
import utils.Coordinate;
import utils.Direction;
/**PacmanContext = Pacman Observable**/
public class PacmanContext {

	private Game game;
	private Coordinate coordinate;
	private Direction direction = Direction.Stop;
	private boolean running;
	private static PacmanContext singleton = null; 
	private static int live;
	protected PacmanState pacmanState;
	private static int score;
	private List<PacmanObserver> observers;
	private int timer;
	private int timer2 = 3;

	public PacmanContext(Game game) {
		this.game = game;
		observers = new ArrayList<>();
		this.setCoordinate(new Coordinate(18, 7));
		pacmanState = new Normal(game);/**état initial du Pacman**/
		setRunning(true);
		live = 3;
		score = 0;
	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		PacmanContext.score = score;
	}

	public PacmanState getPacmanState() {
		return pacmanState;
	}

	public static int getLive() {
		return live;
	}

	public static void setLive(int live) {
		PacmanContext.live = live;
	}
	/**utilisation Singleton Pattern pour limiter les instances de l'objet Pacman **/
	public static synchronized PacmanContext getPacman(Game game) {
		if (singleton == null) {
			singleton = new PacmanContext(game);
		}
		return singleton;
	}

	public void move() {
		if (isRunning()) {
			pacmanState.move(this);
			notifyAllObservers();
		}
	}

	public Color getColor() {
		return pacmanState.pacmanColor();
	}

	public void setPacmanState(PacmanState pacmanState) {
		this.pacmanState = pacmanState;
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

	public void setDirection(Direction left) {
		this.direction = left;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public boolean isRunning() {
		if (!isAlive())
			running = false;

		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public boolean isAlive() {
		if (live <= 0) {
			System.out.println("Game Over : Pacman die! ");
			return false;
		}
		if (win()){
			System.out.println("Game Over : Pacman win ! ");
			return false;
		} 
		
		return true;
	}

	public boolean win() {
		if (timer2 > 0) {
			timer2--;
		}
		if (timer2 == 0)
			if (game.getPacgomes().isEmpty())
				return true;
		return false;
	}

	public boolean isInvisible() {
		return this.pacmanState.isInvisible();
	}

	public boolean isSuperPacman() {
		return this.pacmanState.isSuperpacman();
	}

	public void register(PacmanObserver o) {
		observers.add(o);
	}

	public void unregister(PacmanObserver o) {
		observers.remove(o);
	}

	public void notifyAllObservers() {
		for (PacmanObserver pacmanObserver : observers) {
			// System.out.println("A : Notify All Observers");
			pacmanObserver.update();
		}
	}

	public boolean hasObstacleUp() {

		int xPacman = this.getCoordinate().getX();
		int yPacman = this.getCoordinate().getY();

		if (game.getcell()[xPacman - 1][yPacman].getTraversable() == false)
			return true;
		return false;
	}

	public boolean hasObstacleDown() {
		int xPacman = this.getCoordinate().getX();
		int yPacman = this.getCoordinate().getY();

		if (game.getcell()[xPacman + 1][yPacman].getTraversable() == false)
			return true;
		return false;
	}

	public boolean hasObstacleLeft() {
		int xPacman = this.getCoordinate().getX();
		int yPacman = this.getCoordinate().getY();

		if (game.getcell()[xPacman][yPacman - 1].getTraversable() == false)
			return true;
		return false;
	}

	public boolean hasObstacleRight() {
		int xPacman = this.getCoordinate().getX();
		int yPacman = this.getCoordinate().getY();

		if (game.getcell()[xPacman][yPacman + 1].getTraversable() == false)
			return true;
		return false;
	}

	public boolean isPacgome(typeCell type, int x, int y) {
		if (game.getcell()[x][y].getType() == type)
			return true;
		return false;
	}

	public boolean isFantome() {
		for (int i = 0; i < 4; i++) {
			if (getCoordinate().equals(game.getFantome().getFantomes().get(i).getCoordinate())) {
				if (this.isSuperPacman()) {
					game.getFantome().getFantomes().get(i).setCenter(true);
				}
				return true;
			}
		}
		return false;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public void decrement() {
		if (timer > 0)
			timer--;
	}
}
