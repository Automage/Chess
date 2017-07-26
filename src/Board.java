
public class Board {
	
	static int[][] boardCoordinates = new int[8][8];
	static boolean[][] squareOccupied = new boolean[8][8];
	static Piece[][] squareOccupiedBy = new Piece[8][8];
	static String[][] squareOccupiedByName = new String[8][8];
	private static boolean moveValidity;
	
	//Creating White Pieces
	Piece[] whitePieces = new Piece[8];
	Piece[] whitePawns = new Pawn[8];
	
	//Creating Black Pieces 
	Piece[] blackPieces = new Piece[8];
	Piece[] blackPawns = new Pawn[8];
	
	
	public void create() {
		
		//Initializing White Pieces
		whitePieces[0] = new Rook("R1 ",0,0);
		whitePieces[1] = new Knight("N1 ",1,0);
		whitePieces[2] = new Bishop("B1 ",2,0);
		whitePieces[3] = new King("K1 ",3,0);
		whitePieces[4] = new Queen("Q1 ",4,0);
		whitePieces[5] = new Bishop("B2 ",5,0); 
		whitePieces[6] = new Knight("N2 ",6,0);
		whitePieces[7] = new Rook("R2 ",7,0);
		
		//Initializing Black Pieces
		blackPieces[0] = new Rook("R1'",0,7);
		blackPieces[1] = new Knight("N1'",1,7);
		blackPieces[2] = new Bishop("B1'",2,7);
		blackPieces[3] = new King("K1'",3,7);
		blackPieces[4] = new Queen("Q1'",4,7);
		blackPieces[5] = new Bishop("B2'",5,7);
		blackPieces[6] = new Knight("N2'",6,7);
		blackPieces[7] = new Rook("R2'",7,7);
		
		//Pawns
		for (int i = 0;i<8;i++) {
			whitePawns[i] = new Pawn("P"+(i+1)+" ",i,1);
			blackPawns[i] = new Pawn("P"+(i+1)+"'",i,6);
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
			x = whitePieces[i].getX();
			y = whitePieces[i].getY();
			squareOccupied[x][y] = true;
			squareOccupiedBy[x][y] = whitePieces[i];
			squareOccupiedByName[x][y] = whitePieces[i].getName();
			//White pawns
			x = whitePawns[i].getX();
			y = whitePawns[i].getY();
			squareOccupied[x][y] = true;
			squareOccupiedBy[x][y] = whitePawns[i];
			squareOccupiedByName[x][y] = whitePawns[i].getName();
			//Black pieces
			x = blackPieces[i].getX();
			y = blackPieces[i].getY();
			squareOccupied[x][y] = true;
			squareOccupiedBy[x][y] = blackPieces[i];
			squareOccupiedByName[x][y] = blackPieces[i].getName();
			//Black pawns
			x = blackPawns[i].getX();
			y = blackPawns[i].getY();
			squareOccupied[x][y] = true;
			squareOccupiedBy[x][y] = blackPawns[i];
			squareOccupiedByName[x][y] = blackPawns[i].getName();
		}
		
	}
	
	public void draw() {

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
				isValid = process(whitePieces[i], xy, whitePieces[i].getPossibleSquares(whitePieces[i].getX(), whitePieces[i].getY(), "White"));
				if (isValid == true) {
					whitePieces[i].setX(xy[0]);
					whitePieces[i].setY(xy[1]);
				}
				else {
					System.out.println("Invalid move");
					return;
				}
			} 
			else if (piece.equals(whitePawns[i].getName())) {
				check = true;
				isValid = process(whitePawns[i], xy, whitePawns[i].getPossibleSquares(whitePawns[i].getX(), whitePawns[i].getY(), "White"));
				if (isValid == true) {
					whitePawns[i].setX(xy[0]);
					whitePawns[i].setY(xy[1]);
				}
				else {
					System.out.println("Invalid move");
					return;
				}
			}
			else if (piece.equals(blackPieces[i].getName())) {
				check = true;
				isValid = process(blackPieces[i], xy, blackPieces[i].getPossibleSquares(blackPieces[i].getX(), blackPieces[i].getY(), "Black"));
				if (isValid == true) {
					blackPieces[i].setX(xy[0]);
					blackPieces[i].setY(xy[1]);
				}
				else {
					System.out.println("Invalid move");
					return;
				}
			}
			else if (piece.equals(blackPawns[i].getName())){
				check = true;
				isValid = process(blackPawns[i], xy, blackPawns[i].getPossibleSquares(blackPawns[i].getX(), blackPawns[i].getY(), "Black"));
				if (isValid == true) {
					blackPawns[i].setX(xy[0]);
					blackPawns[i].setY(xy[1]);
				}
				else {
					System.out.println("Invalid move");
					return;
				}
			}
			i++;
		}
		
		
	}
	
	Boolean process(Piece piece, int[] xy, String[] possibleSquares) {
		
		moveValidity = false;
		boolean check = false;
		int i = 0;
		
		//Monitoring purposes
		for (int a = 0; a<possibleSquares.length;a++) {
			System.out.println(possibleSquares[a]);
		}
		
		//Checks whether the players square choice matches a possible square
		while ((check == false) && (i<possibleSquares.length)) {
			if ((Board.getSquareString(xy[0], xy[1])).equals(possibleSquares[i])) {
				check = true;
			}
			else {
				i++;
			}
		}
		
		if (check == false) {
			moveValidity = false;
		}
		else {
			//rest of the checking
			moveValidity = true; 
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
