package objects.pieces;

import java.util.ArrayList;

import objects.Board;
import objects.Location;

public class Pawn extends AbstractPiece {

	public Pawn(int x, int y, boolean isEnemy, Board board) {
		super(x, y, isEnemy, board);
	}
	
	@Override
	public ArrayList<Location> getPossibleMoveLocations() {
		ArrayList<Location> locations = new ArrayList<Location>();
		
		int newY = this.isEnemy ? this.y + 1 : this.y - 1;
		this.addLocationIfValid(this.x, newY, locations);
		this.addLocationIfValid(this.x + 1, newY, locations);
		this.addLocationIfValid(this.x - 1, newY, locations);
		
		return locations;
	}
	
	@Override
	public Pawn makeCopy() {
		return new Pawn(this.x, this.y, this.isEnemy, this.board);
	}
	
	@Override
	protected boolean addLocationIfValid(int newX, int newY, ArrayList<Location> locations) {
		if (this.isLocationOnBoard(newX, newY)) {
			AbstractPiece pieceAtNewSpot = this.board.getPiece(newX, newY);
			if (newX == this.x) {
				if (pieceAtNewSpot == null) {
					locations.add(new Location(newX, newY));
					return true;
				}
				return false;
			}
			else {
				if (pieceAtNewSpot != null && pieceAtNewSpot.isEnemy != this.isEnemy) {
					locations.add(new Location(newX, newY));
					return true;
				}
				return false;
			}
		}
		
		return false;
	}

}
