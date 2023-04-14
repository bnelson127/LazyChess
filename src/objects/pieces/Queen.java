package objects.pieces;

import java.util.ArrayList;

import objects.Board;
import objects.Move;

public class Queen extends AbstractPiece {

	public Queen(int x, int y, boolean isEnemy, Board board) {
		super(x, y, isEnemy, board);
	}
	
	@Override
	public ArrayList<Move> getPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
