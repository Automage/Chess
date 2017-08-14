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
			System.out.println("   ---------------------------------------------------------");
			System.out.print(" "+(y+1)+" ");
			for (int x = 0;x<8;x++) {
				System.out.print("|  "+squareOccupiedByName[x][y]+" ");
			}
			System.out.print("|"+'\n');
		}
		System.out.println("   ---------------------------------------------------------");
		System.out.println("      A      B      C      D       E      F      G      H   \n");
		
	}

	public void move(String piece, int[] xy) {
		
		boolean check = false; 
		boolean isValid = false;
		int i = 0;
		
		
		while (check == false) {
			if (piece.equals(whitePieces[i].getName())) {
				check = true;
				isValid = process(whitePieces[i], xy);
				if (isValid == true) {
					whitePieces[i].setX(xy[0]);
					whitePieces[i].setY(xy[1]);
				}
				else {
					System.out.println("Retry\n");
					return;
				}
			} 
			else if (piece.equals(whitePawns[i].getName())) {
				check = true;
				isValid = process(whitePawns[i], xy);
				if (isValid == true) {
					whitePawns[i].setX(xy[0]);
					whitePawns[i].setY(xy[1]);
				}
				else {
					System.out.println("Retry\n");
					return;
				}
			}
			else if (piece.equals(blackPieces[i].getName())) {
				check = true;
				isValid = process(blackPieces[i], xy);
				if (isValid == true) {
					blackPieces[i].setX(xy[0]);
					blackPieces[i].setY(xy[1]);
				}
				else {
					System.out.println("Retry\n");
					return;
				}
			}
			else if (piece.equals(blackPawns[i].getName())){
				check = true;
				isValid = process(blackPawns[i], xy);
				if (isValid == true) {
					blackPawns[i].setX(xy[0]);
					blackPawns[i].setY(xy[1]);
				}
				else {
					System.out.println("Retry\n");
					return;
				}
			}
			i++;
		}
		

		
	}
	
	Boolean process(Piece piece, int[] xy) {
		
		moveValidity = false;
		String[] possibleSquares = piece.getPossibleSquares(piece.getX(), piece.getY(), piece.getType());
		boolean inputCheck = false;
		int i = 0;		

		//Checks whether the players square choice matches a possible square
		while ((inputCheck == false) && (i<possibleSquares.length)) {
			if ((Board.getSquareString(xy[0], xy[1])).equals(possibleSquares[i])) {
				inputCheck = true;
			}
			else {
				i++;
			}
		}
		System.out.println();
		
		//Piece move rule check
		if (inputCheck == false) {
			//Inputed square doesn't match with a possible square
			moveValidity = false;
			System.out.println("Invalid Square");
		}
		else {
					
			//Other checks
			
			//Occupancy Check
			if (squareOccupied[xy[0]][xy[1]] == true) { //Non-empty Square
				
				//Team (Friendly/Opponent) check
				if (squareOccupiedBy[xy[0]][xy[1]].getType().equals(piece.getType())) { //Same (friendly) team	
					moveValidity = false;
					System.out.println("Square Blocked By Friendly Piece");
				}
				else { //Opponent team
					
					moveValidity = true;
					
					//Path Clear check
					if (obstacleCheck(piece,xy) == true) {
						moveValidity = true;
						System.out.println(piece.getName()+" to "+Board.getSquareString(xy[0], xy[1]));
						
						//Capture
						squareOccupiedBy[xy[0]][xy[1]].setDead(true);
						System.out.println(squareOccupiedBy[xy[0]][xy[1]].getName()+" captured!");
						
						//Check for check-mate
						if ((squareOccupiedBy[xy[0]][xy[1]].getClass().toString()).equals("class King")) {
							kingDead = true;
							setWinner(piece.getType());
						}
						
					}
					else {
						//Path blocked
						moveValidity = false;
					}
					
				}
				
			}
			else { //Empty Square
				
				//Path Clear check
				if (obstacleCheck(piece,xy) == true) {
					moveValidity = true;
					System.out.println(piece.getName()+" to "+Board.getSquareString(xy[0], xy[1]));
					
				}
				else {
					//Path blocked
					moveValidity = false;
				}

			}	
			
		}
		
		
		return moveValidity;
		
		/* Must consider:
		 * - whether the square is occupied by a friendly piece or foe |
		 * - obstacle pieces
		 * - isDead? |
		 * - King killed? |
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


	public static int[] getSquareCoordinate(String squareString) {
		
		int[] square  = new int[2];
		
		//Retrieve x
		
		switch (squareString.charAt(0))  {
		case 'A': square[0] = 0;
		break;
		case 'B': square[0] = 1;
		break;
		case 'C': square[0] = 2;
		break;
		case 'D': square[0] = 3;
		break;
		case 'E': square[0] = 4;
		break;
		case 'F': square[0] = 5;
		break;
		case 'G': square[0] = 6;
		break;
		case 'H': square[0] = 7;
		break;
		}
		
		//Retrieve y
		
		square[1] = squareString.charAt(1)+0;
		
		return square;
	}
	
	private boolean obstacleCheck(Piece piece, int xy[]) {
		
		//For everything other than Knights (or jumping pieces)
		
		boolean obstacleCheck = false;
		int obstacle=0;
		
		if (piece.isCanJump()==false) {
			
			//1 = positive direction (right/up), -1 = negative direction (left/down), 0 = no movement in that axis
			int dirX,dirY;
			
			
			//dirX
			if (piece.getX()<xy[0]) {
				dirX = 1;
			}
			else if (piece.getX()>xy[0]) {
				dirX = -1;
			}
			else {
				dirX = 0;
			}
			
			//dirY
			if (piece.getY()<xy[1]) {
				dirY = 1;
			}
			else if (piece.getY()>xy[1]) {
				dirY = -1;
			}
			else {
				dirY = 0;
			}
			
			
			if(dirX != 0) { //Every movement but vertical				
				
				if (squareOccupied[piece.getX()+(dirX)][piece.getY()+(dirY)] == true) { 
					
					if (squareOccupiedBy[piece.getX()+(dirX)][piece.getY()+(dirY)].getType().equals(piece.getType())) {
						obstacle++;
						obstacleCheck=false;
						System.out.println("Obstacle Detected");
					}
					else {
						obstacleCheck = true; //Opponent can be captured
					}
				
				}
				else {
					
					for (int b =1 ;b< Math.abs(piece.getX()-xy[0]) - 1;++b) { 
						if (squareOccupied[piece.getX()+(dirX*b)][piece.getY()+(dirY*b)] == true) { 
							obstacle++;
							obstacleCheck=false;
							System.out.println("Obstacle Detected");
						}
						
					}
				}
			}
			else { //Vertical only movement
				
				if (squareOccupied[piece.getX()+(dirX)][piece.getY()+(dirY)] == true) { 
						
					if (squareOccupiedBy[piece.getX()+(dirX)][piece.getY()+(dirY)].getType().equals(piece.getType())) {
						obstacle++;
						obstacleCheck=false;
						System.out.println("Obstacle Detected");
					}
					else {
						obstacleCheck = true; //Opponent can be captured
					}
					
				}
				else {
					
					for (int b =1 ;b< Math.abs(piece.getY()-xy[1]) - 1;++b) { 
						if (squareOccupied[piece.getX()+(dirX*b)][piece.getY()+(dirY*b)] == true) { 
							obstacle++;
							obstacleCheck=false;
							System.out.println("Obstacle Detected");
						}
						
					}
				}
					
			}
			
		}
		else {
			obstacleCheck = true; 
		}
		
		if (obstacle ==0) {
			obstacleCheck = true;
		}

		return obstacleCheck;
		
	}
	
}
