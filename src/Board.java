
public class Board {
	
	static int[][] boardCoordinates = new int[8][8];
	static boolean[][] squareOccupied = new boolean[8][8];
	static Piece[][] squareOccupiedBy = new Piece[8][8];
	
	//Player White Pieces
	Piece R1 = new Rook("R1 ",0,0);
	Piece N1 = new Knight("N1 ",1,0);
	Piece B1 = new Bishop("B1 ",2,0);
	Piece K1 = new King("K1 ",3,0);
	Piece Q1 = new Queen("Q1 ",4,0);
	Piece B2 = new Bishop("B2 ",5,0);
	Piece N2 = new Knight("N2 ",6,0);
	Piece R2 = new Rook("R2 ",7,0);
	Piece[] WhitePawns = new Pawn[8];
	
	//Player Black Pieces
	Piece R1_ = new Rook("R1'",0,7);
	Piece N1_ = new Knight("N1'",1,7);
	Piece B1_ = new Bishop("B1'",2,7);
	Piece K1_ = new King("K1'",3,7);
	Piece Q1_ = new Queen("Q1'",4,7);
	Piece B2_ = new Bishop("B2'",5,7);
	Piece N2_ = new Knight("N2'",6,7);
	Piece R2_ = new Rook("R2'",7,7);
	Piece[] BlackPawns = new Pawn[8];
	
	public void create() {
		
		//Player White Pawns
		for (int i = 0;i<7;i++) {
			WhitePawns[i] = new Pawn("P"+(i+1)+" ",i,1);
			BlackPawns[i] = new Pawn("P"+(i+1)+"'",i,6);
		}
		
	}
	
	public void update() {
		for (int y = 0;y<7;y++) {
			for (int x = 0;x < 7;x++) {
				squareOccupied[x][y] = false;
				squareOccupiedBy[x][y] = null;
			}
		}
		
		
	}
	
	public void draw() {
		System.out.println("---------------------------------------------------------");
		System.out.println("|  C1' |  K1' |  B1' |  QN' |  KG' |  B2' |  K2' |  C2' |");
		System.out.println("---------------------------------------------------------");
		System.out.println("|  P1' |  P2' |  P3' |  P4' |  P5' |  P6' |  P7' |  P8' |");
		System.out.println("---------------------------------------------------------");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("---------------------------------------------------------");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("---------------------------------------------------------");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("---------------------------------------------------------");
		System.out.println("|      |      |      |      |      |      |      |      |");
		System.out.println("---------------------------------------------------------");
		System.out.println("|  P1  |  P2  |  P3  |  P4  |  P5  |  P6  |  P7  |  P8  |");
		System.out.println("---------------------------------------------------------");
		System.out.println("|  C1  |  K1  |  B1  |  QN  |  KG  |  B2  |  K2  |  C2  |");
		System.out.println("---------------------------------------------------------");
	}
	
}
