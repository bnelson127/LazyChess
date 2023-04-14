package objects;

public class Move {
	private Location startLocation;
	private Location endLocation;
	private int endY;
	private int piecesMadeVulnerable;
	private boolean kingMadeVulnerable;
	
	public Move(Location startLocation, Location endLocation, int piecesMadeVulnerable, boolean kingMadeVulnerable) {
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.piecesMadeVulnerable = piecesMadeVulnerable;
		this.kingMadeVulnerable = kingMadeVulnerable;
	}
	
	public Location getStartLocation() {
		return this.startLocation;
	}
	
	public Location getEndLocation() {
		return this.startLocation;
	}
	
	public int getPiecesMadeVulnerable() {
		return this.piecesMadeVulnerable;
	}
	
	public boolean getKingMadeVulnerable() {
		return this.kingMadeVulnerable;
	}
}
