
public class Chess {

	public static void main(String[] args) {
		
		
		Board board = new Board();
		Player playerWhite = new Player("White");
		Player playerBlack = new Player("Black");
		String piece = "";
		int[] xy = new int[2];
	
		
		board.create();
		board.update();
		board.draw();
		
		Player.pieceNames = board.getPieceNames();
		piece = playerWhite.askPiece();
		xy = playerWhite.askSquare();
		
		board.move(piece, xy);
		
		
		

}
}
