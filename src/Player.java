import java.util.Scanner;

public class Player {
	
	//Black or White
	String type = "";
	
	//Scanner
	Scanner scanner = new Scanner(System.in);
	
	//Array holding all Piece Names
	static String[] pieceNames = new String[32];
	
	
	public Player(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String askPiece(){
		
		String piece = "";
		boolean check = false;
		int a = 0;
		
		System.out.println(this.getType() + "'s turn");
		
		//Input for piece
		while (check == false) {
			System.out.println("Piece: ");
			piece = scanner.nextLine();
			
			if (this.getType().equals("White")) {
				for (int i = 0;i<16;i++) {
					if (((piece+" ").equalsIgnoreCase(pieceNames[i]))||(piece.equalsIgnoreCase(pieceNames[i]))) {
						check = true;
					}
				}
			}
			else {
				for (int i = 16;i<32;i++) {
					if ((piece).equalsIgnoreCase(pieceNames[i])) {
						check = true;
					}
				}
			}	
			
			if (check == false) {
				System.out.println("Invalid piece"+'\n');
			}
		}
		
		return piece;	
		
	}

	public int[] askSquare(){
		
		int x = 0, y = 0;
		boolean check = false;
		//have to create an array to avoid the problem of returning two values
		int[] xy = new int[2];
		String input = "";
	
		//Input + Validation
		while (check == false) {
			
			System.out.println("Square: ");
			input = (scanner.nextLine().toUpperCase());
			
			//Validation for array length
			if ((input.length() == 2)||(input.length() == 3)){
				
				//increasing array length to avoid array out of bounds error
				if (input.length() == 2) {
					input = input + " ";
				}
				
				char[] splitInput = input.toCharArray();
				
				//Validation for the first character (the x letter coordinate)
				switch (splitInput[0]) {
					case 'A': check = true; x = 0;
					break;
					case 'B': check = true; x = 1;
					break;
					case 'C': check = true; x = 2;
					break;
					case 'D': check = true; x = 3;
					break;
					case 'E': check = true; x = 4;
					break;
					case 'F': check = true; x = 5;
					break;
					case 'G': check = true; x = 6;
					break;
					case 'H': check = true; x = 7;
					break;		
				}
				
				if (check == true) {
					//Second character validation (y axis number)
					if ((Character.getNumericValue(splitInput[1])>0)&&(Character.getNumericValue(splitInput[1])<9)){		
						y= Character.getNumericValue(splitInput[1]-1);
						check = true;
						//Third character validation (' for black pieces)
						if ((this.getType().equals("Black"))&&(!((Character.toString(splitInput[2])).equals("'")))){
							check = false;
							System.out.println("Invalid square");
						}
						else if (!((Character.toString(splitInput[2])).equals(" "))) {
							check = false;
							System.out.println("Invalid square");
						}
					}
					else {
						check = false;
						System.out.println("Invalid square");
					}
				} 
				else {
					check = false;
					System.out.println("Invalid square");
				}
				
			}
			else {
				check = false;
				System.out.println("Invalid square");
			}
			
			
		}
		
		//Filling and returning the array
		xy[0]=x;
		xy[1]=y;
		return xy;
		
	}	
	
}	

