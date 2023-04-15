package objects.pieces;

import java.util.ArrayList;

import objects.Board;
import objects.Location;

public abstract class AbstractPiece {
	
	protected int x = 0;
	protected int y = 0;
	protected boolean isEnemy = false;
	protected Board board = null;
	
	public AbstractPiece(int x, int y, boolean isEnemy, Board board) {
		this.x = x;
		this.y = y;
		this.isEnemy = isEnemy;
		this.board = board;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean getIsEnemy() {
		return this.isEnemy;
	}
	
	@Override
	public String toString() {
		String enemy = this.isEnemy ? "Enemy" : "Friendly";
		return enemy + " " + this.getClass().getSimpleName();
	}
	
	protected boolean isLocationOnBoard(int x, int y) {
		return x >= 0 && y >= 0 && x < 8 && y < 8;
	}
	
	abstract public AbstractPiece makeCopy();
	abstract public ArrayList<Location> getPossibleMoveLocations();
	abstract protected boolean addLocationIfValid(int newX, int newY, ArrayList<Location> locations);
}
