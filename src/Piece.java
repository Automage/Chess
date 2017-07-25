
public abstract class Piece {

	String name = new String(); 
	int x;
	int y;
	boolean isDead = false;
	

	public Piece(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	
}
