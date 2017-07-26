
public class Board {
	
	static int[][] boardCoordinates = new int[8][8];
	static boolean[][] squareOccupied = new boolean[8][8];
	static Piece[][] squareOccupiedBy = new Piece[8][8];
	static String[][] squareOccupiedByName = new String[8][8];
	private static boolean moveValidity;
	private static boolean kingDead;
	private static String winner = "";
	
	
	//Creating White Pieces
	Piece[] whitePieces = new Piece[8];
	Piece[] whitePawns = new Pawn[8];
	
	//Creating Black Pieces 
	Piece[] blackPieces = new Piece[8];
	Piece[] blackPawns = new Pawn[8];
	
	
	public void create() {
		
		//Initializing White Pieces
		whitePieces[0] = new Rook("R1 ",0,0,"White");
		whitePieces[1] = new Knight("N1 ",1,0,"White");
		whitePieces[2] = new Bishop("B1 ",2,0,"White");
		whitePieces[3] = new King("K1 ",3,0,"White");
		whitePieces[4] = new Queen("Q1 ",4,0,"White");
		whitePieces[5] = new Bishop("B2 ",5,0,"White"); 
		whitePieces[6] = new Knight("N2 ",6,0,"White");
		whitePieces[7] = new Rook("R2 ",7,0,"White");
		
		//Initializing Black Pieces
		blackPieces[0] = new Rook("R1'",0,7,"Black");
		blackPieces[1] = new Knight("N1'",1,7,"Black");
		blackPieces[2] = new Bishop("B1'",2,7,"Black");
		blackPieces[3] = new King("K1'",3,7,"Black");
		blackPieces[4] = new Queen("Q1'",4,7,"Black");
		blackPieces[5] = new Bishop("B2'",5,7,"Black");
		blackPieces[6] = new Knight("N2'",6,7,"Black");
		blackPieces[7] = new Rook("R2'",7,7,"Black");
		
		//Pawns
		for (int i = 0;i<8;i++) {
			whitePieces[i].setDead(false);
			blackPieces[i].setDead(false);
			whitePawns[i] = new Pawn("P"+(i+1)+" ",i,1,"White");
			whitePawns[i].setDead(false);
			blackPawns[i] = new Pawn("P"+(i+1)+"'",i,6,"Black");
			blackPawns[i].setDead(false);
		}
		
	}
	
	public void update() {
		
		int x,y = 0;
		
		//Nullify the whole board (removes the need to check every square for a piece)
		// i is the x coordinate, j is the y coordinate
		for (int i = 0;i<8;i++) {
			for (int j = 0;j < 8;j++) {
				squareOccupied[j][i] = false;
				squareOccupiedBy[j][i] = null;
				squareOccupiedByName[j][i] = "   ";
			}
		}
		
		for (int i = 0;i<8;i++){
			
			//White pieces
			if (whitePieces[i].getDead() == false) {
				x = whitePieces[i].getX();
				y = whitePieces[i].getY();
				squareOccupied[x][y] = true;
				squareOccupiedBy[x][y] = whitePieces[i];
				squareOccupiedByName[x][y] = whitePieces[i].getName();
			}
			//White pawns
			if (whitePawns[i].getDead() == false) {
				x = whitePawns[i].getX();
				y = whitePawns[i].getY();
				squareOccupied[x][y] = true;
				squareOccupiedBy[x][y] = whitePawns[i];
				squareOccupiedByName[x][y] = whitePawns[i].getName();
			}
			//Black pieces
			if (blackPieces[i].getDead() == false) {
				x = blackPieces[i].getX();
				y = blackPieces[i].getY();
				squareOccupied[x][y] = true;
				squareOccupiedBy[x][y] = blackPieces[i];
				squareOccupiedByName[x][y] = blackPieces[i].getName();
			}			
			//Black pawns
			if (blackPawns[i].getDead() == false) {
				x = blackPawns[i].getX();
				y = blackPawns[i].getY();
				squareOccupied[x][y] = true;
				squareOccupiedBy[x][y] = blackPawns[i];
				squareOccupiedByName[x][y] = blackPawns[i].getName();
			}		
		}
		
	}
	
	public void draw() {
		
		System.out.println();
		for (int y = 7; y>=0;y--) {
			System.out.println("---------------------------------------------------------");
			for (int x = 0;x<8;x++) {
				System.out.print("|  "+squareOccupiedByName[x][y]+" ");
			}
			System.out.print("|"+'\n');
		}
		System.out.println("---------------------------------------------------------");
		
	}

	public void move(String piece, int[] xy) {
		
		boolean check = false; 
		boolean isValid = false;
		int i = 0;
		
		
		while (check == false) {
			if (piece.equals(whitePieces[i].getName())) {
				check = true;
				isValid = process(whitePieces[i], xy, whitePieces[i].getPossibleSquares(whitePieces[i].getX(), whitePieces[i].getY(), "White"), whitePieces[i].getType());
				if (isValid == true) {
					whitePieces[i].setX(xy[0]);
					whitePieces[i].setY(xy[1]);
				}
				else {
					System.out.println("Invalid move\n");
					return;
				}
			} 
			else if (piece.equals(whitePawns[i].getName())) {
				check = true;
				isValid = process(whitePawns[i], xy, whitePawns[i].getPossibleSquares(whitePawns[i].getX(), whitePawns[i].getY(), "White"), whitePawns[i].getType());
				if (isValid == true) {
					whitePawns[i].setX(xy[0]);
					whitePawns[i].setY(xy[1]);
				}
				else {
					System.out.println("Invalid move\n");
					return;
				}
			}
			else if (piece.equals(blackPieces[i].getName())) {
				check = true;
				isValid = process(blackPieces[i], xy, blackPieces[i].getPossibleSquares(blackPieces[i].getX(), blackPieces[i].getY(), "Black"), blackPieces[i].getType());
				if (isValid == true) {
					blackPieces[i].setX(xy[0]);
					blackPieces[i].setY(xy[1]);
				}
				else {
					System.out.println("Invalid move\n");
					return;
				}
			}
			else if (piece.equals(blackPawns[i].getName())){
				check = true;
				isValid = process(blackPawns[i], xy, blackPawns[i].getPossibleSquares(blackPawns[i].getX(), blackPawns[i].getY(), "Black"), blackPawns[i].getType());
				if (isValid == true) {
					blackPawns[i].setX(xy[0]);
					blackPawns[i].setY(xy[1]);
				}
				else {
					System.out.println("Invalid move\n");
					return;
				}
			}
			i++;
		}
		

		
	}
	
	Boolean process(Piece piece, int[] xy, String[] possibleSquares, String type) {
		
		moveValidity = false;
		boolean check = false;
		int i = 0;		

		//Checks whether the players square choice matches a possible square
		while ((check == false) && (i<possibleSquares.length)) {
			if ((Board.getSquareString(xy[0], xy[1])).equals(possibleSquares[i])) {
				check = true;
			}
			else {
				i++;
			}
		}
		System.out.println();
		
		if (check == false) {
			moveValidity = false;
		}
		else {
			
			//Checking for occupancy of input square
			if (squareOccupied[xy[0]][xy[1]] == true) {
				
				//Check whether the foreign piece is in the same team or not
				if (squareOccupiedBy[xy[0]][xy[1]].getType().equals(piece.getType())) {
					
					//same team
					moveValidity = false;
				}
				else { //opponent capture
					moveValidity = true;
					squareOccupiedBy[xy[0]][xy[1]].setDead(true);
					System.out.println(piece.getName()+" to "+Board.getSquareString(xy[0], xy[1]));
					System.out.println(squareOccupiedBy[xy[0]][xy[1]].getName()+" captured!");
					//Check for check-mate
					if ((squareOccupiedBy[xy[0]][xy[1]].getClass().toString()).equals("class King")) {
						kingDead = true;
						setWinner(piece.getType());
					}
				}
			}
			else {
				//Empty square
				moveValidity = true;
				System.out.println(piece.getName()+" to "+Board.getSquareString(xy[0], xy[1]));
			} 
		}
		
		return moveValidity;
		
		/* Must consider:
		 * - whether the square is occupied by a friendly piece or foe
		 * - obstacle pieces
		 * - isDead?
		 * - King killed?
		 */
	}

	public boolean getValidity() {
		return moveValidity;
	}
	
	public static boolean getKingDead() {
		return kingDead;
	}

	public static String getWinner() {
		return winner;
	}

	public static void setWinner(String winner) {
		Board.winner = winner;
	}

	public String[] getPieceNames() {

		
		String[] pieceNames = new String[32];
		int g = 0;
		
		for (int i = 0;i < 8;i++) {
			pieceNames[g] = whitePieces[i].getName();
			g++;
		}
		for (int i = 0;i < 8;i++) {
			pieceNames[g] = whitePawns[i].getName();
			g++;
		}
		for (int i = 0;i < 8;i++) {
			pieceNames[g] = blackPieces[i].getName();
			g++;
		}
		for (int i = 0;i < 8;i++) {
			pieceNames[g] = blackPawns[i].getName();
			g++;
		}
		
		return pieceNames;
	}


	public static String getSquareString(int squareX, int squareY) {
		
		String x = "", y = "", squareName = "";
		
		//x square conversion
		switch (squareX)  {
		case 0: x = "A";
		break;
		case 1: x = "B";
		break;
		case 2: x = "C";
		break;
		case 3: x = "D";
		break;
		case 4: x = "E";
		break;
		case 5: x = "F";
		break;
		case 6: x = "G";
		break;
		case 7: x = "H";
		break;
		}
		
		//y square conversion
		y = ""+(squareY + 1);
		
		squareName = x+y;
		
		return squareName;
	}
}
