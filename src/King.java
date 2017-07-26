import java.util.ArrayList;

public class King extends Piece{

	public King(String name, int x, int y, String type) {
		super(name,x,y,type);
	}

	@Override
	public String[] getPossibleSquares(int x, int y, String type) {
		
		ArrayList<String> possibleSquares = new ArrayList<String>();
		//Clone to modify allows the reference xy to stay constant
		int xMod = x;
		int yMod = y;
		
		/*
		 * 		8	1	2
		 * 		7	K 	3
		 * 		6	5	4
		 */
		
		//1
		if (y<=6) {
			xMod = x;
			yMod = y;
			
			yMod = yMod + 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//3
		if (x<=6) {
			xMod = x;
			yMod = y;
			
			xMod = xMod + 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//5
		if (y>=1) {
			xMod = x;
			yMod = y;
			
			yMod = yMod - 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//7
		if (x>=1) {
			xMod = x;
			yMod = y;
			
			xMod = xMod - 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//2
		if ((y<=6) && (x<=6)) {
			xMod = x;
			yMod = y;
			
			yMod = yMod + 1;
			xMod = xMod + 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//4
		if ((y>=1) && (x<=6)) {
			xMod = x;
			yMod = y;
			
			yMod = yMod - 1;
			xMod = xMod + 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//6
		if ((y>=1) && (x>=1)) {
			xMod = x;
			yMod = y;
			
			yMod = yMod - 1;
			xMod = xMod - 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		//8
		if ((y<=6) && (x>=1)) {
			xMod = x;
			yMod = y;
			
			yMod = yMod + 1;
			xMod = xMod - 1;
			possibleSquares.add(Board.getSquareString(xMod, yMod));
		}
		
		String[] possibleSquaresArray = new String[possibleSquares.size()];
		for (int i = 0;i<possibleSquares.size();i++) {
			possibleSquaresArray[i] = possibleSquares.get(i);
		}
		return possibleSquaresArray;
	}

}
