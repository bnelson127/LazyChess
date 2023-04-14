package objects;

import objects.pieces.AbstractPiece;
import objects.pieces.Bishop;
import objects.pieces.King;
import objects.pieces.Knight;
import objects.pieces.Pawn;
import objects.pieces.Queen;
import objects.pieces.Rook;
import constants.PieceTypes;

public class Board {
	
	private AbstractPiece[] board = new AbstractPiece[64];
	
	public Board(String board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				char pieceAtIndex = board.charAt((i * 2 + 1) * 18 + j * 2 + 1);
				AbstractPiece currentPiece;
				switch (pieceAtIndex) {
					case PieceTypes.ENEMY_BISHOP:
						currentPiece = new Bishop(j, i, true);
						break;
					case PieceTypes.ENEMY_KING:
						currentPiece = new King(j, i, true);
						break;
					case PieceTypes.ENEMY_KNIGHT:
						currentPiece = new Knight(j, i, true);
						break;
					case PieceTypes.ENEMY_PAWN:
						currentPiece = new Pawn(j, i, true);
						break;
					case PieceTypes.ENEMY_QUEEN:
						currentPiece = new Queen(j, i, true);
						break;
					case PieceTypes.ENEMY_ROOK:
						currentPiece = new Rook(j, i, true);
						break;
					case PieceTypes.FRIENDLY_BISHOP:
						currentPiece = new Bishop(j, i, false);
						break;
					case PieceTypes.FRIENDLY_KING:
						currentPiece = new King(j, i, false);
						break;
					case PieceTypes.FRIENDLY_KNIGHT:
						currentPiece = new Knight(j, i, false);
						break;
					case PieceTypes.FRIENDLY_PAWN:
						currentPiece = new Pawn(j, i, false);
						break;
					case PieceTypes.FRIENDLY_QUEEN:
						currentPiece = new Queen(j, i, false);
						break;
					case PieceTypes.FRIENDLY_ROOK:
						currentPiece = new Rook(j, i, false);
						break;
					default:
						currentPiece = null;
					
				}
				this.board[i * 8 + j] = currentPiece;
			}
		}
	}
	
	public AbstractPiece getPiece(int x, int y) {
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			return null;
		}
		return this.board[y * 8 + x];
	}
}
