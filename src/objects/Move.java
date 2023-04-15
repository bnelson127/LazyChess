package objects;

public class Move {
	private Location startLocation;
	private Location endLocation;
	private int piecesMadeVulnerable;
	
	public Move(Location startLocation, Location endLocation, int piecesMadeVulnerable) {
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.piecesMadeVulnerable = piecesMadeVulnerable;
	}
	
	public Location getStartLocation() {
		return this.startLocation;
	}
	
	public Location getEndLocation() {
		return this.endLocation;
	}
	
	public int getPiecesMadeVulnerable() {
		return this.piecesMadeVulnerable;
	}
	
	@Override
	public String toString() {
		return startLocation+" to "+endLocation+" leaving "+piecesMadeVulnerable+" of your pieces vulnerable";
	}
}
