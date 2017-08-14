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
		
		System.out.println(this.getType() + "'s turn");
		
		//Input for piece
		while (check == false) {
			System.out.print("Piece: ");
			piece = (scanner.nextLine()).toUpperCase();
			
			if (!(piece.equalsIgnoreCase("end"))) {
				
				if (this.getType().equals("White")) {
					for (int i = 0;i<16;i++) {
						if ((piece+" ").equals(pieceNames[i])) {
							check = true;
							piece = piece + " ";
						}
						if (piece.equals(pieceNames[i])) {
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
					System.out.println("Invalid piece\n");
				}
				
			}
			else {
				Chess.setEarlyTerminate(true);
				check = true;
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
			
			System.out.print("Square: ");
			input = (scanner.nextLine().toUpperCase());
			
			if (!(input.equals("END"))) {
				
				//Validation for array length
				if ((input.length() == 2)){
				
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
						switch (splitInput[1]) {
							case '1': check = true; y = 0;
							break;
							case '2': check = true; y = 1;
							break;
							case '3': check = true; y = 2;
							break;
							case '4': check = true; y = 3;
							break;
							case '5': check = true; y = 4;
							break;
							case '6': check = true; y = 5;
							break;
							case '7': check = true; y = 6;
							break;
							case '8': check = true; y = 7;
							break;	
							default: 
								check = false; 
								System.out.println("Invalid square\n");
							break;
						}
						
					}
					else {
						check = false;
						System.out.println("Invalid square\n");
					}
					
				} 
				else {
					check = false;
					System.out.println("Invalid square\n");
				}
				
			}
			else { //END termination request
				check = true;
				Chess.setEarlyTerminate(true);
			}
		
		}
		
		xy[0]=x;
		xy[1]=y;
		return xy;
		
	}	
	
}	

