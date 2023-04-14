package objects.pieces;

public abstract class AbstractPiece {
	
	protected int x = 0;
	protected int y = 0;
	protected boolean isEnemy = false;
	
//	public AbstractPiece() {
//		
//	}
	
	public AbstractPiece(int x, int y, boolean isEnemy) {
		this.x = x;
		this.y = y;
		this.isEnemy = isEnemy;
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
	
	abstract public int getPossibleMoves();
}
