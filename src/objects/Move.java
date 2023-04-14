package objects;

public class Move {
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private int piecesMadeVulnerable;
	private boolean kingMadeVulnerable;
	
	public Move(int startX, int startY, int endX, int endY, int piecesMadeVulnerable, boolean kingMadeVulnerable) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.piecesMadeVulnerable = piecesMadeVulnerable;
		this.kingMadeVulnerable = kingMadeVulnerable;
	}
	
	public int getStartX() {
		return this.startX;
	}
	
	public int getStartY() {
		return this.startY;
	}
	
	public int getEndX() {
		return this.endY;
	}
	
	public int getEndY() {
		return this.endY;
	}
	
	public int getPiecesMadeVulnerable() {
		return this.piecesMadeVulnerable;
	}
	
	public boolean getKingMadeVulnerable() {
		return this.kingMadeVulnerable;
	}
}
