package objects.pieces;

import java.util.ArrayList;

import objects.Board;
import objects.Location;

public class King extends AbstractPiece {

	public King(int x, int y, boolean isEnemy, Board board) {
		super(x, y, isEnemy, board);
	}
	
	public ArrayList<Location> getPossibleMoveLocations() {
		ArrayList<Location> locations = new ArrayList<Location>();
		
		this.addLocationIfValid(this.x + 1, this.y + 1, locations);
		this.addLocationIfValid(this.x + 1, this.y - 1, locations);
		this.addLocationIfValid(this.x - 1, this.y + 1, locations);
		this.addLocationIfValid(this.x - 1, this.y - 1, locations);
		this.addLocationIfValid(this.x, this.y + 1, locations);
		this.addLocationIfValid(this.x, this.y - 1, locations);
		this.addLocationIfValid(this.x + 1, this.y, locations);
		this.addLocationIfValid(this.x - 1, this.y, locations);
		
		return locations;
	}
	
	@Override
	public King makeCopy() {
		return new King(this.x, this.y, this.isEnemy, this.board);
	}
	
	@Override
	protected boolean addLocationIfValid(int newX, int newY, ArrayList<Location> locations) {
		if (this.isLocationOnBoard(newX, newY)) {
			AbstractPiece pieceAtNewSpot = this.board.getPiece(newX, newY);
			if (pieceAtNewSpot == null || pieceAtNewSpot.isEnemy != this.isEnemy) {
				locations.add(new Location(newX, newY));
				return true;
			}
			return false;
		}
		
		return false;
	}

}
