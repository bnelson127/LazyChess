import pieces.AbstractPiece;

public class Board {
	
	private AbstractPiece[] board = new AbstractPiece[8];
	
	public Board(String board) {
		for (int i = 0; i < 64; i++) {
			for (int j = 0; j < 8; j++) {
				this.board[i*8 + j] = null;
			}
		}
	}
}
