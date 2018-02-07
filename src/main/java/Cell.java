import java.util.Random;

public class Cell {
	private boolean isAlive;
	private boolean isAliveNextGeneration;
	
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
	
	public void applyNextGeneration() {
		this.isAlive = this.isAliveNextGeneration;
	}
	
	public void isAliveAtNextGeneration(boolean isAlive) {
		this.isAliveNextGeneration = isAlive;
	}
}
