
public class Chess {

	public static void main(String[] args) {
		
		System.out.println("Chess by Pman");
		System.out.println("https://github.com/Automage/Chess");
		
		//Initialization
		System.out.print("\nInitializing... ");
		
		Board board = new Board();
		boolean kingDown = false;
		boolean proceed = false;
		int turn = 0;
		//Creating Players
		Player playerWhite = new Player("White");
		Player playerBlack = new Player("Black");
		//Temporary storage
		String piece = "";
		int[] xy = new int[2];
	
		board.create();
		board.update();	
		Player.pieceNames = board.getPieceNames();
		
		System.out.println("Done");
		
		//GAME START
		while (kingDown == false) {
			
			if (turn!=0) {
				System.out.println("\nTurn "+turn+" Summary");
			}
			board.update();
			board.draw();
			proceed = false;
			
			//White's turn
			
			while (proceed == false) {
					
				piece = playerWhite.askPiece();
				xy = playerWhite.askSquare();
				board.move(piece, xy);
				proceed = board.getValidity();
				kingDown = Board.getKingDead();
			}
			
			if (kingDown == false) {
				
				turn++;
				System.out.println("\nTurn "+turn+" Summary");
				board.update();
				board.draw();
				proceed = false;	
				
				//Black's turn
				while (proceed == false) {
					
					piece = playerBlack.askPiece();
					xy = playerBlack.askSquare();
					board.move(piece, xy);
					proceed = board.getValidity();
					kingDown = Board.getKingDead();
				}
				proceed = false;	
				turn++;
			}	
			
		}
		
		board.update();
		board.draw();
		System.out.println("\nCheckmate!");
		System.out.println(Board.getWinner()+" wins after "+turn+" turns");
		System.out.println("gg");
	

	}
}
