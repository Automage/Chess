import java.util.ArrayList;

public class Rook extends Piece{

	public Rook(String name, int x, int y, String type) {
		super(name,x,y,type,false);
	}

	@Override
	public String[] getPossibleSquares(int x, int y, String type) {
		
		ArrayList<String> possibleSquares = new ArrayList<String>();
		//Clone to modify allows the reference xy to stay constant
		int xMod = x;
		int yMod = y;
		
		/*			1
		 * 			|
		 * 	4 -	- -	R - - - 2
		 * 			|
		 * 			3
		 */			
		
		for (int i = 0; i<8;i++) {
			
			//2 and 4
			if (!(i==x)) {
				xMod = x;
				yMod = y;
				
				xMod = i;
				possibleSquares.add(Board.getSquareString(xMod,yMod)); 
			}
			
			//1 and 3
			if (!(i==y)) {
				xMod = x;
				yMod = y;
				
				yMod = i;
				possibleSquares.add(Board.getSquareString(xMod,yMod)); 
			}
		}
		
		String[] possibleSquaresArray = new String[possibleSquares.size()];
		for (int i = 0;i<possibleSquares.size();i++) {
			possibleSquaresArray[i] = possibleSquares.get(i);
		}
		return possibleSquaresArray;
	}

}
