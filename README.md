# Chess
Trying my hand at building Chess in Java using my knowledge of OOP so far. 

Pre-Completion 1.0:
- Abstract class 'Piece' created 
- Pawn, Rook, Knight, Bishop, King and Queen classes created and extends 'Piece' with parameters name, x, y, and isDead
- Board class created with methods create(), update(), and draw()
- Pieces had to be intialised outside any Board methods, as otherwise they would be avaliable only to the method itself (the public modifier doesnt work oh well)
- Placeholder text chessboard output added to the draw() method

Pre-Completion  1.1:
- Converted individual piece objects into an array list (in order to help with with looping later on)
- Introduced array squareOccupiedByName to store either the piece name or a placeholder ("   "). Unfortunately could not use squareOccupiedBy.getName(), as that would require creating a new Piece subclass solely for the purpose of a placeholder for the square. Using squareOccupiedBy.getName() when the piece is null will return an null pointer error.
- Updated the board.draw() method with a basic board (that outputs the squareOccupiedByName string for each respective square)
- Working board.draw() method added (basic without axis labelling)
- Decided not to update the bin folder every version due to the inability to update .java files on Github. TODO Update bin folder

Pre-Completion 1.2:
- Introduced user input with the new class 'Player'
- Primarily used for player input and validation (linguistic validation and not game validation [e.g. illegal moves will not be handled])
- Added 2 major methods: askPiece() and askSquare. Both will prompt for input and return a string and an int array(containing an x and y coordinate) respectively.
- Validations include letter, number, and length checks (also checks for the ' character for black pieces)
- Placeholder move() method created in the Board class

Pre-Completion 1.3:
- Added a temporary loop to test player input
- Created a process() method placeholder. Will be used to call the getPossibleSquare() from the piece's respective class (which only produces potential squares based on the piece's location, with no respect for other pieces). The process() method will take the potential squares and eliminate squares based on factors such as: square occupancy, obstacle pieces, whether the piece is captured or not, or even if a king is killed
- Added a move() method which uses the process() placeholder method to update the piece's square location (update() must be used after to translate this change for the draw() method).
- Improved askSquare() validation (stopped inputs such as 'eg' being validated [and all other instances where the first digit is {A-E} but the second character being disregarded])
- Removed the array length validation for being 3 characters long (as all squares can be expressed with 2 characters) [Silly Mistake]

Pre-Completion 1.4:
- Created abstract method getPossibleSquares() in the Piece Superclass. Will be used to produce possible squares for each piece depending on their position on the board
- So far the Pawn, King, and Knight class have overriden the getPossibleSquares method. Notice these pieces are the ones with limited movement capabilties, the next update will focus on the pieces with unlimited movement capabilties (i.e. Queen, Bishop and Rook)
- The getPossibleSquares() now takes parameters (x,y,type[black or white])
- Updated the process() method with a basic validation that checks whether the inputted square matches a square from the possibleSquares array (obtained from the getPossibleSquares() method (in the move() method) from the respective Piece class)
- Added a temporary monitor that outputs all the values of the possibleSquares array
- Added the static method getSquareString() in order to convert an x and y value to a square string (e.g. x=2, y=3 becomes "C4"). Used in the getPossibleSquare() method in each Piece class

Pre-completion 1.5:
- Override getPossibleSquares() for pieces with unlimited movement capabilites (Queen, Rook, Bishop)
- Game can now run, however without any hit detection (also the pawns' unique movement has not been accounted for yet)
