package objects.pieces;

import java.util.ArrayList;

import objects.Board;
import objects.Move;

public abstract class AbstractPiece {
	
	protected int x = 0;
	protected int y = 0;
	protected boolean isEnemy = false;
	protected Board board = null;
	
//	public AbstractPiece() {
//		
//	}
	
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
	
	abstract public ArrayList<Move> getPossibleMoves();
}
