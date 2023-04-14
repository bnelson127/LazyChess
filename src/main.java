import objects.Board;

public class main {

	public static void main(String[] args) 
	{
		String stringBoard = "+-+-+-+-+-+-+-+-+\n"
				+ "|r|n|b|q|k|b|n|r|\n"
				+ "+-+-+-+-+-+-+-+-+\n"
				+ "|p|p|p|p|p|p|p|p|\n"
				+ "+-+-+-+-+-+-+-+-+\n"
				+ "| | | | | | | | |\n"
				+ "+-+-+-+-+-+-+-+-+\n"
				+ "| | | | | | | | |\n"
				+ "+-+-+-+-+-+-+-+-+\n"
				+ "| | | | | | | | |\n"
				+ "+-+-+-+-+-+-+-+-+\n"
				+ "| | | | | | | | |\n"
				+ "+-+-+-+-+-+-+-+-+\n"
				+ "|P|P|P|P|P|P|P|P|\n"
				+ "+-+-+-+-+-+-+-+-+\n"
				+ "|R|N|B|Q|K|B|N|R|\n"
				+ "+-+-+-+-+-+-+-+-+\n";
		System.out.println(stringBoard);
		Board board = new Board(stringBoard);
	}

}
