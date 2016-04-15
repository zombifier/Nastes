package model;

public class PiecePosition {
	int x;
	int y;
	
	public PiecePosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void rotate(boolean direction) { // true for clockwise, false for counterclockwise
		int temp = x;
		x = y;
		y = temp;
		if (direction) x *= -1;
		else y *= -1;
	}
	
	public void flip(boolean direction) { // true for horizontal, false for vertical
		if (direction) x *= -1;
		else y *= -1;
	}
}
