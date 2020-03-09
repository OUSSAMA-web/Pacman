package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

import cell.Cell;
import cell.Cell.typeCell;
import cell.NormalCell;
import fantome.Fantome;
import game.Game;
import pacman.PacmanContext;
import utils.Coordinate;

public class MyJComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private static Map<Cell.typeCell, Color> colorMap = new HashMap<Cell.typeCell, Color>();
	public Game game;
	private int tileHeight;
	private int tileWidth;
	private static int CELL = 20;

	static {
		colorMap.put(Cell.typeCell.fantomeSortie, Color.blue);
		colorMap.put(Cell.typeCell.obstacleCell, Color.white);
		colorMap.put(Cell.typeCell.normalCell, Color.black);
		colorMap.put(Cell.typeCell.pacgomeNormal, Color.blue);
		colorMap.put(Cell.typeCell.pacgomeSpecial, Color.orange);
		colorMap.put(Cell.typeCell.pacgomeSpecial1, Color.green);
		colorMap.put(Cell.typeCell.pacgomeSpecile2, Color.pink);
	}

	public MyJComponent(Game game, int tileHeight, int tileWidth) {
		this.tileHeight = tileHeight;
		this.tileWidth = tileWidth;
		this.game = game;

	}
	/** Dessin les élements du terrain **/
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 17 * CELL, 22 * CELL);
		this.game.getPacgomes().clear();

		for (int x = 0; x < tileHeight; x++) {
			for (int y = 0; y < tileWidth; y++) {
				typeCell type = game.getcell()[x][y].getType();
				
				if(type == typeCell.pacgomeNormal || type == typeCell.pacgomeSpecial
						|| type == typeCell.pacgomeSpecial1 || type == typeCell.pacgomeSpecile2) {
					game.getPacgomes().put(new Coordinate(x, y),type);/**liste qui contient les pacgommes**/
				}
				
				if(game.getcell()[x][y].mange()) {/**changer le type du pacgomes une fois traverser par Pacman**/
					game.getcell()[x][y] = new NormalCell();
				}

				g.setColor(colorOfCell(game.getcell()[x][y]));
				g.fillRect(y * CELL + CELL / 2 - 7, x * CELL + CELL / 2 - 7, 16, 16);
			}
		}

		g.drawString("Score: " + PacmanContext.getScore(), 75, 460);
		g.drawString("Lives: " + PacmanContext.getLive(), 225, 460);
		drawPacman(game.getPacman().getColor(),
				new Coordinate(game.getPacman().getCoordinate().getX(), game.getPacman().getCoordinate().getY()), g);

		for (int i = 0; i < 4; i++) {
			Fantome fantome = game.getFantome().getFantomes().get(i);
			drawFantome(fantome.getColor(),
					new Coordinate(fantome.getCoordinate().getX(), fantome.getCoordinate().getY()), g);
		}
	}


	private void drawPacman(Color c, Coordinate co, Graphics g) {
		game.createPacman(co);
		g.setColor(c);
		g.fillOval(co.getY() * CELL + CELL / 2 - 7, co.getX() * CELL + CELL / 2 - 7, 16, 16);
	}

	private void drawFantome(Color c, Coordinate co, Graphics g) {
		game.createFantome(co);
		g.setColor(c);
		g.fillOval(co.getY() * CELL + CELL / 2 - 7, co.getX() * CELL + CELL / 2 - 7, 16, 16);
	}

	private Color colorOfCell(Cell b) {
		Color c = colorMap.get(b.getType());
		if (c == null)
			return Color.WHITE;
		return c;
	}

}
