package objects;

import objects.pieces.AbstractPiece;
import objects.pieces.Bishop;
import objects.pieces.King;
import objects.pieces.Knight;
import objects.pieces.Pawn;
import objects.pieces.Queen;
import objects.pieces.Rook;

import java.util.ArrayList;

import constants.PieceTypes;

public class Board {
	
	private AbstractPiece[] pieces = new AbstractPiece[64];

	public Board(String board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				char pieceAtIndex = board.charAt((i * 2 + 1) * 18 + j * 2 + 1);
				AbstractPiece currentPiece;
				switch (pieceAtIndex) {
					case PieceTypes.ENEMY_BISHOP:
						currentPiece = new Bishop(j, i, true, this);
						break;
					case PieceTypes.ENEMY_KING:
						currentPiece = new King(j, i, true, this);
						break;
					case PieceTypes.ENEMY_KNIGHT:
						currentPiece = new Knight(j, i, true, this);
						break;
					case PieceTypes.ENEMY_PAWN:
						currentPiece = new Pawn(j, i, true, this);
						break;
					case PieceTypes.ENEMY_QUEEN:
						currentPiece = new Queen(j, i, true, this);
						break;
					case PieceTypes.ENEMY_ROOK:
						currentPiece = new Rook(j, i, true, this);
						break;
					case PieceTypes.FRIENDLY_BISHOP:
						currentPiece = new Bishop(j, i, false, this);
						break;
					case PieceTypes.FRIENDLY_KING:
						currentPiece = new King(j, i, false, this);
						break;
					case PieceTypes.FRIENDLY_KNIGHT:
						currentPiece = new Knight(j, i, false, this);
						break;
					case PieceTypes.FRIENDLY_PAWN:
						currentPiece = new Pawn(j, i, false, this);
						break;
					case PieceTypes.FRIENDLY_QUEEN:
						currentPiece = new Queen(j, i, false, this);
						break;
					case PieceTypes.FRIENDLY_ROOK:
						currentPiece = new Rook(j, i, false, this);
						break;
					default:
						currentPiece = null;
					
				}
				this.pieces[i * 8 + j] = currentPiece;
			}
		}
	}
	
	public AbstractPiece getPiece(int x, int y) {
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			return null;
		}
		return this.pieces[y * 8 + x];
	}
	
	public Move getRandomMove() {
		ArrayList<Move> possibleMoves = new ArrayList<Move>();
		int lowestThreatCount = 16;
		
		for (int i = 0; i < this.pieces.length; i++) {
			
			if (pieces[i] != null && !pieces[i].getIsEnemy()) {
				
				ArrayList<Location> moveLocations = pieces[i].getPossibleMoveLocations();
				Location start = new Location(i % 8, i / 8);
				
				for (int j = 0; j < moveLocations.size(); j++) {
					Location end = moveLocations.get(j);
					
					Board copiedBoard = this.getCopyOfBoardWithMovedPiece(i, end);
					ArrayList<Location> possibleEnemyMoveLocations = this.getPossibleEnemyMoveLocations(copiedBoard);
					
					boolean kingThreatened = this.getIsFriendlyKingThreatened(copiedBoard, possibleEnemyMoveLocations);
					if (!kingThreatened) {
						int threatenedPieces = this.getNumberOfFriendlyPiecesThreatened(copiedBoard, possibleEnemyMoveLocations);
						if (threatenedPieces < lowestThreatCount) {
							lowestThreatCount = threatenedPieces;
						}
						possibleMoves.add(new Move(start, end, threatenedPieces));
					}					
				}
			}
		}
		
		if (possibleMoves.size() == 0) {
			return null;
		}
		
		ArrayList<Move> leastThreateningMoves = new ArrayList<Move>();
		for (int i = 0; i < possibleMoves.size(); i++) {
			if(possibleMoves.get(i).getPiecesMadeVulnerable() == lowestThreatCount) {
				leastThreateningMoves.add(possibleMoves.get(i));
			}
		}
		
		return leastThreateningMoves.get((int) (Math.random() * leastThreateningMoves.size()));
	}
	
	@Override
	public String toString() {
		String stringBoard = "+---------------+\n|";
		for (int i = 0; i < this.pieces.length; i++) {
			char letter = ' ';
			AbstractPiece piece = pieces[i];
			if (piece != null) {
				switch(piece.getClass().getSimpleName()) {
					case "Bishop":
						if (piece.getIsEnemy()) letter = PieceTypes.ENEMY_BISHOP;
						else letter = PieceTypes.FRIENDLY_BISHOP;
						break;
					case "King":
						if (piece.getIsEnemy()) letter = PieceTypes.ENEMY_KING;
						else letter = PieceTypes.FRIENDLY_KING;
						break;
					case "Knight":
						if (piece.getIsEnemy()) letter = PieceTypes.ENEMY_KNIGHT;
						else letter = PieceTypes.FRIENDLY_KNIGHT;
						break;
					case "Pawn":
						if (piece.getIsEnemy()) letter = PieceTypes.ENEMY_PAWN;
						else letter = PieceTypes.FRIENDLY_PAWN;
						break;
					case "Queen":
						if (piece.getIsEnemy()) letter = PieceTypes.ENEMY_QUEEN;
						else letter = PieceTypes.FRIENDLY_QUEEN;
						break;
					case "Rook":
						if (piece.getIsEnemy()) letter = PieceTypes.ENEMY_ROOK;
						else letter = PieceTypes.FRIENDLY_ROOK;
						break;
					default:
						letter = ' ';
				}
			}
			
			stringBoard += letter + "|";
			if (i % 8 == 7 && i != 63) {
				stringBoard += "\n|-+-+-+-+-+-+-+-|\n|";
			}
		}
		stringBoard += "\n+---------------+";
		return stringBoard;
	}
	
	protected Board(AbstractPiece[] pieces) {
		this.pieces = pieces;
	}
	
	private Board getCopyOfBoardWithMovedPiece(int startIndex, Location end) {
		AbstractPiece[] copiedPieces = new AbstractPiece[this.pieces.length];
		for (int i = 0; i < this.pieces.length; i++) {
			AbstractPiece copiedPiece = this.pieces[i];
			if (copiedPiece != null) {
				copiedPiece = copiedPiece.makeCopy();
			}
			copiedPieces[i] = copiedPiece;
		}
		
		int endIndex = end.getY() * 8 + end.getX();
		copiedPieces[endIndex] = copiedPieces[startIndex];
		copiedPieces[startIndex] = null;
		
		Board copiedBoard = new Board(copiedPieces);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				AbstractPiece copiedPiece = copiedBoard.getPiece(j, i);
				if(copiedPiece != null) {
					copiedPiece.setBoard(copiedBoard);
				}
			}
		}
		
		return copiedBoard;
	}
	
	private ArrayList<Location> getPossibleEnemyMoveLocations(Board board) {
		ArrayList<Location> moveLocations = new ArrayList<Location>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				AbstractPiece piece = board.getPiece(j, i);
				if (piece != null && piece.getIsEnemy()) {
					ArrayList<Location> possibleMoves = piece.getPossibleMoveLocations();
					moveLocations.addAll(possibleMoves);
				}
			}
		}
		return moveLocations;
	}
	
	private int getNumberOfFriendlyPiecesThreatened(Board board, ArrayList<Location> enemyMoveLocations) {
		int numberOfPiecesThreatened = 0;
		for (int k = 0; k < enemyMoveLocations.size(); k++) {
			Location move = enemyMoveLocations.get(k);
			
			AbstractPiece pieceAtNewLocation = board.getPiece(move.getX(), move.getY());
			if(pieceAtNewLocation != null && !pieceAtNewLocation.getIsEnemy()) {
				numberOfPiecesThreatened++;
			}
		}
		
		return numberOfPiecesThreatened;
	}
	
	private boolean getIsFriendlyKingThreatened(Board board, ArrayList<Location> enemyMoveLocations) {
		for (int k = 0; k < enemyMoveLocations.size(); k++) {
			Location move = enemyMoveLocations.get(k);
			
			AbstractPiece pieceAtNewLocation = board.getPiece(move.getX(), move.getY());
			if(pieceAtNewLocation != null && pieceAtNewLocation.getClass() == King.class && !pieceAtNewLocation.getIsEnemy()) {
				return true;
			}
		}
		
		return false;
	}
}
