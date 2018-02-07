import java.util.Random;

public class Cell {
	private boolean isAlive;
	
	public Cell() {
		this.isAlive = (new Random()).nextBoolean();
	}
	
	public boolean alive() {
		return this.isAlive;
	}
	
	public void makeAlive() {
		this.isAlive = true;
	}
	
	public void makeDead() {
		this.isAlive = false;
	}
}
