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
