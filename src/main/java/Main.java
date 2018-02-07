
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iterations = 50;
		int gameGridSize = 5;
		Game game = new Game(gameGridSize);
		
		game.numberOfIterations(iterations);
		game.start();
	}

}
