# Chess
Trying my hand at building Chess in Java using my knowledge of OOP so far. 

Pre-Completion 1.0:
- Abstract class 'Piece' created 
- Pawn, Rook, Knight, Bishop, King and Queen classes created and extends 'Piece' with parameters name, x, y, and isDead
- Board class created with methods create(), update(), and draw()
- Pieces had to be intialised outside any Board methods, as otherwise they would be avaliable only to the method itself (the public modifier doesnt work oh well)
- Placeholder text chessboard output added to the draw() method
