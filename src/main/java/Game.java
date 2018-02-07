
public class Game {
	Grid grid;
	int iterations = 10;
	int gridSize = 5;
	
	public Game() {
		this.grid = new Grid(this.gridSize);
	}
	
	public void start() {
		System.out.println("Generation 0");
		this.grid.display();
		
		for (int i = 0; i < this.iterations; i++) {
			System.out.println("Generation " + (i + 1));
			this.iterate();
			this.grid.display();
		}
	}
	
	public void iterate() {
		for	(int x = 0; x < this.gridSize; x++) {
			for	(int y = 0; y < this.gridSize; y++) {
				//Cell cell = this.grid.getCell(x, y);
			}
		}
	}
	
	/*public int numberOfNeighbours(int x, int y) {
		int neighbours = 0;
		
		AngleType angleType = this.grid.angleType(x, y);
		LineType lineType = this.grid.lineType(x, y);
		
		if (lineType != LineType.NONE) {
			if (angleType != AngleType.NONE) {
				
			}
		}
		
			
		return neighbours;
	}*/
	
	/*public int neightboursByAngle(AngleType angleType) {
		switch (angleType) {
		case TOP_LEFT:
			
			break;

		case TOP_RIGHT:
			
			break;
			
		case BOTTOM_LEFT:
			
			break;
			
		case BOTTOM_RIGHT:
			
			break;
			
		default:
			break;
		}
	}*/
}
