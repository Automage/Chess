import java.util.ArrayList;

public class Knight extends Piece{

	public Knight(String name, int x, int y, String type) {
		super(name,x,y,type, true);
	}

	@Override
	public String[] getPossibleSquares(int x, int y, String type) {
		
		ArrayList<String> possibleSquares = new ArrayList<String>();
		//Clone to modify allows the reference xy to stay constant
		int xMod = x;
		int yMod = y;
		
		
		/* 		  1 | 2
		 * 	8		|		3
		 * 	-	- 	N	-	-
		 * 	7		|		4
		 * 		  6	| 5
		 */
		
		//1
		if ((y<=5) && (x>=1)) {
			xMod = x;
			yMod = y;
			
			xMod = xMod - 1;
			yMod = yMod + 2;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//2
		if ((y<=5) && (x<=6)) {
			xMod = x;
			yMod = y;
			
			xMod = xMod + 1;
			yMod = yMod + 2;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//3
		if ((y<=6) && (x<=5)) {
			xMod = x;
			yMod = y;
			
			xMod = xMod + 2;
			yMod = yMod + 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//4
		if ((y>=1) && (x<=5)) {
			xMod = x;
			yMod = y;
			
			xMod = xMod + 2;
			yMod = yMod - 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//5
		if ((y>=2) && (x<=6)) {
			xMod = x;
			yMod = y;
			
			xMod = xMod + 1;
			yMod = yMod - 2;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//6
		if ((y>=2) && (x>=1)) {
			xMod = x;
			yMod = y;
			
			xMod = xMod - 1;
			yMod = yMod - 2;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//7
		if ((y>=1) && (x>=2)) {
			xMod = x;
			yMod = y;
			
			xMod = xMod - 2;
			yMod = yMod - 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//8
		if ((y<=6) && (x>=2)) {
			xMod = x;
			yMod = y;
			
			xMod = xMod - 2;
			yMod = yMod + 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		String[] possibleSquaresArray = new String[possibleSquares.size()];
		for (int i = 0;i<possibleSquares.size();i++) {
			possibleSquaresArray[i] = possibleSquares.get(i);
		}
		return possibleSquaresArray;
	}

}
