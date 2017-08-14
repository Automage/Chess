
public class Chess {

	public static boolean earlyTerminate = false;
	
	public static void setEarlyTerminate(boolean earlyTerminate) {
		Chess.earlyTerminate = earlyTerminate;
	}

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
		Chess.setEarlyTerminate(false);
		
		System.out.println("Done");
		
		//GAME START
		while ((earlyTerminate == false)&&(kingDown == false)) {
			
			if (turn!=0) {
				System.out.println("\nTurn "+turn+" Summary");
			}
			board.update();
			board.draw();
			proceed = false;
			
			//White's turn
			
			while (proceed == false) {
					
				piece = playerWhite.askPiece();
				
				if (earlyTerminate == false) {				
					xy = playerWhite.askSquare();
					
					if (earlyTerminate == false) {
						board.move(piece, xy);
						proceed = board.getValidity();
						kingDown = Board.getKingDead();
					}
					else {
						proceed=true;
					}
					
				}
				else {
					proceed=true;
				}

			}
			
			if ((earlyTerminate == false)&&(kingDown == false)) {
				
				turn++;
				System.out.println("\nTurn "+turn+" Summary");
				board.update();
				board.draw();
				proceed = false;	
				
				//Black's turn
				while (proceed == false) {
					
					piece = playerBlack.askPiece();
					
					if (earlyTerminate == false) {
						xy = playerBlack.askSquare();
						
						if (earlyTerminate == false) {
							board.move(piece, xy);
							proceed = board.getValidity();
							kingDown = Board.getKingDead();
						}
						else {
							proceed=true;
						}
						
					}
					else {
						proceed=true;
					}

				}
				proceed = false;	
				turn++;
			}	
			
		}
		
		if (earlyTerminate == true) {
			System.out.println("\n\nProgram Terminated");
		}
		else {
			board.update();
			board.draw();
			System.out.println("\nCheckmate!");
			System.out.println(Board.getWinner()+" wins after "+turn+" turns");
			System.out.println("gg");
		
		}
	}
}
