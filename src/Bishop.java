import java.util.ArrayList;

public class Bishop extends Piece{

	public Bishop(String name, int x, int y, String type) {
		super(name,x,y,type,false);
	}

	@Override
	public String[] getPossibleSquares(int x, int y, String type) {
		
		ArrayList<String> possibleSquares = new ArrayList<String>();
		int xCounter=0, yCounter=0;
		//Clone to modify allows the reference xy to stay constant
		int xMod = x;
		int yMod = y;
		
		/*		 4	   1
		 * 		  \	  /
		 * 			B 
		 * 		  /	  \
		 * 		 3	   2
		 */			
		
		
		//1 and 3
		
		//This section determines the maximum and minimum x and y coordinates when moving diagonally (gradient =1)
		int xMin=0,yMin=0,xMax=0,yMax=0;
		
		if (x>y){ //everything under the y=x line
			xMin= x-y;
			xMax= 7;
			yMin= 0;
			yMax = 7-xMin;
			
			xCounter = xMin;
			yCounter = yMin;
			
			for (xCounter = xMin; xCounter< xMax+1; xCounter++) {
				
				xMod = xCounter;
				yMod = yCounter;
				
				if (!((xMod == x) && (yMod==y))) {
					possibleSquares.add(Board.getSquareString(xMod,yMod));
				}
				
				yCounter++;
			}
		}
		else if (x<y) {//everything above the y=x line
			xMin= 0;			
			yMin= y-x;
			xMax= 7-yMin;
			yMax= 7;
			
			xCounter = xMin;
			yCounter = yMin;
			
			for (yCounter = yMin; yCounter< yMax+1; yCounter++) {
				xMod = xCounter;
				yMod = yCounter;
				
				if (!((xMod == x) && (yMod==y))) {
					possibleSquares.add(Board.getSquareString(xMod,yMod));
				}
				
				xCounter++;
			}	
		}
		else { //on the y=x line
			xMin = 0;
			yMin = 0;
			xMax= 7;
			yMax= 7;
			
			xCounter = xMin;
			yCounter = yMin;
			
			for (xCounter = xMin; xCounter< xMax+1; xCounter++) {
				xMod = xCounter;
				yMod = yCounter;
				
				if (!((xMod == x) && (yMod==y))) {
					possibleSquares.add(Board.getSquareString(xMod,yMod));
				}
				
				yCounter++;
			}	
			
		}
		
		
		//2 and 4
		
		//Min values represent the coordinate closest to the top left of the board
		//Max values represent the coordinate closest to the bottom right of the board
		
		xMin=0;yMin=0;xMax=0;yMax=0;xCounter=0;yCounter=0;xMod=0;yMod=0;
		
		if (y<7-x){ //everything under the y=7-x line
			xMin= 0;
			xMax= y+x;
			yMin= y+x;
			yMax = 0;
			
			xCounter = xMin;
			yCounter = yMin;
			
			for (xCounter = xMin; xCounter< xMax+1; xCounter++) {
				
				xMod = xCounter;
				yMod = yCounter;
				
				if (!((xMod == x) && (yMod==y))) {
					possibleSquares.add(Board.getSquareString(xMod,yMod));
				}
				
				yCounter--;
			}
		}
		else if (y>7-x) {//everything above the y=7-x line
			xMin= x-(7-y);
			xMax= 7;
			yMin= 7;
			yMax= y-(7-x);
			
			xCounter = xMin;
			yCounter = yMin;
			
			for (yCounter = yMin; yCounter> yMax-1; yCounter--) {
				xMod = xCounter;
				yMod = yCounter;
				
				if (!((xMod == x) && (yMod==y))) {
					possibleSquares.add(Board.getSquareString(xMod,yMod));
				}
				
				xCounter++;
			}	
		}
		else { //on the y=7-x line
			xMin = 0;
			yMin = 7;
			xMax= 7;
			yMax= 0;
			
			xCounter = xMin;
			yCounter = yMin;
			
			for (xCounter = xMin; xCounter< xMax+1; xCounter++) {
				xMod = xCounter;
				yMod = yCounter;
				
				if (!((xMod == x) && (yMod==y))) {
					possibleSquares.add(Board.getSquareString(xMod,yMod));
				}
				
				yCounter--;
			}	
			
		}
		
		
		String[] possibleSquaresArray = new String[possibleSquares.size()];
		for (int i = 0;i<possibleSquares.size();i++) {
			possibleSquaresArray[i] = possibleSquares.get(i);
		}
		return possibleSquaresArray;
		
	}
}
