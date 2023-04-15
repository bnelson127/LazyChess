import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import objects.Board;
import objects.Location;
import objects.Move;
import objects.pieces.AbstractPiece;

public class main {

	public static void main(String[] args) 
	{
		File boardFile = new File("files\\board.txt");
	    Scanner scanner;
	    String stringBoard = "";
		try {
			scanner = new Scanner(boardFile);
			while (scanner.hasNext()) {
		    	stringBoard += scanner.nextLine() + "\n";
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(stringBoard);
		Board board = new Board(stringBoard);
		Move move = board.getRandomMove();
		Location start = move.getStartLocation();
		AbstractPiece piece = board.getPiece(start.getX(), start.getY());
		System.out.println("Move "+piece+" from " + move);
	}

}
