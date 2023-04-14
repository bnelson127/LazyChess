package constants;

public enum PieceTypes {
	ENEMY_BISHOP("b"),
	ENEMY_KING("k"),
	ENEMY_KNIGHT("n"),
	ENEMY_PAWN("p"),
	ENEMY_QUEEN("q"),
	ENEMY_ROOK("r"),
	FRIENDLY_BISHOP("B"),
	FRIENDLY_KING("K"),
	FRIENDLY_KNIGHT("N"),
	FRIENDLY_PAWN("P"),
	FRIENDLY_QUEEN("Q"),
	FRIENDLY_ROOK("R");
	
	public final String letter;

    private PieceTypes(String letter) {
        this.letter = letter;
    }
}
