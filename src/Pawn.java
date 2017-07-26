import java.util.*;

public class Pawn extends Piece{

	public Pawn(String name, int x, int y, String type) {
		super(name,x,y,type);
	}

	@Override
	public String[] getPossibleSquares(int x, int y, String type) {
		
		ArrayList<String> possibleSquares = new ArrayList<String>();
		//Clone to modify allows the reference xy to stay constant
		int xMod = x;
		int yMod = y;
		
		if (type.equals("White")) { //For white pawns
			//Checks if pawn is on the 8th y row
			if (y<7) {
				yMod = yMod+1;
				possibleSquares.add(Board.getSquareString(xMod,yMod));
				
				//Checks if the pawn can capture diagonal left by checking if it is on the A x column
				if (x>0) {
					xMod = x;
					yMod = y;
					
					xMod = xMod - 1;
					yMod = yMod + 1;
					possibleSquares.add(Board.getSquareString(xMod,yMod));
				}
				
				//Checks if the pawn can capture diagonal right by checking if it is on the H x column
				if (x<7) {
					xMod = x;
					yMod = y;
					
					xMod = xMod + 1;
					yMod = yMod + 1;
					possibleSquares.add(Board.getSquareString(xMod,yMod));
				}
			}
			
		}
		else if (type.equals("Black")) { //For black pawns
			
			//Checks if pawn is on the 1st y row
			if (y>0) {
				yMod = yMod - 1;
				possibleSquares.add(Board.getSquareString(xMod,yMod));
				
				//Checks if the pawn can capture diagonal left by checking if it is on the A x column
				if (x>0) {
					xMod = x;
					yMod = y;
					
					xMod = xMod - 1;
					yMod = yMod - 1;
					possibleSquares.add(Board.getSquareString(xMod,yMod));
				}
				
				//Checks if the pawn can capture diagonal right by checking if it is on the H x column
				if (x<7) {
					xMod = x;
					yMod = y;
					
					xMod = xMod + 1;
					yMod = yMod - 1;
					possibleSquares.add(Board.getSquareString(xMod,yMod));
				}
			}
		}
		
		String[] possibleSquaresArray = new String[possibleSquares.size()];
		for (int i = 0;i<possibleSquares.size();i++) {
			possibleSquaresArray[i] = possibleSquares.get(i);
		}
		return possibleSquaresArray;
	}

}
