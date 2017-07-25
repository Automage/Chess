
public class Chess {

	public static void main(String[] args) {
		
		//Initialization
		
		Board board = new Board();
		boolean kingDown = false;
		boolean proceed = false;
		//Creating Players
		Player playerWhite = new Player("White");
		Player playerBlack = new Player("Black");
		//Temporary storage
		String piece = "";
		int[] xy = new int[2];
	
		board.create();
		board.update();
		board.draw();
		Player.pieceNames = board.getPieceNames();
		
		//GAME START
		
		while (kingDown == false) {
			
			//White's turn
			while (proceed == false) {
					
				piece = playerWhite.askPiece();
				xy = playerWhite.askSquare();
				board.move(piece, xy);
				proceed = board.getValidity();
			}
						
			board.update();
			board.draw();
			proceed = false;
			
			//Black's turn
			while (proceed == false) {
				
				piece = playerBlack.askPiece();
				xy = playerBlack.askSquare();
				board.move(piece, xy);
				proceed = board.getValidity();
			}
			
			board.update();
			board.draw();
			proceed = false;
		}
		
		System.out.println("gg");
		
		
		
		
		
		

}
}
