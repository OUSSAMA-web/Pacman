package game;

import java.util.HashMap;
import java.util.Map;

import cell.Cell;
import cell.Cell.typeCell;
import fantome.fantomesGroup;
import gui.Gui;
import pacgome.pacgomeFactory;
import pacman.PacmanContext;
import utils.Coordinate;

public class Game extends Thread {

	private Cell[][] cell;
	private Gui gui;
	private PacmanContext pacman;
	private fantomesGroup fantomes;
	private boolean changeMap = false;
	private HashMap<Coordinate, typeCell> listPacgomes;

	public Game(Cell[][] cell) {
		this.cell = cell;
		this.pacman = PacmanContext.getPacman(this);
		this.fantomes = new fantomesGroup(new Coordinate(10, 7), this);
		this.listPacgomes = new HashMap<>();
	}

	@Override
	public void run() {
		while (pacman.isRunning()) {
			changeMap();
			start(gui);

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start(Gui gui) {
		this.gui = gui;
		fantomes.move();
		pacman.move();
	}

	public PacmanContext createPacman(Coordinate c) {
		this.pacman.setGame(this);
		this.pacman.setCoordinate(c);

		return this.pacman;
	}

	public fantomesGroup createFantome(Coordinate c) {
		this.fantomes.setGame(this);

		return this.fantomes;
	}

	public PacmanContext getPacman() {
		return pacman;
	}

	public fantomesGroup getFantome() {
		return fantomes;
	}

	public Cell getcell(int x, int y) {
		return this.cell[x][y];
	}

	public Gui getGui() {
		return gui;
	}

	public void setGui(Gui gui) {
		this.gui = gui;
	}

	public Cell[][] getcell() {
		return cell;
	}

	public void setcell(Cell[][] cell) {
		this.cell = cell;
	}

	public void PrintCellType() {
		for (int x = 0; x < 22; x++) {
			for (int y = 0; y < 46; y++) {
				// System.out.println("--->"+ cell[x][y].getType());
			}
		}
	}

	public boolean isChangeMap() {
		return changeMap;
	}

	public void setChangeMap(boolean changeMap) {
		this.changeMap = changeMap;
	}

	public HashMap<Coordinate, typeCell> getPacgomes() {
		return listPacgomes;
	}

	public void setPacgomes(HashMap<Coordinate, typeCell> listPacgomes) {
		this.listPacgomes = listPacgomes;
	}

	public boolean isGameOver() {
		if (this.getPacgomes().isEmpty())
			return true;
		return false;
	}

	public void changeMap() {
		if (isChangeMap()) {
			this.setcell(App.Map(App.map1(1)));
			redrawPacgome();
		}
		setChangeMap(false);
	}

	public void redrawPacgome() {
		//PacmanContext.setLive(PacmanContext.getLive() + 1);
		for (Map.Entry<Coordinate, typeCell> listPacg : getPacgomes().entrySet()) {
			int x = listPacg.getKey().getX();
			int y = listPacg.getKey().getY();
			cell[x][y] = pacgomeFactory.makePacgome(listPacg.getValue());
		}
		getPacgomes().remove(getPacman().getCoordinate(), typeCell.pacgomeSpecial1);
	}

}
