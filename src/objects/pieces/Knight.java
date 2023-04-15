package objects.pieces;

import java.util.ArrayList;

import objects.Board;
import objects.Location;

public class Knight extends AbstractPiece {

	public Knight(int x, int y, boolean isEnemy, Board board) {
		super(x, y, isEnemy, board);
	}
	
	@Override
	public ArrayList<Location> getPossibleMoveLocations() {
		ArrayList<Location> locations = new ArrayList<Location>();
		
		this.addLocationIfValid(this.x + 1, this.y + 2, locations);
		this.addLocationIfValid(this.x - 1, this.y + 2, locations);
		this.addLocationIfValid(this.x + 2, this.y + 1, locations);
		this.addLocationIfValid(this.x + 2, this.y - 1, locations);
		this.addLocationIfValid(this.x - 2, this.y + 1, locations);
		this.addLocationIfValid(this.x - 2, this.y - 1, locations);
		this.addLocationIfValid(this.x + 1, this.y - 2, locations);
		this.addLocationIfValid(this.x - 1, this.y - 2, locations);
		
		return locations;
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
