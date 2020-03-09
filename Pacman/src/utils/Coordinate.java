package utils;


public class Coordinate {
	private int y;
	private int x;
	
	
	public Coordinate(int x, int y) { 
		this.x = x;
		this.y = y;
	}
	
	public Coordinate() {
		
	}
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setXY(int x,int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object o) {
	
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		
		Coordinate other = (Coordinate) o;
		
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		
		return true;
	}

}
