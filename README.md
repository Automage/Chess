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

