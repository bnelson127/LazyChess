package objects.pieces;

import java.util.ArrayList;

import objects.Board;
import objects.Location;
import objects.Move;

public class Bishop extends AbstractPiece {

	public Bishop(int x, int y, boolean isEnemy, Board board) {
		super(x, y, isEnemy, board);
	}
	
	@Override
	public ArrayList<Move> getPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Location> getPossibleMoveLocations() {
		ArrayList<Location> locations = new ArrayList<Location>();
		int newX = this.x;
		int newY = this.y;
		
		boolean continueMoving = true;
		while (continueMoving) {
			newX += 1;
			newY += 1;
			continueMoving = this.addLocationIfValid(newX, newY, locations);
		}
		
		newX = this.x;
		newY = this.y;
		
		continueMoving = true;
		while (continueMoving) {
			newX -= 1;
			newY += 1;
			continueMoving = this.addLocationIfValid(newX, newY, locations);
		}
		
		newX = this.x;
		newY = this.y;
		
		continueMoving = true;
		while (continueMoving) {
			newX += 1;
			newY -= 1;
			continueMoving = this.addLocationIfValid(newX, newY, locations);
		}
		
		newX = this.x;
		newY = this.y;
		
		continueMoving = true;
		while (continueMoving) {
			newX -= 1;
			newY -= 1;
			continueMoving = this.addLocationIfValid(newX, newY, locations);
		}
		
		return locations;
	}
	
	@Override
	protected boolean addLocationIfValid(int newX, int newY, ArrayList<Location> locations) {
		if (this.isLocationOnBoard(newX, newY)) {
			AbstractPiece pieceAtNewSpot = this.board.getPiece(newX, newY);
			if(pieceAtNewSpot == null || pieceAtNewSpot.isEnemy != this.isEnemy) {
				locations.add(new Location(newX, newY));
			}
			
			return pieceAtNewSpot == null;
		}
		
		return false;
	}

}
