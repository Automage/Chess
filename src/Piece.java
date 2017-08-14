
public abstract class Piece {

	String name = new String(); 
	String type = new String();
	int x;
	int y;
	boolean isDead = false;
	boolean canJump;
	

	public Piece(String name, int x, int y, String type, boolean canJump) {
		this.name = name;
		this.type = type;
		this.x = x;
		this.y = y;
		this.canJump = canJump;
		
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean getDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public boolean isCanJump() {
		return canJump;
	}

	public void setCanJump(boolean canJump) {
		this.canJump = canJump;
	}

	//Only looks at position and outputs possible moves without considering other pieces
	public abstract String[] getPossibleSquares(int x, int y, String type);
	
}
