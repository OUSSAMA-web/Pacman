package utils;

public enum Direction {

	Up(-1, 0), 
	Down(1, 0), 
	Left(0, -1),
	Right(0, 1), 
	Stop(0, 0);

	private int x;
	private int y;
           
	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
